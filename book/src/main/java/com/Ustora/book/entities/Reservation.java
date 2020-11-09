package com.Ustora.book.entities;

import org.hibernate.annotations.Cascade;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The type Reservation.
 */
@Entity
public class Reservation implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private Long userBookId;
    private Date borrowing;
    private Date endBorrowing;
    private boolean extend;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    private Book book;

    /**
     * Instantiates a new Reservation.
     */
    public Reservation(){
    }

    /**
     * Instantiates a new Reservation.
     *
     * @param userBookId   the user book id
     * @param borrowing    the borrowing
     * @param endBorrowing the end borrowing
     * @param extend       the extend
     */
    public Reservation(Long userBookId, Date borrowing,Date endBorrowing, boolean extend) {

        this.userBookId = userBookId;
        this.borrowing = borrowing;
        this.endBorrowing = endBorrowing;
        this.extend = extend;

    }

    /**
     *
     * @param id
     * @param userBookId
     * @param borrowing
     * @param endBorrowing
     * @param extend
     */
    public Reservation(Long id, Long userBookId, Date borrowing,Date endBorrowing, boolean extend) {
        this.id = id;
        this.userBookId = userBookId;
        this.borrowing = borrowing;
        this.endBorrowing = endBorrowing;
        this.extend = extend;

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
     * Gets borrowing.
     *
     * @return the borrowing
     */
    public Date getBorrowing() {
        return borrowing;
    }

    /**
     * Sets borrowing.
     *
     * @param borrowing the borrowing
     */
    public void setBorrowing(Date borrowing) {
        this.borrowing = borrowing;
    }

    /**
     * Gets end borrowing.
     *
     * @return the end borrowing
     */
    public Date getEndBorrowing() {
        return endBorrowing;
    }

    /**
     * Sets end borrowing.
     *
     * @param endBorrowing the end borrowing
     */
    public void setEndBorrowing(Date endBorrowing) {
        this.endBorrowing = endBorrowing;
    }

    /**
     * Is extend boolean.
     *
     * @return the boolean
     */
    public boolean isExtend() {
        return extend;
    }

    /**
     * Sets extend.
     *
     * @param extend the extend
     */
    public void setExtend(boolean extend) {
        this.extend = extend;
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
     * @param userBookId the user book id
     */
    public void setUserBookId(Long userBookId) {
        this.userBookId = userBookId;
    }


    /**
     * Sets book.
     *
     * @param book the book
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * Gets book.
     *
     * @return the book
     */
    public Book getBook() {
        return book;
    }

    @Override
    public String toString() {
        return "Reservation  [id=" + id +
                ", userBookId=" + userBookId +
                ", borrowing=" + borrowing +
                ", extend=" + extend + "]";
    }
}
