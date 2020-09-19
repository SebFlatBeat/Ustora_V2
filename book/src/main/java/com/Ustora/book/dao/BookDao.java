package com.Ustora.book.dao;

import com.Ustora.book.entities.Book;
import com.Ustora.book.entities.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * The interface Book dao.
 */
public interface BookDao extends PagingAndSortingRepository<Book, Long> {
    @Override
    Page<Book> findAll(Pageable pageable);

    List<Book> findAll();

    /**
     * Find distinct by titre list.
     *
     * @return the list
     */
    @Query("select distinct book.titre from Book book order by book.titre asc ")
    List<String> findDistinctByTitre();

    /**
     * Find distinct by auteur principal nom list.
     *
     * @return the list
     */
    @Query("select distinct book.auteurPrincipalNom from Book book order by book.auteurPrincipalNom asc")
    List<String> findDistinctByAuteurPrincipalNom();

    /**
     * Find distinct by auteur principal prenom list.
     *
     * @return the list
     */
    @Query("select distinct book.auteurPrincipalPrenom from Book book order by book.auteurPrincipalPrenom asc")
    List<String> findDistinctByAuteurPrincipalPrenom();

    /**
     * Find distinct by editeur list.
     *
     * @return the list
     */
    @Query("select distinct book.editeur from Book book order by book.editeur asc")
    List<String> findDistinctByEditeur();

    /**
     * Find distinct by annee edition list.
     *
     * @return the list
     */
    @Query("select distinct book.anneeEdition from Book book order by book.anneeEdition asc")
    List<String> findDistinctByAnneeEdition();

    /**
     * Find distinct by section list.
     *
     * @return the list
     */
    @Query("select distinct book.section from Book book order by book.section")
    List<String> findDistinctBySection();

    /**
     * Find distinct by isbn list.
     *
     * @return the list
     */
    @Query("select distinct book.isbn from Book book order by book.isbn asc")
    List<String> findDistinctByIsbn();

    /**
     * Find by titre list.
     *
     * @param titre    the titre
     * @param bookList the book list
     * @return the list
     */
    @Query("select distinct book from Book book where book.titre=:titre and book in :listBook")
    List<Book> findByTitre(@Param("titre") String titre, @Param("listBook")List<Book> bookList);

    /**
     * Find by auteur principal nom list.
     *
     * @param auteurPrincipalNom the auteur principal nom
     * @param bookList           the book list
     * @return the list
     */
    @Query("select distinct book from Book book where book.auteurPrincipalNom=:auteurPrincipalNom and book in :listBook")
    List<Book> findByAuteurPrincipalNom(@Param("auteurPrincipalNom") String auteurPrincipalNom, @Param("listBook")List<Book> bookList);

    /**
     * Find by auteur principal prenom list.
     *
     * @param auteurPrincipalPrenom the auteur principal prenom
     * @param bookList              the book list
     * @return the list
     */
    @Query("select distinct book from Book book where book.auteurPrincipalPrenom=:auteurPrincipalPrenom and book in :listBook")
    List<Book> findByAuteurPrincipalPrenom(@Param("auteurPrincipalPrenom") String auteurPrincipalPrenom, @Param("listBook")List<Book> bookList);

    /**
     * Find by editeur list.
     *
     * @param editeur  the editeur
     * @param bookList the book list
     * @return the list
     */
    @Query("select distinct book from Book book where book.editeur=:editeur and book in :listBook")
    List<Book> findByEditeur(@Param("editeur") String editeur, @Param("listBook")List<Book> bookList);

    /**
     * Find by annee edition list.
     *
     * @param anneeEdition the annee edition
     * @param bookList     the book list
     * @return the list
     */
    @Query("select distinct book from Book book where book.anneeEdition=:anneeEdition and book in :listBook")
    List<Book> findByAnneeEdition(@Param("anneeEdition") String anneeEdition, @Param("listBook")List<Book> bookList);

    /**
     * Find by section list.
     *
     * @param section  the section
     * @param bookList the book list
     * @return the list
     */
    @Query("select distinct book from Book book where book.section=:section and book in :listBook")
    List<Book> findBySection(@Param("section") String section, @Param("listBook")List<Book> bookList);

    /**
     * Find by isbn list.
     *
     * @param isbn     the isbn
     * @param bookList the book list
     * @return the list
     */
    @Query("select distinct book from Book book where book.isbn=:isbn and book in :listBook")
    List<Book> findByIsbn(@Param("isbn") String isbn, @Param("listBook")List<Book> bookList);

    Book save(Book book);
}
