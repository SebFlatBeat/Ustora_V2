package com.Ustora.book.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReservationTest {

    private Reservation reservationUnderTest;

    @BeforeEach
    void setUp() {
        reservationUnderTest = new Reservation(0L, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), false);
    }

    @Test
    void testToString() {
        // Setup

        // Run the test
        final String result = reservationUnderTest.toString();

        // Verify the results
        assertEquals("result", result);
    }
}
