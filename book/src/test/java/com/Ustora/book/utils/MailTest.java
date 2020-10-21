package com.Ustora.book.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.Mockito.*;

class MailTest {

    private Mail mailUnderTest;

    @BeforeEach
    void setUp() {
        mailUnderTest = new Mail();
        mailUnderTest.emailSender = mock(JavaMailSender.class);
    }

    @Test
    void testSendMessage() {
        // Setup

        // Run the test
        mailUnderTest.sendMessage("userMail");

        // Verify the results
        verify(mailUnderTest.emailSender).send(new SimpleMailMessage());
    }

    @Test
    void testSendMessage_JavaMailSenderThrowsMailException() {
        // Setup
        doThrow(MailException.class).when(mailUnderTest.emailSender).send(new SimpleMailMessage());

        // Run the test
        mailUnderTest.sendMessage("userMail");

        // Verify the results
    }
}
