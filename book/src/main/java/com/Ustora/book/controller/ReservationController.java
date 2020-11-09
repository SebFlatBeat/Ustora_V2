package com.Ustora.book.controller;

import com.Ustora.book.entities.Reservation;
import com.Ustora.book.service.BookService;
import com.Ustora.book.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


/**
 * The type Reservation controller.
 */
@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private BookService bookService;

    /**
     * The Logger.
     */
    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Find reservation list.
     *
     * @param userId the user id
     * @return list
     */
    @GetMapping("/reservation")
    public List<Reservation> findReservation(@RequestParam Long userId){
        List<Reservation> reservationList = reservationService.findReservationsByUserBookId(userId);
        logger.info("Renvoi la liste de reservation de l'utilisateur");
        return reservationList;
    }

    /**
     * Save reservation reservation.
     *
     * @param bookId the book id
     * @param userId the user id
     * @return reservation
     */
    @PostMapping(value = "/save/reservation")
    public Reservation saveReservation(@RequestParam Long bookId, @RequestParam Long userId){
        Reservation reservation = reservationService.saveReservation(bookId,userId);
        return reservation;
    }

    @PostMapping(value = "/save/reservationFromWaitingList")
    public Reservation saveReservationFromWaitingList(@RequestParam Long bookId, @RequestParam Long userId){
        Reservation reservation = reservationService.saveReservationFromWaitingList(bookId,userId);
        return reservation;
    }

    /**
     * Delete reservation.
     *
     * @param id the id
     */
    @PostMapping(value = "/delete/reservation")
    public void  deleteReservation (@RequestParam Long id){
        reservationService.deleteReservation(id);
        logger.info("Suppression de la réservation");
    }

    /**
     * Update reservation optional.
     *
     * @param id the id
     * @return optional
     */
    @PostMapping(value = "/extend/reservation")
    public Optional<Reservation> updateReservation (@RequestParam Long id){
        Optional<Reservation> reservation = reservationService.updateReservation(id);
        logger.info("Prolongation de la reservation de l'utilisateur");
       return reservation;
    }

    @GetMapping("/reservation/id")
    public List<Reservation> findAllReservation(@RequestParam Long bookId){
        List<Reservation> reservations = reservationService.findAllByBookId(bookId);
        return reservations;
    }
}