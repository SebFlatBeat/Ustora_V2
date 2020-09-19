package com.Ustora.clientui.beans;


import java.util.Date;

public class ReservationBean {

    private Long id;
    private Long bookId;
    private Long userId;
    private Date borrowing;
    private Date endBorrowing;
    private boolean extend;

    private BookBean book;

    public ReservationBean() {
    }

    public ReservationBean(Long id, Long bookId, Long userId, Date borrowing,Date endBorrowing, boolean extend) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.borrowing = borrowing;
        this.endBorrowing = endBorrowing;
        this.extend = extend;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getBorrowing() {
        return borrowing;
    }

    public void setBorrowing(Date borrowing) {
        this.borrowing = borrowing;
    }

    public Date getEndBorrowing() {
        return endBorrowing;
    }

    public void setEndBorrowing(Date endBorrowing) {
        this.endBorrowing = endBorrowing;
    }

    public boolean isExtend() {
        return extend;
    }

    public void setExtend(boolean extend) {
        this.extend = extend;
    }

    public BookBean getBook() {
        return book;
    }

    public void setBook(BookBean book) {
        this.book = book;
    }
}

