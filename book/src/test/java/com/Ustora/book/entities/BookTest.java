package com.Ustora.book.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

class BookTest {

    @Mock
    private Date mockAnneeEdition;

    private Book bookUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
        bookUnderTest = new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", mockAnneeEdition, "section", 0, 0);
    }

    @Test
    void testToString() {
        // Setup

        // Run the test
        final String result = bookUnderTest.toString();

        // Verify the results
        assertEquals("result", result);
    }
}
