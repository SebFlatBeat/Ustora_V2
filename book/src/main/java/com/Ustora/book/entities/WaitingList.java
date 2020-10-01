package com.Ustora.book.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
public class WaitingList implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private Long userBookId;
    private Date dateOfDemand;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    private Book book;

    /**
     * Instantiates a new WaitingList
     */
    public WaitingList() {
    }

    /**
     * Instantiates a new WaitingList
     * @param id
     * @param userBookId
     * @param dateOfDemand
     */
    public WaitingList(Long id, Long userBookId, Date dateOfDemand) {
        this.id = id;
        this.userBookId = userBookId;
        this.dateOfDemand = dateOfDemand;
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
     * Gets date of Demandd
     *
     * @return date of demand
     */
    public Date getDateOfDemand() {
        return dateOfDemand;
    }

    /**
     * Sets dateOfDemande
     *
     * @return dateOfDemand
     */
    public void setDateOfDemand(Date dateOfDemand) {
        this.dateOfDemand = dateOfDemand;
    }

    /**
     * Gets book.
     *
     * @return the book
     */
    public Book getBook() {
        return book;
    }

    /**
     * Sets book.
     *
     * @param book the book
     */
    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "WaitingList  [id=" + id +
                ", userBookId=" + userBookId +
                ", dateOfDemand=" + dateOfDemand + "]";
    }
}
