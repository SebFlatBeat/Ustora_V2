package com.Ustora.book.controller;

import com.Ustora.book.entities.Book;
import com.Ustora.book.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class BookControllerTest {

    @Mock
    private BookService mockBookService;

    @InjectMocks
    private BookController bookControllerUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void testBooks() {
        // Setup

        // Configure BookService.findAll(...).
        final Page<Book> books = new PageImpl<>(Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0)));
        when(mockBookService.findAll(PageRequest.of(0, 1))).thenReturn(books);

        // Run the test
        final Page<Book> result = bookControllerUnderTest.books(0, 0);

        // Verify the results
    }

    @Test
    void testAllBookList() {
        // Setup

        // Configure BookService.findAll(...).
        final List<Book> books = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));
        when(mockBookService.findAll()).thenReturn(books);

        // Run the test
        final List<Book> result = bookControllerUnderTest.allBookList();

        // Verify the results
    }

    @Test
    void testFindTitre() {
        // Setup
        final List<String> expectedResult = Arrays.asList("value");
        when(mockBookService.findDistinctByTitre()).thenReturn(Arrays.asList("value"));

        // Run the test
        final List<String> result = bookControllerUnderTest.findTitre();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindAuteurNom() {
        // Setup
        final List<String> expectedResult = Arrays.asList("value");
        when(mockBookService.findDistinctByAuteurPrincipalNom()).thenReturn(Arrays.asList("value"));

        // Run the test
        final List<String> result = bookControllerUnderTest.findAuteurNom();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindAuteurPrenom() {
        // Setup
        final List<String> expectedResult = Arrays.asList("value");
        when(mockBookService.findDistinctByAuteurPrincipalPrenom()).thenReturn(Arrays.asList("value"));

        // Run the test
        final List<String> result = bookControllerUnderTest.findAuteurPrenom();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindEditeur() {
        // Setup
        final List<String> expectedResult = Arrays.asList("value");
        when(mockBookService.findDistinctByEditeur()).thenReturn(Arrays.asList("value"));

        // Run the test
        final List<String> result = bookControllerUnderTest.findEditeur();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindAnneeEdition() {
        // Setup
        final List<String> expectedResult = Arrays.asList("value");
        when(mockBookService.findDistinctByAnneeEdition()).thenReturn(Arrays.asList("value"));

        // Run the test
        final List<String> result = bookControllerUnderTest.findAnneeEdition();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindSection() {
        // Setup
        final List<String> expectedResult = Arrays.asList("value");
        when(mockBookService.findDistinctBySection()).thenReturn(Arrays.asList("value"));

        // Run the test
        final List<String> result = bookControllerUnderTest.findSection();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindIsbn() {
        // Setup
        final List<String> expectedResult = Arrays.asList("value");
        when(mockBookService.findDistinctByIsbn()).thenReturn(Arrays.asList("value"));

        // Run the test
        final List<String> result = bookControllerUnderTest.findIsbn();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testSearchTitre() {
        // Setup
        final List<Book> searchBook = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));

        // Configure BookService.findByTitre(...).
        final List<Book> books = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));
        when(mockBookService.findByTitre("titre", Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0)))).thenReturn(books);

        // Run the test
        final List<Book> result = bookControllerUnderTest.searchTitre("titre", searchBook);

        // Verify the results
    }

    @Test
    void testSearchAuteurNom() {
        // Setup
        final List<Book> searchBook = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));

        // Configure BookService.findByAuteurPrincipalNom(...).
        final List<Book> books = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));
        when(mockBookService.findByAuteurPrincipalNom("auteurPrincipalNom", Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0)))).thenReturn(books);

        // Run the test
        final List<Book> result = bookControllerUnderTest.searchAuteurNom("auteurNom", searchBook);

        // Verify the results
    }

    @Test
    void testSearchAuteurPrenom() {
        // Setup
        final List<Book> searchBook = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));

        // Configure BookService.findByAuteurPrincipalPrenom(...).
        final List<Book> books = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));
        when(mockBookService.findByAuteurPrincipalPrenom("auteurPrincipalPrenom", Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0)))).thenReturn(books);

        // Run the test
        final List<Book> result = bookControllerUnderTest.searchAuteurPrenom("auteurPrenom", searchBook);

        // Verify the results
    }

    @Test
    void testSearchEditeur() {
        // Setup
        final List<Book> searchBook = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));

        // Configure BookService.findByEditeur(...).
        final List<Book> books = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));
        when(mockBookService.findByEditeur("editeur", Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0)))).thenReturn(books);

        // Run the test
        final List<Book> result = bookControllerUnderTest.searchEditeur("editeur", searchBook);

        // Verify the results
    }

    @Test
    void testSearchAnneeEdition() {
        // Setup
        final List<Book> searchBook = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));

        // Configure BookService.findByAnneeEdition(...).
        final List<Book> books = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));
        when(mockBookService.findByAnneeEdition("anneeEdition", Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0)))).thenReturn(books);

        // Run the test
        final List<Book> result = bookControllerUnderTest.searchAnneeEdition("anneeEdition", searchBook);

        // Verify the results
    }

    @Test
    void testSearchSection() {
        // Setup
        final List<Book> searchBook = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));

        // Configure BookService.findBySection(...).
        final List<Book> books = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));
        when(mockBookService.findBySection("section", Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0)))).thenReturn(books);

        // Run the test
        final List<Book> result = bookControllerUnderTest.searchSection("section", searchBook);

        // Verify the results
    }

    @Test
    void testSearchIsbn() {
        // Setup
        final List<Book> searchBook = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));

        // Configure BookService.findByIsbn(...).
        final List<Book> books = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));
        when(mockBookService.findByIsbn("isbn", Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0)))).thenReturn(books);

        // Run the test
        final List<Book> result = bookControllerUnderTest.searchIsbn("isbn", searchBook);

        // Verify the results
    }
}
