package com.Ustora.book.service;

import com.Ustora.book.beans.WaitingListBean;
import com.Ustora.book.dao.ReservationDao;
import com.Ustora.book.entities.Book;
import com.Ustora.book.entities.Reservation;
import com.Ustora.book.entities.Status;
import com.Ustora.book.entities.WaitingList;
import com.Ustora.book.exceptions.AddBorrowingException;
import com.Ustora.book.exceptions.NoExtendIfEndBorrowingExceedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
class ReservationServiceTest {

    @Mock
    private ReservationDao mockReservationDao;
    @Mock
    private BookService mockBookService = new BookService();
    @Mock
    private WaitingListService mockWaitingListService = new WaitingListService();

    @InjectMocks
    private ReservationService reservationServiceUnderTest;

    private List<Book> bookListTest = new ArrayList<>();
    private List<Reservation> reservationListTest = new ArrayList<>();


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        Date dateTest = new GregorianCalendar(2020,Calendar.OCTOBER,29).getTime();
        Date add4weeks = reservationServiceUnderTest.add4Weeks(dateTest);
        Book bookSetUp1 = new Book (1L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", "2007", "section", 0, 0, 0);
        bookListTest.add(bookSetUp1);
        Book bookSetUp2 = new Book(2L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", "2007", "section", 0, 0, 0);
        bookListTest.add(bookSetUp2);

        Reservation reservationSetUp1 = new Reservation(1L,1L,dateTest,add4weeks, false);
        reservationSetUp1.setBook(bookSetUp1);
        reservationListTest.add(reservationSetUp1);
        Reservation reservationSetUp2 = new Reservation(2L,1L,dateTest,add4weeks, false);
        reservationSetUp2.setBook(bookSetUp2);
        reservationListTest.add(reservationSetUp2);

        Mockito.when(mockBookService.findById(1L)).thenReturn(Optional.of(bookSetUp1));
        Mockito.when(mockBookService.findById(2L)).thenReturn(Optional.of(bookSetUp2));

        Mockito.when(reservationServiceUnderTest.findById(1L)).thenReturn(Optional.of(reservationSetUp1));
        Mockito.when(reservationServiceUnderTest.findById(2L)).thenReturn(Optional.of(reservationSetUp2));
        Mockito.when(reservationServiceUnderTest.findReservationsByUserBookId(1L)).thenReturn(reservationListTest);
        Mockito.when(mockReservationDao.save(reservationSetUp1)).thenReturn(reservationSetUp1);
        Mockito.when(reservationServiceUnderTest.findAll()).thenReturn(reservationListTest);
    }

    @Test
    void testAdd4Weeks() {
        // Setup
        Date dateTest = new GregorianCalendar(2020,Calendar.OCTOBER,29).getTime();

        // Run the test
        final Date result = reservationServiceUnderTest.add4Weeks(dateTest);

        // Verify the results
        assertThat(result).isEqualTo("2020-11-26");
    }

    @Test
    void testAdd8Weeks() {
        // Setup
        Date dateTest = new GregorianCalendar(2020,Calendar.OCTOBER,29).getTime();

        // Run the test
        final Date result = reservationServiceUnderTest.add8Weeks(dateTest);

        // Verify the results
        assertThat(result).isEqualTo("2020-12-24");
    }

    @Test
    void testFindAll() {
        // Configure ReservationDao.findAll(...).
        final List<Reservation> reservations = reservationListTest;

        // Run the test
        final List<Reservation> result = reservationServiceUnderTest.findAll();

        // Verify the results
        assertEquals(reservations.size(), result.size());
    }

    @Test
    void testFindReservationsByUserBookId() {
        // Setup
        List<Reservation> reservations = reservationListTest;

        // Run the test
        List<Reservation> result = reservationServiceUnderTest.findReservationsByUserBookId(1L);

        // Verify the results
        assertEquals(reservations.size(),result.size());
    }

    @Test
    void testFindById() {
        // Setup
        Date dateTest = new GregorianCalendar(2020,Calendar.OCTOBER,29).getTime();
        Date add4weeks = reservationServiceUnderTest.add4Weeks(dateTest);

        // Configure ReservationDao.findById(...).
        final Optional<Reservation> reservation = Optional.of(new Reservation(0L, dateTest, add4weeks, false));
        when(mockReservationDao.findById(0L)).thenReturn(reservation);

        // Run the test
        final Optional<Reservation> result = reservationServiceUnderTest.findById(0L);

        // Verify the results
        assertEquals(reservation,result);
    }

    @Test
    void testFindByEndBorrowingAfter() {
        // Setup
        Date dateTest = new GregorianCalendar(2020,Calendar.OCTOBER,29).getTime();
        Date add4weeks = reservationServiceUnderTest.add4Weeks(dateTest);

        // Configure ReservationDao.findByEndBorrowingAfter(...).
        final List<Reservation> reservations = Arrays.asList(new Reservation(0L, dateTest, add4weeks, false));
        when(mockReservationDao.findByEndBorrowingAfter(add4weeks)).thenReturn(reservations);

        // Run the test
        final List<Reservation> result = reservationServiceUnderTest.findByEndBorrowingAfter(add4weeks);

        // Verify the results
        assertEquals(reservations.size(),result.size());
    }

    @Test
    void testFindAllByBookId() {
        // Setup
        Date dateTest = new GregorianCalendar(2020,Calendar.OCTOBER,29).getTime();
        Date add4weeks = reservationServiceUnderTest.add4Weeks(dateTest);

        // Configure ReservationDao.findAllByBookIdOrderByEndBorrowingAsc(...).
        final List<Reservation> reservations = Arrays.asList(new Reservation(0L, dateTest, add4weeks, false));
        when(mockReservationDao.findAllByBookIdOrderByEndBorrowingAsc(0L)).thenReturn(reservations);

        // Run the test
        final List<Reservation> result = reservationServiceUnderTest.findAllByBookId(0L);

        // Verify the results
        assertEquals(reservations.size(),result.size());
    }

    @Test
    void testSaveReservationException() {
        // Setup
        Date dateTest = new GregorianCalendar(2020,Calendar.OCTOBER,29).getTime();
        Date add4weeks = reservationServiceUnderTest.add4Weeks(dateTest);
        Book otherBook = new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", "2007", "section", 0, 0, 0);

        // Configure BookService.findById(...).
        final Book book = new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", "2007", "section", 0, 0, 0);
        when(mockBookService.findById(0L)).thenReturn(Optional.of(book));

        // Configure ReservationDao.findReservationsByUserBookId(...).
        Reservation reservationParam = new Reservation(0L,3L, dateTest, add4weeks, false);
        reservationParam.setBook(otherBook);
        assertThat(reservationParam).hasNoNullFieldsOrProperties();

        final List<Reservation> reservations = Arrays.asList(reservationParam);
        doReturn(reservations).when(mockReservationDao).findReservationsByUserBookId(3L);

        // Configure ReservationDao.save(...).
        final Reservation reservation = new Reservation(3L, dateTest, add4weeks, false);
        when(mockReservationDao.save(any(Reservation.class))).thenReturn(reservation);

        // Run the test
        try {
            final Reservation result = reservationServiceUnderTest.saveReservation(0L, 3L);
            // Verify the results
            verify(mockReservationDao).save(result);
        }catch (AddBorrowingException e){
            assertThat(e.getMessage()).isEqualTo("AddBorrowingException");
        }
    }

    @Test()
    void testUpdateReservationException() {
        // Setup
        Date dateTest = new GregorianCalendar(2020,Calendar.OCTOBER,29).getTime();
        Date add4Weeks = reservationServiceUnderTest.add4Weeks(dateTest);

        // Configure ReservationDao.findById(...).
        final Optional<Reservation> reservation = Optional.of(new Reservation(0L,dateTest, add4Weeks, false));
        when(mockReservationDao.findById(0L)).thenReturn(reservation);

        // Run the test
        try {
            final Optional<Reservation> result = reservationServiceUnderTest.updateReservation(0L);
        }catch (NoExtendIfEndBorrowingExceedException e){
            // Verify the results
            assertThat(e.getMessage()).isEqualTo("NoExtendIfEndBorrowingExceedException");
        }
    }
}
