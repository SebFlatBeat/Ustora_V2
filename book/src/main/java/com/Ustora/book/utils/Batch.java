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

    @Scheduled(cron = "0 08 01 * * *")
    public void sendingMailAvailble(){
        logger.info("Démarrage du batch pour envoyer le mail à l'utilisateur indiquant que le livre est disponible");
        List<WaitingList> waitingLists = waitingListService.findAllByStatus(Status.enCours);
        for (WaitingList w : waitingLists){
            logger.warn("Liste des reservations en attente");
            Date date = new Date();
            if (w.getPositionInList().equals(1)){
                w.setStatus(Status.enAttente);
                w.setDateMailSent(date);
                w.setMailSend(true);
                Optional<UserBean> userBook = userProxy.findById(w.getUserBookId());
                mail.sendAvailableMessage(userBook.get().getEmail());
                logger.warn("mail envoyé");
                waitingListService.save(w);
            }
        }logger.info("Fin du traitement Batch");
    }

    @Scheduled(cron = "0 15 01 * * *")
    public void cancellingReservation(){
        List <WaitingList> waitingLists = waitingListService.pendingAndMailSent();
        for (WaitingList w : waitingLists){
            Date date = new Date();
            boolean moreOfTwoDays = Math.abs(w.getDateMailSent().getTime() - date.getTime()) > Permanent.MILLIS_PER_TWO_DAY;
            if(moreOfTwoDays){
                waitingListService.cancelByBatch(w.getId(),w.getUserBookId());
            }
        }

    }
}
