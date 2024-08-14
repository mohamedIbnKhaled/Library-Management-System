package com.example.Library.Management.System.book;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
@Entity
@Table(name = "book")
public class book {
    @Id
    private  long book_id;
    private String title;
    private String author;
    private LocalDate publictionYear;
    private String isbn;
    private String category;
    private int quantity;

    public book() {
    }

    public book(long book_id, String title, String author, LocalDate publictionYear, String isbn, String category, int quantity) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.publictionYear = publictionYear;
        this.isbn = isbn;
        this.category = category;
        this.quantity = quantity;
    }

    public book(String title, String author, LocalDate publictionYear, String isbn, String category, int quantity) {
        this.title = title;
        this.author = author;
        this.publictionYear = publictionYear;
        this.isbn = isbn;
        this.category = category;
        this.quantity = quantity;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublictionYear() {
        return publictionYear;
    }

    public void setPublictionYear(LocalDate publictionYear) {
        this.publictionYear = publictionYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "book{" +
                "book_id=" + book_id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publictionYear=" + publictionYear +
                ", isbn='" + isbn + '\'' +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
