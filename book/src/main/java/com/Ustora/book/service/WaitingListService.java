package com.Ustora.book.service;

import com.Ustora.book.beans.WaitingListBean;
import com.Ustora.book.dao.BookDao;
import com.Ustora.book.dao.ReservationDao;
import com.Ustora.book.dao.WaitingListDao;
import com.Ustora.book.entities.Book;
import com.Ustora.book.entities.Reservation;
import com.Ustora.book.entities.Status;
import com.Ustora.book.entities.WaitingList;
import com.Ustora.book.exceptions.AddBorrowingException;
import com.Ustora.book.exceptions.AddReservationException;
import com.Ustora.book.exceptions.AddWaitingListException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

import static com.Ustora.book.entities.Status.enAttente;
import static com.Ustora.book.entities.Status.enCours;


@Service
public class WaitingListService {

    @Autowired
    WaitingListDao waitingListDao;

    @Autowired
    BookDao bookDao;

    @Autowired
    ReservationDao reservationDao;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Save
     * @param waitingList
     */
    public void save (WaitingList waitingList){
        waitingListDao.save(waitingList);
    }

    /**
     *  Delete
     * @param id
     */
    public void deleteById(Long id){
        waitingListDao.deleteById(id);
    }

    /**
     * Find all list
     * @return all waiting list
     */
    public List<WaitingList> findAll(){
        return waitingListDao.findAll();
    }

    /**
     *
     * @param userBookId
     * @param status
     * @return
     */
    public List<WaitingList> findByUserBookIdAndStatusOrderByDateOfDemandAsc(Long userBookId, Status status){return  waitingListDao.findByUserBookIdAndStatusOrderByDateOfDemandAsc(userBookId, status);}

    /**
     *
     * @param userBookId
     * @param status
     * @return
     */
    public List<WaitingList> findAllByUserBookIdAndStatusOrderByDateOfDemandAsc(Long userBookId, Status status){return  waitingListDao.findByUserBookIdAndStatusOrderByDateOfDemandAsc(userBookId, status);}


    /**
     *
     * @param userBookId
     * @return
     */
    public List<WaitingList> findByUserBookId(Long userBookId){return  waitingListDao.findByUserBookId(userBookId);}


    /**
     *Permet de faire une réservation
     * @param bookId du livre
     * @param userBookId
     */
    public void waitingListReservation(Long bookId, Long userBookId){
        Date date = new Date();
        WaitingList waitingList = new WaitingList();
        waitingList.setBook(bookDao.findById(bookId).get());
        waitingList.setDateOfDemand(date);
        waitingList.setUserBookId(userBookId);
        waitingList.setStatus(enCours);
        List<WaitingList> waitingLists = waitingListDao.findByBookAndStatusOrderByDateOfDemandAsc(waitingList.getBook(), enCours);
        for(int i = 0; i<= waitingLists.size();i++){
            int place = i+1;
            waitingList.setPositionInList(place);
        }
        Optional<Book> book = bookDao.findById(bookId);
        Integer nbreMax = book.get().getNbreExemplaireTotal()*2;
        List<Reservation> reservationList = reservationDao.findReservationsByUserBookId(userBookId);
        for(Reservation reservation : reservationList){
            if(reservation.getBook().getId().equals(waitingList.getBook().getId())){
                logger.error("Une exception est levée ");
                throw new AddBorrowingException("AddBorrowingException");
            }
        }
        List<WaitingList> waitingListsVerif = waitingListDao.findAllByUserBookIdAndStatusOrderByDateOfDemandAsc(userBookId, enCours);
        for(WaitingList w : waitingListsVerif){
            if(w.getBook().getId().equals(waitingList.getBook().getId())){
                logger.error("Une exception est levée ");
                throw new AddReservationException("AddReservationException");
            }
        }
        if(waitingLists.size()>=nbreMax){
            logger.warn("Une exception est levée ");
            throw new AddWaitingListException("AddWaitingListException");
        }
        waitingListDao.save(waitingList);
        logger.info("Réservation demandée du livre");
    }

    /**
     * Annuler la reservation
     * @param id de la reservation
     * @param userBookId
     */
    public void cancel(Long id, Long userBookId){
        Optional<WaitingList> waitingList = waitingListDao.findById(id);
        List <WaitingList> waitingListBook = waitingListDao.findAllByBookAndStatusOrderByDateOfDemandAsc(waitingList.get().getBook(), enCours);
        for(int i =0; i<waitingListBook.size();i++){
            if(waitingListBook.get(i).getPositionInList()>waitingList.get().getPositionInList()){
                waitingListBook.get(i).setPositionInList(waitingListBook.get(i).getPositionInList()-1);
                waitingListDao.save(waitingListBook.get(i));
            }
        }
        WaitingList waitingListCancel = waitingList.get();
        waitingListCancel.setStatus(Status.annule);
        waitingListCancel.setPositionInList(null);
        waitingListDao.save(waitingListCancel);
        logger.info("L'utilisateur numéro " + userBookId + " a annuler sa reservation pour le livre " + waitingListCancel.getBook().getTitre());
    }

