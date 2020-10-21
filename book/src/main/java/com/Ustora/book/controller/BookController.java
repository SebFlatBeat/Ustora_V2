package com.Ustora.book.controller;

import com.Ustora.book.entities.Book;
import com.Ustora.book.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 * The type Book controller.
 */
@RestController
public class BookController {

    /**
     * The Logger.
     */
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;

    /**
     * Books page.
     *
     * @param page the page
     * @param size the size
     * @return bookList page
     */
    @GetMapping("/allBook")
    public Page<Book> books(@RequestParam(name="page",defaultValue = "0") int page,
                            @RequestParam(name = "size",defaultValue = "20") int size){
        Sort sort = Sort.by(Sort.Order.asc("auteurPrincipalNom"));
        Page<Book> bookList = bookService.findAll(PageRequest.of(page, size, sort));
        logger.info("Renvoi de tous les livres pagniés");
        return bookList;
    }

    /**
     * All book list list.
     *
     * @return books list
     */
    @GetMapping("/allBookList")
    public List<Book> allBookList(){
        List<Book> books = bookService.findAll();
        logger.info("Renvoi de tous les livres");
        return books;
    }

    @GetMapping(value = "/find/id")
    public Optional<Book> findById(@RequestParam Long bookId){
        Optional<Book> book = bookService.findById(bookId);
        return book;
    }

    /**
     * Find titre list.
     *
     * @return titre list
     */
    @GetMapping("/find/titre")
    public List<String> findTitre(){
        List<String> titre = bookService.findDistinctByTitre();
        logger.info("Renvoi un titre de livre");
        return titre;
    }

    /**
     * Find auteur nom list.
     *
     * @return auteurNom list
     */
    @GetMapping("/find/auteurNom")
    public List<String> findAuteurNom(){
        List<String> auteurNom = bookService.findDistinctByAuteurPrincipalNom();
        logger.info("Renvoi un nom d'auteur");
        return auteurNom;
    }

    /**
     * Find auteur prenom list.
     *
     * @return auteurPrenom list
     */
    @GetMapping("/find/auteurPrenom")
    public List<String> findAuteurPrenom(){
        List<String> auteurPrenom = bookService.findDistinctByAuteurPrincipalPrenom();
        logger.info("Renvoi un prénom d'auteur");
        return auteurPrenom;
    }

    /**
     * Find editeur list.
     *
     * @return editeur list
     */
    @GetMapping("/find/editeur")
    public List<String> findEditeur(){
        List<String> editeur = bookService.findDistinctByEditeur();
        logger.info("Renvoi un editeur de livre");
        return editeur;
    }

    /**
     * Find annee edition list.
     *
     * @return anneeEdition list
     */
    @GetMapping("/find/anneeEdition")
    public List<String> findAnneeEdition(){
        List<String> anneeEdition = bookService.findDistinctByAnneeEdition();
        logger.info("Renvoi une année d'édition");
        return anneeEdition;
    }

    /**
     * Find section list.
     *
     * @return section list
     */
    @GetMapping("/find/section")
    public List<String> findSection(){
        List<String> section = bookService.findDistinctBySection();
        logger.info("Renvoi une section de livre");
        return section;
    }

    /**
     * Find isbn list.
     *
     * @return isbn list
     */
    @GetMapping("/find/isbn")
    public List<String> findIsbn(){
        List<String> isbn = bookService.findDistinctByIsbn();
        logger.info("Renvoi un ISBN");
        return isbn;
    }

    /**
     * Search titre list.
     *
     * @param titre      the titre
     * @param searchBook the search book
     * @return list
     */
    @PostMapping("/search/titre/{titre}")
    public List<Book> searchTitre(@PathVariable("titre") String titre, @RequestBody List<Book> searchBook){
        logger.info("Recherche un titre de livre");
        return bookService.findByTitre(titre, searchBook);
    }

    /**
     * Search auteur nom list.
     *
     * @param auteurNom  the auteur nom
     * @param searchBook the search book
     * @return list
     */
    @PostMapping("/search/auteurPrincipalNom/{auteurNom}")
    public List<Book> searchAuteurNom(@PathVariable("auteurNom") String auteurNom, @RequestBody List<Book> searchBook){
        logger.info("Recherche un nom d'auteur");
        return bookService.findByAuteurPrincipalNom(auteurNom, searchBook);
    }

    /**
     * Search auteur prenom list.
     *
     * @param auteurPrenom the auteur prenom
     * @param searchBook   the search book
     * @return list
     */
    @PostMapping("/search/auteurPrincipalPrenom/{auteurPrenom}")
    public List<Book> searchAuteurPrenom(@PathVariable("auteurPrenom") String auteurPrenom, @RequestBody List<Book> searchBook){
        logger.info("Recherche un prénom d'auteur");
        return bookService.findByAuteurPrincipalPrenom(auteurPrenom, searchBook);
    }

    /**
     * Search editeur list.
     *
     * @param editeur    the editeur
     * @param searchBook the search book
     * @return list
     */
    @PostMapping("/search/editeur/{editeur}")
    public List<Book> searchEditeur(@PathVariable("editeur") String editeur, @RequestBody List<Book> searchBook){
        logger.info("Recherche un editeur de livre");
        return bookService.findByEditeur(editeur, searchBook);
    }

    /**
     * Search annee edition list.
     *
     * @param anneeEdition the annee edition
     * @param searchBook   the search book
     * @return list
     */
    @PostMapping("/search/anneeEdition/{anneeEdition}")
    public List<Book> searchAnneeEdition(@PathVariable("anneeEdition") String anneeEdition, @RequestBody List<Book> searchBook){
        logger.info("Recherche une année d'édition de livre");
        return bookService.findByAnneeEdition(anneeEdition, searchBook);
    }

    /**
     * Search section list.
     *
     * @param section    the section
     * @param searchBook the search book
     * @return list
     */
    @PostMapping("/search/section/{section}")
    public List<Book> searchSection(@PathVariable("section") String section, @RequestBody List<Book> searchBook){
        logger.info("Recherche une section de livre");
        return bookService.findBySection(section, searchBook);
    }

    /**
     * Search isbn list.
     *
     * @param isbn       the isbn
     * @param searchBook the search book
     * @return list
     */
    @PostMapping("/search/isbn/{isbn}")
    public List<Book> searchIsbn(@PathVariable("isbn") String isbn, @RequestBody List<Book> searchBook){
        logger.info("Recherche une section de livre");
        return bookService.findByIsbn(isbn, searchBook);
    }
}
