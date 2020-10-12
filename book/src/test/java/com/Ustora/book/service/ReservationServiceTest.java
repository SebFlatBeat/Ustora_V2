package com.Ustora.book.service;

import com.Ustora.book.beans.UserBean;
import com.Ustora.book.dao.ReservationDao;
import com.Ustora.book.entities.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ReservationServiceTest {

    @Mock
    private ReservationDao reservationDao;

    @Mock
    private Book book;

    @Mock
    private UserBean userBean;

    @Mock
    private ReservationService reservationService;


}

