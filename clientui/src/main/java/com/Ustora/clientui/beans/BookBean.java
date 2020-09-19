package com.Ustora.clientui.beans;

public class BookBean {
    private Long id;

    private String titre;

    private String auteurPrincipalNom;

    private String auteurPrincipalPrenom;

    private String isbn;

    private String editeur;

    private String anneeEdition;

    private String section;

    private int nbreExemplaire;

    public BookBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteurPrincipalNom() {
        return auteurPrincipalNom;
    }

    public void setAuteurPrincipalNom(String auteurPrincipalNom) {
        this.auteurPrincipalNom = auteurPrincipalNom;
    }

    public String getAuteurPrincipalPrenom() {
        return auteurPrincipalPrenom;
    }

    public void setAuteurPrincipalPrenom(String auteurPrincipalPrenom) {
        this.auteurPrincipalPrenom = auteurPrincipalPrenom;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public String getAnneeEdition() {
        return anneeEdition;
    }

    public void setAnneeEdition(String anneeEdition) {
        this.anneeEdition = anneeEdition;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getNbreExemplaire() {
        return nbreExemplaire;
    }

    public void setNbreExemplaire(int nbreExemplaire) {
        this.nbreExemplaire = nbreExemplaire;
    }

    @Override
    public String toString() {
        return "BookBean{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteurPrincipalNom='" + auteurPrincipalNom + '\'' +
                ", auteurPrincipalPrenom='" + auteurPrincipalPrenom + '\'' +
                ", isbn='" + isbn + '\'' +
                ", editeur='" + editeur + '\'' +
                ", anneeEdition='" + anneeEdition + '\'' +
                ", section='" + section + '\'' +
                ", nbreExemplaire=" + nbreExemplaire +
                '}';
    }
}