    /**
     *Afficher les reservations d'un utilisateur
     * @param id de l'utilisateur
     * @return waitingListBeans la liste des reservations de l'utilisateur
     */
    public List<WaitingListBean> afficherLesReservation(Long id){
        List<WaitingList> waitingLists = waitingListDao.findAllByUserBookIdOrderByDateOfDemandAsc(id);
        List<WaitingListBean> waitingListBeans = new ArrayList<>();
        for(WaitingList w : waitingLists){
            if(w.getStatus().equals(enCours) || w.getStatus().equals(enAttente)) {
                WaitingListBean listBean = new WaitingListBean();
                listBean.setWaitingList(w);
                Optional<Reservation> reservation = reservationDao.findById(w.getBook().getId());
                listBean.setReservation(reservation);
                Optional<Book> book = bookDao.findById(w.getBook().getId());
                listBean.setBook(book);
                List<Date> dates = new ArrayList<>();
                List<Reservation> reservations = reservationDao.findAll();
                for (Reservation r : reservations) {
                    List<Reservation> reservationList = reservationDao.findAllByBookIdOrderByEndBorrowingAsc(book.get().getId());
                    if (reservationList.size() > 0) {
                        Reservation resa = reservationList.get(0);
                        dates.add(resa.getEndBorrowing());
                    }
                }
                Collections.sort(dates);
                if (dates.size() > 0) {
                    Date soonerDate = dates.get(0);
                    listBean.setDateDeRetour(soonerDate);
                }
                List<WaitingList> positionWaiting = waitingListDao.findAllByBookOrderByDateOfDemandAsc(w.getBook());
                for (int i = 0; i < positionWaiting.size(); i++) {
                    if (positionWaiting.get(i).getUserBookId() == id) {
                        listBean.setPositionInList(positionWaiting.get(i).getPositionInList());
                    }
                }
                listBean.setStatus(w.getStatus());
                listBean.setId(w.getId());
                waitingListBeans.add(listBean);
            }
        }
        logger.info(" liste des réservations pour un utilisateur");
        return waitingListBeans;
    }

    public List<WaitingListBean> findByBookId(@RequestParam Long bookId) {
        List<WaitingList> waitingLists = waitingListDao.findByBookId(bookId);
        List<WaitingListBean> waitingListBeans = new ArrayList<>();
        for (WaitingList w : waitingLists) {
            if(w.getStatus().equals(enCours) || w.getStatus().equals(enAttente)) {
                WaitingListBean listBean = new WaitingListBean();
                listBean.setWaitingList(w);
                listBean.setStatus(w.getStatus());
                Optional<Reservation> reservation = reservationDao.findById(w.getBook().getId());
                listBean.setReservation(reservation);
                Optional<Book> book = bookDao.findById(w.getBook().getId());
                listBean.setBook(book);
                List<Date> dates = new ArrayList<>();
                List<Reservation> reservations = reservationDao.findAll();
                for (Reservation r : reservations) {
                    List<Reservation> reservationList = reservationDao.findAllByBookIdOrderByEndBorrowingAsc(book.get().getId());
                    if (reservationList.size() > 0) {
                        Reservation resa = reservationList.get(0);
                        dates.add(resa.getEndBorrowing());
                    }
                }
                Collections.sort(dates);
                if (dates.size() > 0) {
                    Date soonerDate = dates.get(0);
                    listBean.setDateDeRetour(soonerDate);
                }
                int nbreDeDemande = 0;
                for (int i = 0; i < waitingLists.size(); i++) {
                    if (waitingLists.get(i).getStatus() == enCours) {
                        nbreDeDemande++;
                    }
                }
                listBean.setNbreDeDemande(nbreDeDemande);
                waitingListBeans.add(listBean);
            }
        }
        return waitingListBeans;
    }

    /**
     *Afficher les reservations dont l'email a été envoyé
     * @return waitingLists la liste des reservations
     */
    public List<WaitingList> pendingAndMailSent(){
        List<WaitingList> waitingLists = waitingListDao.findByMailSendAndStatus(true, enAttente);
        return waitingLists;
    }

    /**
     * Annulation de la reservation par batch
     * @param id
     * @param userBookId
     */
    public void cancelByBatch(Long id, Long userBookId){
        Optional<WaitingList> waitingList = waitingListDao.findById(id);
        List <WaitingList> waitingListBook = waitingListDao.findAllByBookAndStatusOrderByDateOfDemandAsc(waitingList.get().getBook(), enCours);
        for(int i =0; i<waitingListBook.size();i++){
            if(waitingListBook.get(i).getPositionInList()>waitingList.get().getPositionInList()){
                waitingListBook.get(i).setPositionInList(waitingListBook.get(i).getPositionInList()-1);
                waitingListDao.save(waitingListBook.get(i));
            }
        }
        WaitingList waitingListCancel = waitingList.get();
        waitingListCancel.setStatus(Status.rejete);
        waitingListCancel.setPositionInList(null);
        waitingListDao.save(waitingListCancel);

        logger.info("L'utilisateur numéro "+userBookId+" n'a pas retiré le livre à sa dispostion dans les 48h");
    }

    public List<WaitingList> findAllByStatus(Status status) {
        List<WaitingList> waitingLists =  waitingListDao.findAllByStatus(status);
        return waitingLists;
    }
}
