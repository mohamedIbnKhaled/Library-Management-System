package com.example.Library.Management.System.Borrowing;

import com.example.Library.Management.System.Patron.Patron;
import jakarta.persistence.*;

import com.example.Library.Management.System.book.book;


import java.time.LocalDate;

@Entity
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name="book_id",nullable = false)
    private book book;
    @ManyToOne
    @JoinColumn(name="patron_id",nullable = false)
    private Patron patron;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public Borrowing() {
    }

    public Borrowing(int id, com.example.Library.Management.System.book.book book, Patron patron, LocalDate borrowDate, LocalDate returnDate) {
        this.id = id;
        this.book = book;
        this.patron = patron;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public Borrowing(com.example.Library.Management.System.book.book book, Patron patron, LocalDate borrowDate, LocalDate returnDate) {
        this.book = book;
        this.patron = patron;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public com.example.Library.Management.System.book.book getBook() {
        return book;
    }

    public void setBook(com.example.Library.Management.System.book.book book) {
        this.book = book;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
