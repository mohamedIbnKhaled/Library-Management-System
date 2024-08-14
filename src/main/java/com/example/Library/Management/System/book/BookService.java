package com.example.Library.Management.System.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class BookService {
  @Autowired
    private BookReposutiry bookReposutiry;
  public List <book> getAllBooks(){
      return bookReposutiry.findAll();
  }
  public Optional<book> getBookById(Long id){
      return  bookReposutiry.findById(id);
  }
    public book updateBook(Long id, book bookDetails) {
        return bookReposutiry.findById(id).map(book -> {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setPublictionYear(bookDetails.getPublictionYear());
            book.setIsbn(bookDetails.getIsbn());
            book.setQuantity(bookDetails.getQuantity());
            return bookReposutiry.save(book);
        }).orElseThrow(() -> new RuntimeException("Book not found with id " + id));
    }
    public book addBook (book book){
      return bookReposutiry.save(book);
    }

    public void deleteBook(Long id) {
        bookReposutiry.deleteById(id);
    }
}
