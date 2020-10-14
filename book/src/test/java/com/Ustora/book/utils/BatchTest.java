package com.Ustora.book.utils;

import com.Ustora.book.beans.UserBean;
import com.Ustora.book.entities.Reservation;
import com.Ustora.book.proxies.UserProxy;
import com.Ustora.book.service.ReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.*;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class BatchTest {

    @Mock
    private ReservationService mockReservationService;
    @Mock
    private UserProxy mockUserProxy;
    @Mock
    private Mail mockMail;

    @InjectMocks
    private Batch batchUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void testSendingLateMail() {
        // Setup

        // Configure ReservationService.findAll(...).
        final List<Reservation> reservations = Arrays.asList(new Reservation(0L, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), false));
        when(mockReservationService.findAll()).thenReturn(reservations);

        // Configure UserProxy.findById(...).
        final UserBean userBean1 = new UserBean();
        userBean1.setId(0L);
        userBean1.setUsername("username");
        userBean1.setEmail("email");
        userBean1.setPassword("password");
        final Optional<UserBean> userBean = Optional.of(userBean1);
        when(mockUserProxy.findById(0L)).thenReturn(userBean);

        // Run the test
        batchUnderTest.sendingLateMail();

        // Verify the results
        verify(mockMail).sendMessage("userMail");
    }
}
