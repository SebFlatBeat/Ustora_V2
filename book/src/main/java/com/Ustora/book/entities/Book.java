package com.Ustora.book.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;


/**
 * The type Book.
 */
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @Size( max = 250, min = 3, message = "Le nom du livre doit contenir entre 3 et 50 charactères." )
    @NotEmpty( message = "Veuillez saisir le nom de livre" )
    private String titre;

    @Size( max = 100)
    private String auteurPrincipalNom;

    @Size( max = 100)
    private String auteurPrincipalPrenom;

    @NotNull
    private String isbn;
    @NotNull
    private String editeur;
    @NotNull
    private String anneeEdition;
    @NotNull
    private String section;

    private int nbreExemplaire;


    /**
     * Instantiates a new Book.
     */
    public Book() {

    }

    /**
     * Instantiates a new Book.
     *
     * @param id                    the id
     * @param titre                 the titre
     * @param auteurPrincipalNom    the auteur principal nom
     * @param auteurPrincipalPrenom the auteur principal prenom
     * @param isbn                  the isbn
     * @param editeur               the editeur
     * @param anneeEdition          the annee edition
     * @param section               the section
     * @param nbreExemplaire        the nbre exemplaire
     */
    public Book(Long id,
                @Size( max = 100, min = 3, message = "Le nom du livre doit contenir entre 3 et 50 charactères." )
                @NotEmpty( message = "Veuillez saisir le nom de livre" )
                        String titre,
                @Size( max = 100, min = 3)
                        String auteurPrincipalNom,
                @Size( max = 100, min = 3)
                        String auteurPrincipalPrenom,
                @NotNull
                        String isbn,
                @NotNull
                        String editeur,
                @NotNull
                        Date anneeEdition,
                @NotNull
                        String section,
                int nbreExemplaire){

    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets titre.
     *
     * @return the titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Sets titre.
     *
     * @param titre the titre
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * Gets auteur principal nom.
     *
     * @return the auteur principal nom
     */
    public String getAuteurPrincipalNom() {
        return auteurPrincipalNom;
    }

    /**
     * Sets auteur principal nom.
     *
     * @param auteurNom the auteur nom
     */
    public void setAuteurPrincipalNom(String auteurNom) {
        this.auteurPrincipalNom = auteurPrincipalNom;
    }

    /**
     * Gets auteur principal prenom.
     *
     * @return the auteur principal prenom
     */
    public String getAuteurPrincipalPrenom() {
        return auteurPrincipalPrenom;
    }

    /**
     * Sets auteur principal prenom.
     *
     * @param auteurPrincipalPrenom the auteur principal prenom
     */
    public void setAuteurPrincipalPrenom(String auteurPrincipalPrenom) {
        this.auteurPrincipalPrenom = auteurPrincipalPrenom;
    }

    /**
     * Gets isbn.
     *
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets isbn.
     *
     * @param isbn the isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Gets editeur.
     *
     * @return the editeur
     */
    public String getEditeur() {
        return editeur;
    }

    /**
     * Sets editeur.
     *
     * @param editeur the editeur
     */
    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    /**
     * Gets annee edition.
     *
     * @return the annee edition
     */
    public String getAnneeEdition() {
        return anneeEdition;
    }

    /**
     * Sets annee edition.
     *
     * @param anneeEdition the annee edition
     */
    public void setAnneeEdition(String anneeEdition) {
        this.anneeEdition = anneeEdition;
    }

    /**
     * Gets section.
     *
     * @return the section
     */
    public String getSection() {
        return section;
    }

    /**
     * Sets section.
     *
     * @param section the section
     */
    public void setSection(String section) {
        this.section = section;
    }

    /**
     * Gets nbre exemplaire.
     *
     * @return the nbre exemplaire
     */
    public int getNbreExemplaire() {
        return nbreExemplaire;
    }

    /**
     * Sets nbre exemplaire.
     *
     * @param nbreExemplaire the nbre exemplaire
     */
    public void setNbreExemplaire(int nbreExemplaire) {
        this.nbreExemplaire = nbreExemplaire;
    }

    @Override
    public String toString() {
        return "Book [id=" + id +
                ", titre=" + titre +
                ", auteurPrincipalNom=" + auteurPrincipalNom +
                ", auteurPrincipalPrenom=" + auteurPrincipalPrenom +
                ", isbn=" + isbn +
                ", editeur=" + editeur +
                ", anneeEdition=" + anneeEdition +
                ", section=" + section +
                ", nbreExemplaire=" + nbreExemplaire + "]";
    }
}
