package com.Ustora.book.service;

import com.Ustora.book.beans.WaitingListBean;
import com.Ustora.book.dao.ReservationDao;
import com.Ustora.book.entities.Book;
import com.Ustora.book.entities.Reservation;
import com.Ustora.book.entities.Status;
import com.Ustora.book.entities.WaitingList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

@ExtendWith(SpringExtension.class)
class ReservationServiceTest {

    @Mock
    private ReservationDao mockReservationDao;
    @Mock
    private BookService mockBookService;
    @Mock
    private WaitingListService mockWaitingListService;

    @InjectMocks
    private ReservationService reservationServiceUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void testAdd4Weeks() {
        // Setup
        Date date = new Date();

        // Run the test
        final Date result = reservationServiceUnderTest.add4Weeks(date);

        // Verify the results
        assertNotEquals(date, result);
    }

    @Test
    void testAdd8Weeks() {
        // Setup
        Date date = new Date();

        // Run the test
        final Date result = reservationServiceUnderTest.add8Weeks(date);

        // Verify the results
        assertNotEquals(date, result);
    }

    @Test
    void testSave() {
        // Setup
        Date date = new Date();
        Date add4weeks = reservationServiceUnderTest.add4Weeks(date);
        final Reservation reservation = new Reservation(0L,date,add4weeks, false);

        // Configure ReservationDao.save(...).
        final Reservation reservation1 = new Reservation(0L, date, add4weeks, false);
        when(mockReservationDao.save(any(Reservation.class))).thenReturn(reservation1);

        // Run the test
        reservationServiceUnderTest.save(reservation);

        // Verify the results
        verify(mockReservationDao).save(reservation);
    }

    @Test
    void testDelete() {
        // Setup
        Date date = new Date();
        Date add4weeks = reservationServiceUnderTest.add4Weeks(date);
        final Reservation reservation = new Reservation(0L, date,add4weeks, false);

        // Run the test
        reservationServiceUnderTest.delete(reservation);

        // Verify the results
        verify(mockReservationDao).delete(any(Reservation.class));
    }

    @Test
    void testFindAll() {
        // Setup
        Date date = new Date();
        Date add4weeks = reservationServiceUnderTest.add4Weeks(date);

        // Configure ReservationDao.findAll(...).
        final List<Reservation> reservations = Arrays.asList(new Reservation(0L, date, add4weeks, false));
        when(mockReservationDao.findAll()).thenReturn(reservations);

        // Run the test
        final List<Reservation> result = reservationServiceUnderTest.findAll();

        // Verify the results
        assertEquals(reservations.size(), result.size());
    }

    @Test
    void testFindReservationsByUserBookId() {
        // Setup
        Date date = new Date();
        Date add4weeks = reservationServiceUnderTest.add4Weeks(date);

        // Configure ReservationDao.findReservationsByUserBookId(...).
        final List<Reservation> reservations = Arrays.asList(new Reservation(0L, date, add4weeks, false));
        when(mockReservationDao.findReservationsByUserBookId(0L)).thenReturn(reservations);

        // Run the test
        final List<Reservation> result = reservationServiceUnderTest.findReservationsByUserBookId(0L);

        // Verify the results
        assertEquals(reservations.size(),result.size());
    }

    @Test
    void testFindById() {
        // Setup
        Date date = new Date();
        Date add4weeks = reservationServiceUnderTest.add4Weeks(date);

        // Configure ReservationDao.findById(...).
        final Optional<Reservation> reservation = Optional.of(new Reservation(0L, date, add4weeks, false));
        when(mockReservationDao.findById(0L)).thenReturn(reservation);

        // Run the test
        final Optional<Reservation> result = reservationServiceUnderTest.findById(0L);

        // Verify the results
        assertEquals(reservation,result);
    }

    @Test
    void testFindByEndBorrowingAfter() {
        // Setup
        Date date = new Date();
        Date add4weeks = reservationServiceUnderTest.add4Weeks(date);

        // Configure ReservationDao.findByEndBorrowingAfter(...).
        final List<Reservation> reservations = Arrays.asList(new Reservation(0L, date, add4weeks, false));
        when(mockReservationDao.findByEndBorrowingAfter(add4weeks)).thenReturn(reservations);

        // Run the test
        final List<Reservation> result = reservationServiceUnderTest.findByEndBorrowingAfter(add4weeks);

        // Verify the results
        assertEquals(reservations.size(),result.size());
    }

    @Test
    void testFindAllByBookId() {
        // Setup
        Date date = new Date();
        Date add4weeks = reservationServiceUnderTest.add4Weeks(date);

        // Configure ReservationDao.findAllByBookIdOrderByEndBorrowingAsc(...).
        final List<Reservation> reservations = Arrays.asList(new Reservation(0L, date, add4weeks, false));
        when(mockReservationDao.findAllByBookIdOrderByEndBorrowingAsc(0L)).thenReturn(reservations);

        // Run the test
        final List<Reservation> result = reservationServiceUnderTest.findAllByBookId(0L);

        // Verify the results
        assertEquals(reservations.size(),result.size());
    }

