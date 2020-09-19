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
        message.setSubject("Délai dépassé" );
        message.setText( "Bonjour, vous recevez cet email car votre prêt a dépassé la date limite de restitution. Nous vous prions de bien vouloir vous rendre à votre bibliothèque Ustora. Cordialement" );
        emailSender.send( message );
    }
}
