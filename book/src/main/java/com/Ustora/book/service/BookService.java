package com.Ustora.book.service;

import com.Ustora.book.dao.BookDao;
import com.Ustora.book.entities.Book;
import com.Ustora.book.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The type Book service.
 */
@Service
public class BookService {

    /**
     * The Book dao.
     */
    @Autowired
    BookDao bookDao;

    /**
     * Find distinct by titre list.
     *
     * @return the list
     */
    public List<String> findDistinctByTitre() {
        return bookDao.findDistinctByTitre();
    }

    /**
     * Find distinct by auteur principal nom list.
     *
     * @return the list
     */
    public List<String> findDistinctByAuteurPrincipalNom() {
        return bookDao.findDistinctByAuteurPrincipalNom();
    }

    /**
     * Find distinct by auteur principal prenom list.
     *
     * @return the list
     */
    public List<String> findDistinctByAuteurPrincipalPrenom() {
        return bookDao.findDistinctByAuteurPrincipalPrenom();
    }

    /**
     * Find distinct by editeur list.
     *
     * @return the list
     */
    public List<String> findDistinctByEditeur() {
        return bookDao.findDistinctByEditeur();
    }

    /**
     * Find distinct by annee edition list.
     *
     * @return the list
     */
    public List<String> findDistinctByAnneeEdition() {
        return bookDao.findDistinctByAnneeEdition();
    }

    /**
     * Find distinct by section list.
     *
     * @return the list
     */
    public List<String> findDistinctBySection() {
        return bookDao.findDistinctBySection();
    }

    /**
     * Find distinct by isbn list.
     *
     * @return the list
     */
    public List<String> findDistinctByIsbn() {
        return bookDao.findDistinctByIsbn();
    }

    /**
     * Find by titre list.
     *
     * @param titre    the titre
     * @param bookList the book list
     * @return the list
     */
    public List<Book> findByTitre(@Param("titre") String titre, @Param("listBook") List<Book> bookList) {
        return bookDao.findByTitre(titre, bookList);
    }

    /**
     * Find by auteur principal nom list.
     *
     * @param auteurPrincipalNom the auteur principal nom
     * @param bookList           the book list
     * @return the list
     */
    public List<Book> findByAuteurPrincipalNom(@Param("auteurPrincipalNom") String auteurPrincipalNom, @Param("listBook") List<Book> bookList) {
        return bookDao.findByAuteurPrincipalNom(auteurPrincipalNom, bookList);
    }

    /**
     * Find by auteur principal prenom list.
     *
     * @param auteurPrincipalPrenom the auteur principal prenom
     * @param bookList              the book list
     * @return the list
     */
    public List<Book> findByAuteurPrincipalPrenom(@Param("auteurPrincipalPrenom") String auteurPrincipalPrenom, @Param("listBook") List<Book> bookList) {
        return bookDao.findByAuteurPrincipalPrenom(auteurPrincipalPrenom, bookList);
    }

    /**
     * Find by editeur list.
     *
     * @param editeur  the editeur
     * @param bookList the book list
     * @return the list
     */
    public List<Book> findByEditeur(@Param("editeur") String editeur, @Param("listBook") List<Book> bookList) {
        return bookDao.findByEditeur(editeur, bookList);
    }

    /**
     * Find by annee edition list.
     *
     * @param anneeEdition the annee edition
     * @param bookList     the book list
     * @return the list
     */
    public List<Book> findByAnneeEdition(@Param("anneeEdition") String anneeEdition, @Param("listBook") List<Book> bookList) {
        return bookDao.findByAnneeEdition(anneeEdition, bookList);
    }

    /**
     * Find by section list.
     *
     * @param section  the section
     * @param bookList the book list
     * @return the list
     */
    public List<Book> findBySection(@Param("section") String section, @Param("listBook") List<Book> bookList) {
        return bookDao.findBySection(section, bookList);
    }

    /**
     * Find by isbn list.
     *
     * @param isbn     the isbn
     * @param bookList the book list
     * @return the list
     */
    public List<Book> findByIsbn(@Param("isbn") String isbn, @Param("listBook") List<Book> bookList) {
        return bookDao.findByIsbn(isbn, bookList);
    }

    /**
     * Find all page.
     *
     * @param pageable the pageable
     * @return the page
     */
    public Page<Book> findAll(Pageable pageable) {
        return bookDao.findAll(pageable);
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    public  List<Book> findAll(){
        return bookDao.findAll();
    }

    /**
     * Find by id optional.
     *
     * @param bookId the book id
     * @return the optional
     */
    public Optional<Book> findById (Long bookId){
        return bookDao.findById(bookId);
    }

    /**
     * Save.
     *
     * @param book the book
     */
    public void save (Book book){
        bookDao.save(book);
    }
}
