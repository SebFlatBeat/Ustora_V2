package com.Ustora.book.service;

import com.Ustora.book.dao.BookDao;
import com.Ustora.book.entities.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class BookServiceTest {

    private BookService bookServiceUnderTest;

    private List<Book> bookListTest = new ArrayList<>();

    @BeforeEach
    void setUp() {
        bookServiceUnderTest = new BookService();
        bookServiceUnderTest.bookDao = mock(BookDao.class);

        Book bookSetUp1 = new Book (1L, "titre1", "auteurPrincipalNom1", "auteurPrincipalPrenom1", "isbn1", "editeur1", "2007", "section1", 1, 1, 0);
        bookListTest.add(bookSetUp1);
        Book bookSetUp2 = new Book(2L, "titre2", "auteurPrincipalNom2", "auteurPrincipalPrenom2", "isbn2", "editeur2", "2008", "section2", 2, 2, 0);
        bookListTest.add(bookSetUp2);

        Mockito.when(bookServiceUnderTest.findById(1L)).thenReturn(Optional.of(bookSetUp1));
        Mockito.when(bookServiceUnderTest.findById(2L)).thenReturn(Optional.of(bookSetUp2));
        Mockito.when(bookServiceUnderTest.bookDao.findAll()).thenReturn(bookListTest);

    }

    @Test
    void testFindDistinctByTitre() {
        // Setup
        List <Book> books = bookListTest;
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add(books.get(0).getTitre());
        when(bookServiceUnderTest.bookDao.findDistinctByTitre()).thenReturn(Arrays.asList("titre1"));

        // Run the test
        expectedResult = bookServiceUnderTest.findDistinctByTitre();

        // Verify the results
        assertEquals(books.get(0).getTitre(), expectedResult.get(0));
    }

    @Test
    void testFindDistinctByAuteurPrincipalNom() {
        // Setup
        List <Book> books = bookListTest;
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add(books.get(0).getAuteurPrincipalNom());
        when(bookServiceUnderTest.bookDao.findDistinctByAuteurPrincipalNom()).thenReturn(Arrays.asList("auteurPrincipalNom1"));

        // Run the test
        final List<String> result = bookServiceUnderTest.findDistinctByAuteurPrincipalNom();

        // Verify the results
        assertEquals(expectedResult.get(0), books.get(0).getAuteurPrincipalNom());
    }

    @Test
    void testFindDistinctByAuteurPrincipalPrenom() {
        // Setup
        List <Book> books = bookListTest;
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add(books.get(0).getAuteurPrincipalPrenom());
        when(bookServiceUnderTest.bookDao.findDistinctByAuteurPrincipalPrenom()).thenReturn(Arrays.asList("auteurPrincipalPrenom1"));

        // Run the test
        final List<String> result = bookServiceUnderTest.findDistinctByAuteurPrincipalPrenom();

        // Verify the results
        assertEquals(expectedResult.get(0), books.get(0).getAuteurPrincipalPrenom());
    }

    @Test
    void testFindDistinctByEditeur() {
        // Setup
        List <Book> books = bookListTest;
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add(books.get(0).getEditeur());
        when(bookServiceUnderTest.bookDao.findDistinctByEditeur()).thenReturn(Arrays.asList("editeur1"));

        // Run the test
        final List<String> result = bookServiceUnderTest.findDistinctByEditeur();

        // Verify the results
        assertEquals(expectedResult.get(0), books.get(0).getEditeur());
    }

    @Test
    void testFindDistinctByAnneeEdition() {
        // Setup
        List <Book> books = bookListTest;
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add(books.get(0).getAnneeEdition());
        when(bookServiceUnderTest.bookDao.findDistinctByAnneeEdition()).thenReturn(Arrays.asList("anneeEdition1"));

        // Run the test
        final List<String> result = bookServiceUnderTest.findDistinctByAnneeEdition();

        // Verify the results
        assertEquals(expectedResult.get(0), books.get(0).getAnneeEdition());
    }

    @Test
    void testFindDistinctBySection() {
        // Setup
        List <Book> books = bookListTest;
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add(books.get(0).getSection());
        when(bookServiceUnderTest.bookDao.findDistinctBySection()).thenReturn(Arrays.asList("section1"));

        // Run the test
        final List<String> result = bookServiceUnderTest.findDistinctBySection();

        // Verify the results
        assertEquals(expectedResult.get(0), books.get(0).getSection());
    }

    @Test
    void testFindDistinctByIsbn() {
        // Setup
        List <Book> books = bookListTest;
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add(books.get(0).getIsbn());
        when(bookServiceUnderTest.bookDao.findDistinctByIsbn()).thenReturn(Arrays.asList("isbn1"));

        // Run the test
        final List<String> result = bookServiceUnderTest.findDistinctByIsbn();

        // Verify the results
        assertEquals(expectedResult.get(0), books.get(0).getIsbn());
    }

    @Test
    void testFindAll() {
        // Setup
        // Configure BookDao.findAll(...).
        final Page<Book> books = new PageImpl<>(Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", "2007", "section", 0, 0, 0)));
        when(bookServiceUnderTest.bookDao.findAll(any(Pageable.class))).thenReturn(books);

        // Run the test
        final Page<Book> result = bookServiceUnderTest.findAll(PageRequest.of(0, 1));

        // Verify the results
        assertEquals(books, result);
    }

    @Test
    void testFindAll1() {
        // Setup
        // Configure BookDao.findAll(...).
        final List<Book> books = bookListTest;

        // Run the test
        final List<Book> result = bookServiceUnderTest.findAll();

        // Verify the results
        assertEquals(books.size(), result.size());
    }

    @Test
    void testFindById() {
        // Setup
        // Configure BookDao.findById(...).
        final Optional<Book> book = Optional.of(bookListTest.get(0));

        // Run the test
        final Optional<Book> result = bookServiceUnderTest.findById(1L);

        // Verify the results
        assertEquals(book, result);
    }

}
