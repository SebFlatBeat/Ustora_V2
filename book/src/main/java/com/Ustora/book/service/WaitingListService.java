package com.Ustora.book.service;

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

import java.util.Date;
import java.util.List;


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
     *
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
     * Find all user waitingList
     * @param userBookId
     * @return user waiting list
     */
    public List<WaitingList> findByUserBookIdAndStatusOrderByDateOfDemandAsc(Long userBookId, Status status){return  waitingListDao.findByUserBookIdAndStatusOrderByDateOfDemandAsc(userBookId, status);}

    /**
     *
     * @param userBookId
     * @return
     */
    public List<WaitingList> findByUserBookId(Long userBookId){return  waitingListDao.findByUserBookId(userBookId);}


    public void waitingListReservation(Long id, Long userBookId){

        Date date = new Date();
        WaitingList waitingList = new WaitingList();
        waitingList.setBook(bookDao.findById(id).get());
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
        Book book = new Book();
        Integer nbreMax = book.getNbreExemplaireTotal()*2;

        //Verifie que l'utilisateur n'a pas déjà le livre en emprunt
        List<Reservation> reservationList = reservationDao.findReservationsByUserBookId(userBookId);
        for(Reservation reservation : reservationList){
            if(reservation.getBook().getId().equals(waitingList.getBook().getId())){

            }
        }
        //Verification de la place restante dans la liste
        if(waitingLists.size()<=nbreMax){

        }
        waitingListDao.save(waitingList);
        logger.info("Réservation demander du livre");
    }

}
