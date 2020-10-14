package com.Ustora.book.service;

import com.Ustora.book.dao.BookDao;
import com.Ustora.book.entities.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {

    private BookService bookServiceUnderTest;

    @BeforeEach
    void setUp() {
        bookServiceUnderTest = new BookService();
        bookServiceUnderTest.bookDao = mock(BookDao.class);
    }

    @Test
    void testFindDistinctByTitre() {
        // Setup
        final List<String> expectedResult = Arrays.asList("value");
        when(bookServiceUnderTest.bookDao.findDistinctByTitre()).thenReturn(Arrays.asList("value"));

        // Run the test
        final List<String> result = bookServiceUnderTest.findDistinctByTitre();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindDistinctByAuteurPrincipalNom() {
        // Setup
        final List<String> expectedResult = Arrays.asList("value");
        when(bookServiceUnderTest.bookDao.findDistinctByAuteurPrincipalNom()).thenReturn(Arrays.asList("value"));

        // Run the test
        final List<String> result = bookServiceUnderTest.findDistinctByAuteurPrincipalNom();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindDistinctByAuteurPrincipalPrenom() {
        // Setup
        final List<String> expectedResult = Arrays.asList("value");
        when(bookServiceUnderTest.bookDao.findDistinctByAuteurPrincipalPrenom()).thenReturn(Arrays.asList("value"));

        // Run the test
        final List<String> result = bookServiceUnderTest.findDistinctByAuteurPrincipalPrenom();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindDistinctByEditeur() {
        // Setup
        final List<String> expectedResult = Arrays.asList("value");
        when(bookServiceUnderTest.bookDao.findDistinctByEditeur()).thenReturn(Arrays.asList("value"));

        // Run the test
        final List<String> result = bookServiceUnderTest.findDistinctByEditeur();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindDistinctByAnneeEdition() {
        // Setup
        final List<String> expectedResult = Arrays.asList("value");
        when(bookServiceUnderTest.bookDao.findDistinctByAnneeEdition()).thenReturn(Arrays.asList("value"));

        // Run the test
        final List<String> result = bookServiceUnderTest.findDistinctByAnneeEdition();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindDistinctBySection() {
        // Setup
        final List<String> expectedResult = Arrays.asList("value");
        when(bookServiceUnderTest.bookDao.findDistinctBySection()).thenReturn(Arrays.asList("value"));

        // Run the test
        final List<String> result = bookServiceUnderTest.findDistinctBySection();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindDistinctByIsbn() {
        // Setup
        final List<String> expectedResult = Arrays.asList("value");
        when(bookServiceUnderTest.bookDao.findDistinctByIsbn()).thenReturn(Arrays.asList("value"));

        // Run the test
        final List<String> result = bookServiceUnderTest.findDistinctByIsbn();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindByTitre() {
        // Setup
        final List<Book> bookList = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));

        // Configure BookDao.findByTitre(...).
        final List<Book> books = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));
        when(bookServiceUnderTest.bookDao.findByTitre("titre", Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0)))).thenReturn(books);

        // Run the test
        final List<Book> result = bookServiceUnderTest.findByTitre("titre", bookList);

        // Verify the results
    }

    @Test
    void testFindByAuteurPrincipalNom() {
        // Setup
        final List<Book> bookList = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));

        // Configure BookDao.findByAuteurPrincipalNom(...).
        final List<Book> books = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));
        when(bookServiceUnderTest.bookDao.findByAuteurPrincipalNom("auteurPrincipalNom", Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0)))).thenReturn(books);

        // Run the test
        final List<Book> result = bookServiceUnderTest.findByAuteurPrincipalNom("auteurPrincipalNom", bookList);

        // Verify the results
    }

    @Test
    void testFindByAuteurPrincipalPrenom() {
        // Setup
        final List<Book> bookList = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));

        // Configure BookDao.findByAuteurPrincipalPrenom(...).
        final List<Book> books = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));
        when(bookServiceUnderTest.bookDao.findByAuteurPrincipalPrenom("auteurPrincipalPrenom", Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0)))).thenReturn(books);

        // Run the test
        final List<Book> result = bookServiceUnderTest.findByAuteurPrincipalPrenom("auteurPrincipalPrenom", bookList);

        // Verify the results
    }

    @Test
    void testFindByEditeur() {
        // Setup
        final List<Book> bookList = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));

        // Configure BookDao.findByEditeur(...).
        final List<Book> books = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));
        when(bookServiceUnderTest.bookDao.findByEditeur("editeur", Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0)))).thenReturn(books);

        // Run the test
        final List<Book> result = bookServiceUnderTest.findByEditeur("editeur", bookList);

        // Verify the results
    }

    @Test
    void testFindByAnneeEdition() {
        // Setup
        final List<Book> bookList = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));

        // Configure BookDao.findByAnneeEdition(...).
        final List<Book> books = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));
        when(bookServiceUnderTest.bookDao.findByAnneeEdition("anneeEdition", Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0)))).thenReturn(books);

        // Run the test
        final List<Book> result = bookServiceUnderTest.findByAnneeEdition("anneeEdition", bookList);

        // Verify the results
    }

    @Test
    void testFindBySection() {
        // Setup
        final List<Book> bookList = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));

        // Configure BookDao.findBySection(...).
        final List<Book> books = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));
        when(bookServiceUnderTest.bookDao.findBySection("section", Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0)))).thenReturn(books);

        // Run the test
        final List<Book> result = bookServiceUnderTest.findBySection("section", bookList);

        // Verify the results
    }

    @Test
    void testFindByIsbn() {
        // Setup
        final List<Book> bookList = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));

        // Configure BookDao.findByIsbn(...).
        final List<Book> books = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));
        when(bookServiceUnderTest.bookDao.findByIsbn("isbn", Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0)))).thenReturn(books);

        // Run the test
        final List<Book> result = bookServiceUnderTest.findByIsbn("isbn", bookList);

        // Verify the results
    }

    @Test
    void testFindAll() {
        // Setup

        // Configure BookDao.findAll(...).
        final Page<Book> books = new PageImpl<>(Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0)));
        when(bookServiceUnderTest.bookDao.findAll(any(Pageable.class))).thenReturn(books);

        // Run the test
        final Page<Book> result = bookServiceUnderTest.findAll(PageRequest.of(0, 1));

        // Verify the results
    }

    @Test
    void testFindAll1() {
        // Setup

        // Configure BookDao.findAll(...).
        final List<Book> books = Arrays.asList(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));
        when(bookServiceUnderTest.bookDao.findAll()).thenReturn(books);

        // Run the test
        final List<Book> result = bookServiceUnderTest.findAll();

        // Verify the results
    }

    @Test
    void testFindById() {
        // Setup

        // Configure BookDao.findById(...).
        final Optional<Book> book = Optional.of(new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0));
        when(bookServiceUnderTest.bookDao.findById(0L)).thenReturn(book);

        // Run the test
        final Optional<Book> result = bookServiceUnderTest.findById(0L);

        // Verify the results
    }

    @Test
    void testSave() {
        // Setup
        final Book book = new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0);

        // Configure BookDao.save(...).
        final Book book1 = new Book(0L, "titre", "auteurPrincipalNom", "auteurPrincipalPrenom", "isbn", "editeur", new Date(0L), "section", 0, 0);
        when(bookServiceUnderTest.bookDao.save(any(Book.class))).thenReturn(book1);

        // Run the test
        bookServiceUnderTest.save(book);

        // Verify the results
    }
}