    @Test
    void testUpdateReservation() {
        // Setup
        Date date = new Date();
        Date add4Weeks = reservationServiceUnderTest.add4Weeks(date);

        // Configure ReservationDao.findById(...).
        final Optional<Reservation> reservation = Optional.of(new Reservation(0L,date, add4Weeks, false));
        when(mockReservationDao.findById(0L)).thenReturn(reservation);

        // Run the test
        final Optional<Reservation> result = reservationServiceUnderTest.updateReservation(0L);

        // Verify the results
        assertEquals(reservation,result);
    }

    @Test
    void testDeleteReservation() {
        // Setup
        Date date = new Date();
        Date add4Weeks = reservationServiceUnderTest.add4Weeks(date);

        // Configure BookService.findById(...).
        final Optional <Book> book = Optional.of(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new java.sql.Date(0L), "section", 0, 0, 0));
        when(mockBookService.findById(Mockito.any())).thenReturn(book);

        // Configure ReservationDao.findById(...).
        final Optional<Reservation> reservation = Optional.of(new Reservation(0L, date, add4Weeks, false));
        reservation.get().setBook(book.get());
        doReturn(reservation).when(mockReservationDao).findById(Mockito.any());

        // Configure WaitingListService.findByBookId(...).
        final WaitingListBean listBean = new WaitingListBean();
        listBean.setBook(book);
        listBean.setReservation(Optional.of(new Reservation(0L, date, add4Weeks, false)));
        listBean.setId(0L);
        listBean.setWaitingList(new WaitingList(0L, 0L, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), 0, false, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), Status.enCours, new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new java.sql.Date(0L), "section", 0, 0, 0)));
        listBean.setDateDeRetour(add4Weeks);
        listBean.setPositionInList(0);
        listBean.setStatus(Status.enCours);
        listBean.setNbreDeDemande(0);
        final List<WaitingListBean> waitingListBeans = Arrays.asList(listBean);
        when(mockWaitingListService.findByBookId(0L)).thenReturn(waitingListBeans);

        // Run the test
        final Optional<Reservation> result = reservationServiceUnderTest.deleteReservation(0L);

        // Verify the results
        verify(mockBookService).save(any(Book.class));
        verify(mockReservationDao).delete(any(Reservation.class));
        verify(mockReservationDao).delete(result.get());
    }

    @Test
    void testSaveReservation() {
        // Setup
        Date date = new Date();
        Date add4weeks = reservationServiceUnderTest.add4Weeks(date);
        Book book = new Book(3L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new java.sql.Date(0L), "section", 0, 0, 0);

        // Configure BookService.findById(...).
        final Book bookConfig = new Book(3L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new java.sql.Date(0L), "section", 0, 0, 0);
        when(mockBookService.findById(3L)).thenReturn(Optional.of(bookConfig));

        // Configure ReservationDao.findReservationsByUserBookId(...).
        Reservation reservationParam = new Reservation(3L,3L, date, add4weeks, false);
        reservationParam.setBook(bookConfig);
        final List<Reservation> reservations = Arrays.asList(reservationParam);
        doReturn(reservations).when(mockReservationDao).findReservationsByUserBookId(3L);
       // when(mockReservationDao.findReservationsByUserBookId(0L)).thenReturn(reservations);

        // Configure ReservationDao.save(...).
        final Reservation reservation = new Reservation(3L,3L, date, add4weeks, false);
        when(mockReservationDao.save(any(Reservation.class))).thenReturn(reservation);

        // Run the test
        final Reservation result = reservationServiceUnderTest.saveReservation(3L, 3L);

        // Verify the results
        verify(mockReservationDao).save(result);
    }

    @Test
    void testSaveReservationFromWaitingList() {
        // Setup
        Date date = new Date();
        Date add4Weeks = reservationServiceUnderTest.add4Weeks(date);

        // Configure BookService.findById(...).
        final Optional<Book> book = Optional.of(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new java.sql.Date(0L), "section", 0, 0, 0));
        when(mockBookService.findById(0L)).thenReturn(book);

        // Configure ReservationDao.save(...).
        final Reservation reservation = new Reservation(0L, date, add4Weeks, false);
        when(mockReservationDao.save(any(Reservation.class))).thenReturn(reservation);

        // Run the test
        final Reservation result = reservationServiceUnderTest.saveReservationFromWaitingList(0L, 0L);

        // Verify the results
        verify(mockReservationDao).save(result);
    }
}
