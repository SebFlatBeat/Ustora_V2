package com.Ustora.book.beans;

import com.Ustora.book.entities.Book;
import com.Ustora.book.entities.Reservation;
import com.Ustora.book.entities.WaitingList;

import java.util.Optional;

public class WaitingListBean {
    private Optional<Book> book;
    private Optional<Reservation> reservation;
    private WaitingList waitingList;
    private Integer positionInList;
    private String status;

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

    public void setWaitingList(WaitingList waitingList) {
        this.waitingList = waitingList;
    }

    public Integer getPositionInList() {
        return positionInList;
    }

    public void setPositionInList(Integer positionInList) {
        this.positionInList = positionInList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
