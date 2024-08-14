package com.example.Library.Management.System.Borrowing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrowing")
public class BorrowingController {
    @Autowired
    private BorrowingService borrowingService;
    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<Borrowing>borrowBook(@PathVariable Long bookId, @PathVariable Long patronId){
        Borrowing borrowing = borrowingService.borrowBook(bookId, patronId);
        return ResponseEntity.status(HttpStatus.CREATED).body(borrowing);
    }
    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<Borrowing> returnBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        Borrowing borrowing = borrowingService.returnBook(bookId, patronId);
        return ResponseEntity.ok(borrowing);
    }
}
