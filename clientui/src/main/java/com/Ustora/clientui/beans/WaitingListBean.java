package com.Ustora.clientui.beans;

import java.util.Date;

public class WaitingListBean {
    private Long id;
    private Long userBookId;
    private Date dateOfDemand;
    private boolean waiting;
    private boolean timeout;

    private BookBean book;

    public WaitingListBean() {
    }

    public WaitingListBean(Long id, Long userBookId, Date dateOfDemand, boolean waiting, boolean timeout, BookBean book) {
        this.id = id;
        this.userBookId = userBookId;
        this.dateOfDemand = dateOfDemand;
        this.waiting = waiting;
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
     * Gets waiting
     *
     * @return waiting
     */
    public boolean isWaiting() {
        return waiting;
    }

    /**
     * Sets waiting
     *
     * @return waiting
     */
    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
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
    public BookBean getBook() {
        return book;
    }

    /**
     * Sets book.
     *
     * @param book the book
     */
    public void setBook(BookBean book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "WaitingListBean  [id=" + id +
                ", userBookId=" + userBookId +
                ", dateOfDemand=" + dateOfDemand +
                ", waiting=" + waiting +
                ", timeout=" + timeout +
                "]";
    }

}
