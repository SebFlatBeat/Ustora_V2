package com.Ustora.book.service;


import com.Ustora.book.dao.ReservationDao;
import com.Ustora.book.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
     * Find by end borrowing after list.
     *
     * @param endBorrowing the end borrowing
     * @return the list
     */
    public List<Reservation> findByEndBorrowingAfter(@Param("endBorrowing") Date endBorrowing){
       return reservationDao.findByEndBorrowingAfter(endBorrowing);
    }
}

