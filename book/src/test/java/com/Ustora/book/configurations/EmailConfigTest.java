package com.Ustora.book.configurations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mail.javamail.JavaMailSender;

class EmailConfigTest {

    private EmailConfig emailConfigUnderTest;

    @BeforeEach
    void setUp() {
        emailConfigUnderTest = new EmailConfig();
    }

    @Test
    void testGetJavaMailSender() {
        // Setup

        // Run the test
        final JavaMailSender result = emailConfigUnderTest.getJavaMailSender();

        // Verify the results
    }
}
