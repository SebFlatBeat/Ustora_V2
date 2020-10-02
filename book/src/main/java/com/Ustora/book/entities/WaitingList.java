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
    private boolean readyToTake;
    private boolean timeout;

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
     *
     * @param id
     * @param userBookId
     * @param dateOfDemand
     * @param readyToTake
     * @param timeout
     * @param book
     */
    public WaitingList(Long id, Long userBookId, Date dateOfDemand, boolean readyToTake, boolean timeout, Book book) {
        this.id = id;
        this.userBookId = userBookId;
        this.dateOfDemand = dateOfDemand;
        this.readyToTake = readyToTake;
        this.timeout = timeout;
        this.book = book;
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
     * Gets date of Demand
     *
     * @return date of demand
     */
    public Date getDateOfDemand() {
        return dateOfDemand;
    }

    /**
     * Sets date of Demand
     *
     * @return date df demand
     */
    public void setDateOfDemand(Date dateOfDemand) {
        this.dateOfDemand = dateOfDemand;
    }

    /**
     * Gets ready to take
     *
     * @return ready to take
     */
    public boolean isReadyToTake() {
        return readyToTake;
    }

    /**
     * Sets ready to take
     *
     * @return ready to take
     */
    public void setReadyToTake(boolean readyToTake) {
        this.readyToTake = readyToTake;
    }

    /**
     * Gets timeout
     *
     * @return timeout
     */
    public boolean isTimeout() {
        return timeout;
    }

    /**
     * Sets timeout
     *
     * @return timeout
     */
    public void setTimeout(boolean timeout) {
        this.timeout = timeout;
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
                ", dateOfDemand=" + dateOfDemand +
                ", readyToTake=" + readyToTake +
                ", timeout=" + timeout +
                "]";
    }
}
