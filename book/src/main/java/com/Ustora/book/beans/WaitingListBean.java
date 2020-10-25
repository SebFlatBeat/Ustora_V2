package com.Ustora.book.beans;

import com.Ustora.book.entities.Book;
import com.Ustora.book.entities.Reservation;
import com.Ustora.book.entities.Status;
import com.Ustora.book.entities.WaitingList;

import java.util.Date;
import java.util.Optional;

public class WaitingListBean {
    private Optional<Book> book;
    private Optional<Reservation> reservation;
    private WaitingList waitingList;
    private Long id;
    private Date dateDeRetour;
    private Integer positionInList;
    private Status status;
    private Integer nbreDeDemande;

    public Optional<Book> getBook() {
        return book;
    }

    public void setBook(Optional<Book> book) {
        this.book = book;
    }

    public Optional<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(Optional<Reservation> reservation) {
        this.reservation = reservation;
    }

    public WaitingList getWaitingList() {
        return waitingList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWaitingList(WaitingList waitingList) {
        this.waitingList = waitingList;
    }

    public Date getDateDeRetour() {
        return dateDeRetour;
    }

    public void setDateDeRetour(Date dateDeRetour) {
        this.dateDeRetour = dateDeRetour;
    }

    public Integer getPositionInList() {
        return positionInList;
    }

    public void setPositionInList(Integer positionInList) {
        this.positionInList = positionInList;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getNbreDeDemande() {
        return nbreDeDemande;
    }

    public void setNbreDeDemande(Integer nbreDeDemande) {
        this.nbreDeDemande = nbreDeDemande;
    }
}
