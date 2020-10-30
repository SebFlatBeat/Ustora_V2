package com.Ustora.book.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * The type Mail.
 */
@Component
public class Mail {

    /**
     * The Email sender.
     */
    @Autowired
    public JavaMailSender emailSender;

    /**
     * The Logger.
     */
    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Send message.
     *
     * @param userMail the user mail
     */
    public void sendMessage(String userMail) {
        logger.info("Création de l'email");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(userMail);
        message.setSubject("Délai dépassé");
        message.setText("Bonjour, vous recevez cet email car votre prêt a dépassé la date limite de restitution. Nous vous prions de bien vouloir vous rendre à votre bibliothèque Ustora. Cordialement" );
        emailSender.send(message);
    }

    public void sendAvailableMessage(String userMail){
        logger.info("Création de l'email");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(userMail);
        message.setSubject("Livre Disponible pour vous pendant 48h");
        message.setText("Bonjour, nous avons le plaisir de vous informer que le livre que vous avez réservé est enfin disponible. Nous prions de bien vouloir vous manifester pour le recupérer dans un délai de 48H. Une fois ce delai depassé, votre reservation sera annulée. Bien cordialement");
        emailSender.send(message);
    }
}
