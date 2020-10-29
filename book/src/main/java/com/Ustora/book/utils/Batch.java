package com.Ustora.book.utils;

import com.Ustora.book.beans.UserBean;
import com.Ustora.book.entities.Reservation;
import com.Ustora.book.entities.Status;
import com.Ustora.book.entities.WaitingList;
import com.Ustora.book.proxies.UserProxy;
import com.Ustora.book.service.ReservationService;
import com.Ustora.book.service.WaitingListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * The type Batch.
 */
@Component
@Configuration
public class Batch {

    /**
     * The Reservation Service
     */
    @Autowired
    private ReservationService reservationService;

    /**
     * The WaitingListService
     */
    @Autowired
    private WaitingListService waitingListService;

    /**
     * The User proxy.
     */
    @Autowired
    UserProxy userProxy;

    /**
     * The Mail
     */
    @Autowired
    private Mail mail;

    /**
     * The Logger.
     */
    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Sending late mail.
     */
    @Scheduled(cron = "0 55 09 * * *")
    public void sendingLateMail() {
        logger.info("Démarrage du bacth relance mail en retard");
        List<Reservation> reservations = reservationService.findAll();
        for (Reservation reservationLate :reservations){
            logger.warn("Liste d'utilisateur pour rappel par mail");
                Date date = new Date();
                if(reservationLate.getEndBorrowing().before(date)) {
                    Optional<UserBean> userBook = userProxy.findById(reservationLate.getUserBookId());
                    mail.sendMessage(userBook.get().getEmail());
                    logger.warn("mail envoyé");
                }
            }
        logger.info("Fin du traitement Batch");
    }
    @Scheduled(cron = "0 55 09 * * *")
    public void sendingMailAvailble(){
        logger.info("Démarrage du batch pour envoyer le mail à l'utilisateur indiquant que le livre est disponible");
        List<WaitingList> waitingLists = waitingListService.findAll();
        for (WaitingList w : waitingLists){
            logger.warn("Liste des reservations en attente");
            Date date = new Date();
            if (w.getPositionInList().equals(1) && w.getStatus()==Status.enCours){
              w.setStatus(Status.enAttente);
              w.setDateMailSent(date);
            }else if(w.getPositionInList().equals(1) && w.getStatus()==Status.enAttente){
                //w.getDateMailSent().
            }
        }
    }
}
