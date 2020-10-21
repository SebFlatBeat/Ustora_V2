package com.Ustora.book.controller;

import com.Ustora.book.entities.Book;
import com.Ustora.book.entities.Reservation;
import com.Ustora.book.proxies.UserProxy;
import com.Ustora.book.service.BookService;
import com.Ustora.book.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
       List<Reservation> userReservationList = reservationService.findReservationsByUserBookId(userId);
        Reservation reservation = new Reservation();
        userReservationList = userReservationList.stream().filter(reservation1 -> reservation1.getBook().getId().equals(bookId)).collect(Collectors.toList());
        if (userReservationList != null &&  userReservationList.size()>0){
            logger.info("Renvoi d'un objet null si objet deja présent dans la liste ");
            return null;
        }else {
            Date aujourdhui = new Date(Calendar.getInstance().getTime().getTime());
            reservation.setBorrowing(aujourdhui);
            reservation.setEndBorrowing(reservationService.add4Weeks(reservation.getBorrowing()));
            reservation.setExtend(false);
            reservation.setUserBookId(userId);
            Optional<Book> book = bookService.findById(bookId);
            reservation.setBook(book.get());
            book.get().setNbreExemplaire(book.get().getNbreExemplaire() - 1);
            logger.info("Enregistrement de la reservation");
            reservationService.save(reservation);
        }
        logger.info("Renvoi la reservation");
        return reservation;
    }

    /**
     * Delete reservation.
     *
     * @param id the id
     */
    @PostMapping(value = "/delete/reservation")
    public void  deleteReservation (@RequestParam Long id){
        Optional<Reservation> reservation = reservationService.findById(id);
        Optional<Book> book = bookService.findById(reservation.get().getBook().getId());
        book.get().setNbreExemplaire(book.get().getNbreExemplaire() + 1);
        bookService.save(book.get());
        logger.info("Suppression de la réservation");
        reservationService.delete(reservation.get());
    }

    /**
     * Update reservation optional.
     *
     * @param id the id
     * @return optional
     */
    @PostMapping(value = "/extend/reservation")
    public Optional<Reservation> updateReservation (@RequestParam Long id){
        Optional<Reservation> reservation = reservationService.findById(id);
        reservation.get().setEndBorrowing(reservationService.add8Weeks(reservation.get().getBorrowing()));
        reservation.get().setExtend(true);
        reservationService.save(reservation.get());
        logger.info("Prolongation de la reservation de l'utilisateur");
        return reservation;
    }

    @GetMapping("/reservation/id")
    public List<Reservation> findAllReservation(@RequestParam Long bookId){
        List<Reservation> reservations = reservationService.findAllByBookId(bookId);
        return reservations;
    }
}
