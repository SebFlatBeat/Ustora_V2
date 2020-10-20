package com.Ustora.book.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
public class WaitingList implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private Long userBookId;
    @NotNull
    private Date dateOfDemand;
    private Integer positionInList;
    private boolean mailSend;
    private Date dateMailSent;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    private Book book;

    @Enumerated(EnumType.STRING)
    private Status status;

    /**
     * Instantiates a new WaitingList
     */
    public WaitingList() {
    }

    /**
     *
     * @param id
     * @param userBookId
     * @param dateOfDemand
     * @param positionInList
     * @param mailSend
     * @param dateMailSent
     * @param status
     * @param book
     */
    public WaitingList(Long id, Long userBookId, Date dateOfDemand,Integer positionInList, boolean mailSend, Date dateMailSent, Status status, Book book) {
        this.id = id;
        this.userBookId = userBookId;
        this.dateOfDemand = dateOfDemand;
        this.positionInList = positionInList;
        this.mailSend = mailSend;
        this.dateMailSent = dateMailSent;
        this.status = status;
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
     *Gets position in list
     *
     * @return position in list
     */
    public Integer getPositionInList() {
        return positionInList;
    }

    /**
     *Sets position in list
     *
     * @param positionInList
     */
    public void setPositionInList(Integer positionInList) {
        this.positionInList = positionInList;
    }

    /**
     *Gets mail send
     *
     * @return mail send
     */
    public boolean isMailSend() {
        return mailSend;
    }

    /**
     *Sets mail send
     * @param mailSend
     */
    public void setMailSend(boolean mailSend) {
        this.mailSend = mailSend;
    }

    /**
     * Gets date mail sent
     * @return date mail sent
     */
    public Date getDateMailSent() {
        return dateMailSent;
    }

    /**
     * Sets date mail sent
     * @param dateMailSent
     */
    public void setDateMailSent(Date dateMailSent) {
        this.dateMailSent = dateMailSent;
    }

    /**
     * Gets Status
     *
     * @return status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets status
     *
     * @param status
     */
    public void setStatus(Status status) {
        this.status = status;
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
                ", positionInList=" + positionInList +
                ", mailSend=" + mailSend +
                ", dateMailSent=" + dateMailSent +
                "]";
    }
}
