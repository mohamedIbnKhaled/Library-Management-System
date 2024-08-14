package com.example.Library.Management.System.Borrowing;

import com.example.Library.Management.System.Patron.Patron;
import com.example.Library.Management.System.Patron.PatronRepository;
import com.example.Library.Management.System.Patron.PatronService;
import com.example.Library.Management.System.book.BookReposutiry;
import com.example.Library.Management.System.book.BookService;
import com.example.Library.Management.System.book.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.time.LocalDate;

@Service
public class BorrowingService {
    @Autowired
    private BorrowingRepository borrowingRepository;
    @Autowired
    private BookService bookService;
    @Autowired
    private PatronService patronService;
    @Autowired
    private BookReposutiry bookReposutiry;
    @Autowired
    private PatronRepository patronRepository;

    public Borrowing borrowBook(Long bookId,Long patronId) {
        book book= bookReposutiry.findById(bookId).orElseThrow(()->new RuntimeException("Book not found"));
        Patron patron = patronRepository.findById(patronId).orElseThrow(()->new RuntimeException("Patron not found"));

        Borrowing borrowing = new Borrowing();
        borrowing.setBook(book);
        borrowing.setPatron(patron);
        borrowing.setBorrowDate(LocalDate.now());
        return borrowingRepository.save(borrowing);
    }
    public Borrowing returnBook(Long bookId,Long patronId) {
        book book= bookReposutiry.findById(bookId).orElseThrow(()->new RuntimeException("Book not found"));
        Patron patron = patronRepository.findById(patronId).orElseThrow(()->new RuntimeException("Patron not found"));
        Borrowing borrowing = borrowingRepository.findBorrowingById(book,patron).orElseThrow(()->new RuntimeException("Borrowing not found"));
        borrowing.setBorrowDate(LocalDate.now());
        return borrowingRepository.save(borrowing);
    }


}
