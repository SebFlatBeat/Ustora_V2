package com.Ustora.book.service;

import com.Ustora.book.dao.ReservationDao;
import com.Ustora.book.entities.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ReservationServiceTest {

    private ReservationService reservationServiceUnderTest;

    @BeforeEach
    void setUp() {
        reservationServiceUnderTest = new ReservationService();
        reservationServiceUnderTest.reservationDao = mock(ReservationDao.class);
    }

    @Test
    void testFindReservationsByUserBookId() {
        // Setup

        // Configure ReservationDao.findReservationsByUserBookId(...).
        final List<Reservation> reservations = Arrays.asList(new Reservation(0L, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), false));
        when(reservationServiceUnderTest.reservationDao.findReservationsByUserBookId(0L)).thenReturn(reservations);

        // Run the test
        final List<Reservation> result = reservationServiceUnderTest.findReservationsByUserBookId(0L);

        // Verify the results
    }

    @Test
    void testFindById() {
        // Setup

        // Configure ReservationDao.findById(...).
        final Optional<Reservation> reservation = Optional.of(new Reservation(0L, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), false));
        when(reservationServiceUnderTest.reservationDao.findById(0L)).thenReturn(reservation);

        // Run the test
        final Optional<Reservation> result = reservationServiceUnderTest.findById(0L);

        // Verify the results
    }

    @Test
    void testAdd4Weeks() {
        // Setup

        // Run the test
        final Date result = reservationServiceUnderTest.add4Weeks(new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());

        // Verify the results
        assertEquals(new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), result);
    }

    @Test
    void testAdd8Weeks() {
        // Setup

        // Run the test
        final Date result = reservationServiceUnderTest.add8Weeks(new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());

        // Verify the results
        assertEquals(new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), result);
    }

    @Test
    void testSave() {
        // Setup
        final Reservation reservation = new Reservation(0L, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), false);

        // Configure ReservationDao.save(...).
        final Reservation reservation1 = new Reservation(0L, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), false);
        when(reservationServiceUnderTest.reservationDao.save(any(Reservation.class))).thenReturn(reservation1);

        // Run the test
        reservationServiceUnderTest.save(reservation);

        // Verify the results
    }

    @Test
    void testDelete() {
        // Setup
        final Reservation reservation = new Reservation(0L, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), false);

        // Run the test
        reservationServiceUnderTest.delete(reservation);

        // Verify the results
        verify(reservationServiceUnderTest.reservationDao).delete(any(Reservation.class));
    }

    @Test
    void testFindAll() {
        // Setup

        // Configure ReservationDao.findAll(...).
        final List<Reservation> reservations = Arrays.asList(new Reservation(0L, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), false));
        when(reservationServiceUnderTest.reservationDao.findAll()).thenReturn(reservations);

        // Run the test
        final List<Reservation> result = reservationServiceUnderTest.findAll();

        // Verify the results
    }

    @Test
    void testFindByEndBorrowingAfter() {
        // Setup

        // Configure ReservationDao.findByEndBorrowingAfter(...).
        final List<Reservation> reservations = Arrays.asList(new Reservation(0L, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), false));
        when(reservationServiceUnderTest.reservationDao.findByEndBorrowingAfter(new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime())).thenReturn(reservations);

        // Run the test
        final List<Reservation> result = reservationServiceUnderTest.findByEndBorrowingAfter(new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());

        // Verify the results
    }
}
