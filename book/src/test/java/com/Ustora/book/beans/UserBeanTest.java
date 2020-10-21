package com.Ustora.book.beans;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserBeanTest {

    private UserBean userBeanUnderTest;

    @BeforeEach
    void setUp() {
        userBeanUnderTest = new UserBean();
    }

    @Test
    void testToString() {
        // Setup

        // Run the test
        final String result = userBeanUnderTest.toString();

        // Verify the results
        assertEquals("result", result);
    }
}
