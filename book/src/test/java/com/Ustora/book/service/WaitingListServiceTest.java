package com.Ustora.book.service;

import com.Ustora.book.beans.WaitingListBean;
import com.Ustora.book.dao.BookDao;
import com.Ustora.book.dao.ReservationDao;
import com.Ustora.book.dao.WaitingListDao;
import com.Ustora.book.entities.Book;
import com.Ustora.book.entities.Reservation;
import com.Ustora.book.entities.Status;
import com.Ustora.book.entities.WaitingList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class WaitingListServiceTest {

    private WaitingListService waitingListServiceUnderTest;
    private ReservationService reservationServiceUnderTest;

    @BeforeEach
    void setUp() {
        waitingListServiceUnderTest = new WaitingListService();
        waitingListServiceUnderTest.waitingListDao = mock(WaitingListDao.class);
        waitingListServiceUnderTest.bookDao = mock(BookDao.class);
        waitingListServiceUnderTest.reservationDao = mock(ReservationDao.class);
    }

    @Test
    void testFindAll() {
        // Setup
        Date dateTest = new GregorianCalendar(2020,Calendar.OCTOBER,29).getTime();
        Date add4Weeks = reservationServiceUnderTest.add4Weeks(dateTest);

        // Configure WaitingListDao.findAll(...).
        final List<WaitingList> waitingLists = Arrays.asList(new WaitingList(0L, 0L, dateTest, 0, false,add4Weeks, Status.enCours, new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", "anneeEdition", "section", 0, 0, 0)));
        when(waitingListServiceUnderTest.waitingListDao.findAll()).thenReturn(waitingLists);

        // Run the test
        final List<WaitingList> result = waitingListServiceUnderTest.findAll();

        // Verify the results
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    void testFindByUserBookIdAndStatusOrderByDateOfDemandAsc() {
        // Setup
        Date dateTest = new GregorianCalendar(2020,Calendar.OCTOBER,29).getTime();
        Date add4Weeks = reservationServiceUnderTest.add4Weeks(dateTest);

        // Configure WaitingListDao.findByUserBookIdAndStatusOrderByDateOfDemandAsc(...).
        final List<WaitingList> waitingLists = Arrays.asList(new WaitingList(0L, 0L, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), 0, false, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), Status.enCours, new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", "anneeEdition", "section", 0, 0, 0)));
        when(waitingListServiceUnderTest.waitingListDao.findByUserBookIdAndStatusOrderByDateOfDemandAsc(0L, Status.enCours)).thenReturn(waitingLists);

        // Run the test
        final List<WaitingList> result = waitingListServiceUnderTest.findByUserBookIdAndStatusOrderByDateOfDemandAsc(0L, Status.enCours);

        // Verify the results
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    void testFindAllByUserBookIdAndStatusOrderByDateOfDemandAsc() {
        // Setup
        Date dateTest = new GregorianCalendar(2020,Calendar.OCTOBER,29).getTime();
        Date add4Weeks = reservationServiceUnderTest.add4Weeks(dateTest);

        // Configure WaitingListDao.findByUserBookIdAndStatusOrderByDateOfDemandAsc(...).
        final List<WaitingList> waitingLists = Arrays.asList(new WaitingList(0L, 0L, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), 0, false, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), Status.enCours, new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", "anneeEdition", "section", 0, 0, 0)));
        when(waitingListServiceUnderTest.waitingListDao.findByUserBookIdAndStatusOrderByDateOfDemandAsc(0L, Status.enCours)).thenReturn(waitingLists);

        // Run the test
        final List<WaitingList> result = waitingListServiceUnderTest.findAllByUserBookIdAndStatusOrderByDateOfDemandAsc(0L, Status.enCours);

        // Verify the results
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    void testFindByUserBookId() {
        // Setup
        Date dateTest = new GregorianCalendar(2020,Calendar.OCTOBER,29).getTime();
        Date add4Weeks = reservationServiceUnderTest.add4Weeks(dateTest);

        // Configure WaitingListDao.findByUserBookId(...).
        final List<WaitingList> waitingLists = Arrays.asList(new WaitingList(0L, 0L, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), 0, false, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), Status.enCours, new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", "anneeEdition", "section", 0, 0, 0)));
        when(waitingListServiceUnderTest.waitingListDao.findByUserBookId(0L)).thenReturn(waitingLists);

        // Run the test
        final List<WaitingList> result = waitingListServiceUnderTest.findByUserBookId(0L);

        // Verify the results
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    void testAfficherLesReservation() {
        // Setup
        Date dateTest = new GregorianCalendar(2020,Calendar.OCTOBER,29).getTime();
        Date add4Weeks = reservationServiceUnderTest.add4Weeks(dateTest);

        // Configure WaitingListDao.findAllByUserBookIdOrderByDateOfDemandAsc(...).
        final List<WaitingList> waitingLists = Arrays.asList(new WaitingList(0L, 0L, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), 0, false, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), Status.enCours, new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", "anneeEdition", "section", 0, 0, 0)));
        when(waitingListServiceUnderTest.waitingListDao.findAllByUserBookIdOrderByDateOfDemandAsc(0L)).thenReturn(waitingLists);

        // Configure ReservationDao.findById(...).
        final Optional<Reservation> reservation = Optional.of(new Reservation(0L, 0L, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), false));
        when(waitingListServiceUnderTest.reservationDao.findById(0L)).thenReturn(reservation);

        // Configure BookDao.findById(...).
        final Optional<Book> book = Optional.of(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", "anneeEdition", "section", 0, 0, 0));
        when(waitingListServiceUnderTest.bookDao.findById(0L)).thenReturn(book);

        // Configure ReservationDao.findAll(...).
        final List<Reservation> reservations = Arrays.asList(new Reservation(0L, 0L, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), false));
        when(waitingListServiceUnderTest.reservationDao.findAll()).thenReturn(reservations);

        // Configure ReservationDao.findAllByBookIdOrderByEndBorrowingAsc(...).
        final List<Reservation> reservations1 = Arrays.asList(new Reservation(0L, 0L, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), false));
        when(waitingListServiceUnderTest.reservationDao.findAllByBookIdOrderByEndBorrowingAsc(0L)).thenReturn(reservations1);

        // Configure WaitingListDao.findAllByBookOrderByDateOfDemandAsc(...).
        final List<WaitingList> waitingLists1 = Arrays.asList(new WaitingList(0L, 0L, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), 0, false, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), Status.enCours, new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", "anneeEdition", "section", 0, 0, 0)));
        when(waitingListServiceUnderTest.waitingListDao.findAllByBookOrderByDateOfDemandAsc(any(Book.class))).thenReturn(waitingLists1);

        // Run the test
        final List<WaitingListBean> result = waitingListServiceUnderTest.afficherLesReservation(0L);

        // Verify the results
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    void testFindByBookId() {
        // Setup
        Date dateTest = new GregorianCalendar(2020,Calendar.OCTOBER,29).getTime();
        Date add4Weeks = reservationServiceUnderTest.add4Weeks(dateTest);

        // Configure WaitingListDao.findByBookId(...).
        final List<WaitingList> waitingLists = Arrays.asList(new WaitingList(0L, 0L, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), 0, false, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), Status.enCours, new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", "anneeEdition", "section", 0, 0, 0)));
        when(waitingListServiceUnderTest.waitingListDao.findByBookId(0L)).thenReturn(waitingLists);

        // Configure ReservationDao.findById(...).
        final Optional<Reservation> reservation = Optional.of(new Reservation(0L, 0L, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), false));
        when(waitingListServiceUnderTest.reservationDao.findById(0L)).thenReturn(reservation);

        // Configure BookDao.findById(...).
        final Optional<Book> book = Optional.of(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", "anneeEdition", "section", 0, 0, 0));
        when(waitingListServiceUnderTest.bookDao.findById(0L)).thenReturn(book);

        // Configure ReservationDao.findAll(...).
        final List<Reservation> reservations = Arrays.asList(new Reservation(0L, 0L, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), false));
        when(waitingListServiceUnderTest.reservationDao.findAll()).thenReturn(reservations);

        // Configure ReservationDao.findAllByBookIdOrderByEndBorrowingAsc(...).
        final List<Reservation> reservations1 = Arrays.asList(new Reservation(0L, 0L, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), false));
        when(waitingListServiceUnderTest.reservationDao.findAllByBookIdOrderByEndBorrowingAsc(0L)).thenReturn(reservations1);

        // Run the test
        final List<WaitingListBean> result = waitingListServiceUnderTest.findByBookId(0L);

        // Verify the results
        assertThat(result.size()).isEqualTo(1);
    }


    @Test
    void testFindAllByStatus() {
        // Setup
        Date dateTest = new GregorianCalendar(2020,Calendar.OCTOBER,29).getTime();
        Date add4Weeks = reservationServiceUnderTest.add4Weeks(dateTest);

        // Configure WaitingListDao.findAllByStatus(...).
        final List<WaitingList> waitingLists = Arrays.asList(new WaitingList(0L, 0L, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), 0, false, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), Status.enCours, new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", "anneeEdition", "section", 0, 0, 0)));
        when(waitingListServiceUnderTest.waitingListDao.findAllByStatus(Status.enCours)).thenReturn(waitingLists);

        // Run the test
        final List<WaitingList> result = waitingListServiceUnderTest.findAllByStatus(Status.enCours);

        // Verify the results
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    void testWaitingListAddReservationException(){

        // Setup
        Date dateTest = new GregorianCalendar(2020,Calendar.OCTOBER,29).getTime();
        Date add4Weeks = reservationServiceUnderTest.add4Weeks(dateTest);
        // Run the test
        waitingListServiceUnderTest.waitingListReservation(0L, 0L);

        // Verify the results

    }

}
