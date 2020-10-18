package com.Ustora.clientui.beans;

import java.util.Date;

public class WaitingListBean {
    private Long id;
    private Long userBookId;
    private Date dateDeRetour;
    private Integer positionInList;
    private String status;

    private BookBean book;

    public WaitingListBean() {
    }

    public WaitingListBean(Long id, Long userBookId, Date dateDeRetour, Integer positionInList, BookBean book) {
        this.id = id;
        this.userBookId = userBookId;
        this.dateDeRetour = dateDeRetour;
        this.positionInList = positionInList;
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
    public Date getDateDeRetour() {
        return dateDeRetour;
    }

    /**
     * Sets date of Demand
     *
     * @return date df demand
     */
    public void setDateDeRetour(Date dateDeRetour) {
        this.dateDeRetour = dateDeRetour;
    }

    public Integer getPositionInList() {
        return positionInList;
    }

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
                ", dateDeRetour=" + dateDeRetour +
                ", positionInList=" + positionInList +
                "]";
    }

}
