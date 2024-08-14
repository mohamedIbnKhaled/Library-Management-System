package com.example.Library.Management.System.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path= "/api/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping
    public List<book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<book> getBookById(@PathVariable Long id){
        return bookService.getBookById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public book addBook(@RequestBody book book){
        return bookService.addBook(book);
    }
    @PutMapping("/{id}")
    public ResponseEntity<book> updateBook(@PathVariable Long id, @RequestBody book bookDetails){
        return bookService.getBookById(id).map(book->ResponseEntity.ok(bookService.updateBook(id,bookDetails))).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Optional<book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            bookService.deleteBook(id);
            return ResponseEntity.noContent().build(); // Returns HTTP 204 No Content
        } else {
            throw new RuntimeException  ("Book not found with id " + id);
        }
    }

}
