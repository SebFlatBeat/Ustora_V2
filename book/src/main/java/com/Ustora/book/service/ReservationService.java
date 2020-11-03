package com.Ustora.book.service;


import com.Ustora.book.beans.WaitingListBean;
import com.Ustora.book.dao.ReservationDao;
import com.Ustora.book.entities.Book;
import com.Ustora.book.entities.Reservation;
import com.Ustora.book.exceptions.AddBorrowingException;
import com.Ustora.book.exceptions.NoExtendIfEndBorrowingExceedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The type Reservation service.
 */
@Service
public class ReservationService {

    /**
     * The Reservation dao.
     */
    @Autowired
    ReservationDao reservationDao;

    /**
     * The Book Service
     */
    @Autowired
    private BookService bookService;

    /**
     * THe WaitingList Service
     */
    @Autowired
    private WaitingListService waitingListService;


    /**
     * The Logger.
     */
    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Add 4 weeks java . util . date.
     *
     * @param date the date
     * @return the java . util . date
     */
    public java.util.Date add4Weeks(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_MONTH, 4);
        return calendar.getTime();
    }


    /**
     * Add 8 weeks java . util . date.
     *
     * @param date the date
     * @return the java . util . date
     */
    public java.util.Date add8Weeks(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_MONTH, 8);
        return calendar.getTime();
    }


    /**
     * Save.
     *
     * @param reservation the reservation
     */
    public void save (Reservation reservation){
        reservationDao.save(reservation);
    }

    /**
     * Delete.
     *
     * @param reservation the reservation
     */
    public void delete (Reservation reservation) {
        reservationDao.delete(reservation);
    }

    /**
     * Find all list .
     *
     * @return the list
     */
    public List <Reservation> findAll() {
        return reservationDao.findAll();
    }

    /**
     * Find reservations by user book id list.
     *
     * @param userId the user id
     * @return the list
     */
    public List<Reservation> findReservationsByUserBookId (Long userId){
        return reservationDao.findReservationsByUserBookId(userId);
    }

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    public Optional<Reservation> findById(Long id){
        return reservationDao.findById(id);
    }

    /**
     * Find by end borrowing after list.
     *
     * @param endBorrowing the end borrowing
     * @return the list
     */
    public List<Reservation> findByEndBorrowingAfter(@Param("endBorrowing") Date endBorrowing){
        return reservationDao.findByEndBorrowingAfter(endBorrowing);
    }

    /**
     *
     * @param bookId
     * @return
     */
    public List<Reservation> findAllByBookId(@RequestParam Long bookId) {
        return reservationDao.findAllByBookIdOrderByEndBorrowingAsc(bookId);
    }

    /**
     * Extension of 8 weeks for a Loan
     * @param id
     * @return reservation
     */
    public  Optional<Reservation> updateReservation(@RequestParam Long id){
        Date date = new Date();
        Optional<Reservation> reservation = reservationDao.findById(id);
        if(reservation.get().getEndBorrowing().before(date)){
            throw new NoExtendIfEndBorrowingExceedException("NoExtendIfEndBorrowingExceedException");
        }
        reservation.get().setEndBorrowing(add8Weeks(reservation.get().getBorrowing()));
        reservation.get().setExtend(true);
        reservationDao.save(reservation.get());
        return reservation;
    }

    public Optional<Reservation> deleteReservation(@RequestParam Long id){
        Optional<Reservation> reservation = reservationDao.findById(id);
        Optional<Book> book = bookService.findById(reservation.get().getBook().getId());
        List <WaitingListBean> waitingList = waitingListService.findByBookId(reservation.get().getBook().getId());
        if(waitingList.size()!=0) {
            book.get().setNbreDispoPourLaWaitingList(book.get().getNbreDispoPourLaWaitingList() + 1);
        }else if(waitingList.size()==0){
            book.get().setNbreExemplaire(book.get().getNbreExemplaire()+book.get().getNbreDispoPourLaWaitingList());
            book.get().setNbreDispoPourLaWaitingList(0);
        }else {
            book.get().setNbreExemplaire(book.get().getNbreExemplaire()+1);
        }
        bookService.save(book.get());
        reservationDao.delete(reservation.get());
        return reservation;
    }

    public Reservation saveReservation(@RequestParam Long bookId, @RequestParam Long userId){
        List<Reservation> userReservationList = reservationDao.findReservationsByUserBookId(userId);
        Reservation reservation = new Reservation();
        userReservationList = userReservationList.stream().filter(reservation1 -> reservation1.getBook().getId().equals(bookId)).collect(Collectors.toList());
        if (userReservationList != null &&  userReservationList.size()>0) {
            logger.error("Une exception est levée ");
            throw new AddBorrowingException("AddBorrowingException");
        }else {
            java.util.Date aujourdhui = new java.util.Date(Calendar.getInstance().getTime().getTime());
            reservation.setBorrowing(aujourdhui);
            reservation.setEndBorrowing(add4Weeks(reservation.getBorrowing()));
            reservation.setExtend(false);
            reservation.setUserBookId(userId);
            Optional<Book> book = bookService.findById(bookId);
            reservation.setBook(book.get());
            book.get().setNbreExemplaire(book.get().getNbreExemplaire() - 1);
            logger.info("Enregistrement de la reservation");
            reservationDao.save(reservation);
        }
        logger.info("Renvoi la reservation");
        return reservation;
    }

    public Reservation saveReservationFromWaitingList(Long bookId, Long userId) {
        Reservation reservation = new Reservation();
        Date aujourdhui = new Date();
        reservation.setBorrowing(aujourdhui);
        reservation.setEndBorrowing(add4Weeks(reservation.getBorrowing()));
        reservation.setExtend(false);
        reservation.setUserBookId(userId);
        Optional<Book> book = bookService.findById(bookId);
        reservation.setBook(book.get());
        book.get().setNbreDispoPourLaWaitingList(book.get().getNbreDispoPourLaWaitingList() - 1);
        logger.info("Enregistrement de la reservation suite à la mise à disposition pendant 48h");
        reservationDao.save(reservation);
        return reservation;
    }
}

