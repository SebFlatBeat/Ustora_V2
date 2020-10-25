package com.Ustora.clientui.beans;

import java.util.Date;

public class WaitingListBean {
    private Long id;
    private Long userBookId;
    private Date dateDeRetour;
    private Integer positionInList;
    private Status status;
    private Integer nbreDeDemande;

    private BookBean book;

    public WaitingListBean() {
    }

    public WaitingListBean(Long id, Long userBookId, Date dateDeRetour, Integer positionInList, BookBean book, Status status,Integer nbreDeDemande) {
        this.id = id;
        this.userBookId = userBookId;
        this.dateDeRetour = dateDeRetour;
        this.positionInList = positionInList;
        this.book = book;
        this.status = status;
        this.nbreDeDemande = nbreDeDemande;
    }

    /**
     * Gets id
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
     * Gets user book id.
     *
     * @return the user book id
     */
    public Long getUserBookId() {
        return userBookId;
    }

    /**
     * Sets user book id.
     *
     * @return the user book id
     */
    public void setUserBookId(Long userBookId) {
        this.userBookId = userBookId;
    }

    /**
     * Gets date de retour
     *
     * @return date de retour
     */
    public Date getDateDeRetour() {
        return dateDeRetour;
    }

    /**
     * Sets date de retour
     *
     * @return date de retour
     */
    public void setDateDeRetour(Date dateDeRetour) {
        this.dateDeRetour = dateDeRetour;
    }

    /**
     * get the position in list
     *
     * @return position in list
     */
    public Integer getPositionInList() {
        return positionInList;
    }

    /**
     * Set position in list
     *
     * @param positionInList
     */
    public void setPositionInList(Integer positionInList) {
        this.positionInList = positionInList;
    }


    /**
     * Gets book.
     *
     * @return the book
     */
    public BookBean getBook() {
        return book;
    }

    /**
     * Get status
     *
     * @return status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Set status
     *
     * @param status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Sets book.
     *
     * @param book the book
     */
    public void setBook(BookBean book) {
        this.book = book;
    }

    public Integer getNbreDeDemande() {
        return nbreDeDemande;
    }

    public void setNbreDeDemande(Integer nbreDeDemande) {
        this.nbreDeDemande = nbreDeDemande;
    }

    @Override
    public String toString() {
        return "WaitingListBean  [id=" + id +
                ", userBookId=" + userBookId +
                ", dateDeRetour=" + dateDeRetour +
                ", positionInList=" + positionInList +
                ", status=" + status +
                "]";
    }

}
