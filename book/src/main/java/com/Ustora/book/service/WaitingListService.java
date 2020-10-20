package com.Ustora.book.service;

import com.Ustora.book.beans.WaitingListBean;
import com.Ustora.book.dao.BookDao;
import com.Ustora.book.dao.ReservationDao;
import com.Ustora.book.dao.WaitingListDao;
import com.Ustora.book.entities.Book;
import com.Ustora.book.entities.Reservation;
import com.Ustora.book.entities.Status;
import com.Ustora.book.entities.WaitingList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


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
        waitingList.setStatus(Status.enCours);

        List<WaitingList> waitingLists = waitingListDao.findByBookAndStatusOrderByDateOfDemandAsc(waitingList.getBook(),Status.enCours);
        //Determine la place dans la liste de reservation
        for(int i = 0; i<= waitingLists.size();i++){
            int place = i+1;
            waitingList.setPositionInList(place);
        }
        //Détermine le nombre maximum dans une liste de reservation
        Optional<Book> book = bookDao.findById(bookId);
        Integer nbreMax = book.get().getNbreExemplaireTotal()*2;

        //Verifie que l'utilisateur n'a pas déjà le livre en emprunt
        List<Reservation> reservationList = reservationDao.findReservationsByUserBookId(userBookId);
        for(Reservation reservation : reservationList){
            if(reservation.getBook().getId().equals(waitingList.getBook().getId())){
                //TODO ajouter ma propre exception
            throw new IllegalArgumentException();
            }
        }
        //Verification de la place restante dans la liste
        if(waitingLists.size()>=nbreMax){
            //TODO ajouter ma propre exception
            throw new IllegalArgumentException();
        }
        waitingListDao.save(waitingList);
        logger.info("Réservation demander du livre");
    }

    /**
     * Annuler la reservation
     * @param id de la reservation
     * @param userBookId
     */
    public void cancel(Long id, Long userBookId){
        Optional<WaitingList> waitingList = waitingListDao.findById(id);
        WaitingList waitingListCancel = waitingList.get();
        waitingListCancel.setStatus(Status.rejete);
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

        List<WaitingList> waitingLists = waitingListDao.findAllByUserBookIdAndStatusOrderByDateOfDemandAsc(id, Status.enCours);
        List<WaitingListBean> waitingListBeans = new ArrayList<>();

        for(WaitingList w : waitingLists){
            WaitingListBean listBean = new WaitingListBean();
            listBean.setWaitingList(w);
            Optional<Reservation> reservation = reservationDao.findById(w.getBook().getId());
            listBean.setReservation(reservation);
            Optional<Book> book = bookDao.findById(w.getBook().getId());
            listBean.setBook(book);

            List<Date> dates = new ArrayList<>();
            List<Reservation> reservations = reservationDao.findAll();
            for(Reservation r : reservations) {
                List<Reservation> reservationList = reservationDao.findAllByBookIdOrderByEndBorrowingAsc(book.get().getId());
                if (reservationList.size() > 0) {
                    Reservation resa = reservationList.get(0);
                    dates.add(resa.getEndBorrowing());
                }
            }
            Collections.sort(dates);
            if(dates.size()>0){
            Date soonerDate = dates.get(0);
            listBean.setDateDeRetour(soonerDate);
            }

            List<WaitingList> positionWaiting = waitingListDao.findAllByBookAndStatusOrderByDateOfDemandAsc(book.get(), Status.enCours);
            for(int i = 0; i< positionWaiting.size(); i++){
                if(positionWaiting.get(i).getUserBookId() == id){
                    listBean.setPositionInList(i + 1);
                }
            }
            listBean.setId(w.getId());
            waitingListBeans.add(listBean);
        }
        logger.info(" liste des réservations pour un utilisateur");
        return waitingListBeans;
    }

    /**
     *Afficher les reservations dont l'email a été envoyé
     * @return waitingLists la liste des reservations
     */
    public List<WaitingList> pendingAndMailSent(){
        List<WaitingList> waitingLists = waitingListDao.findByMailSendAndStatus(true,Status.enAttente);
        return waitingLists;
    }

}
