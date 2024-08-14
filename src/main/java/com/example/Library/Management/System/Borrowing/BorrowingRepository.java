package com.example.Library.Management.System.Borrowing;

import com.example.Library.Management.System.Patron.Patron;
import com.example.Library.Management.System.book.book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
    Optional<Borrowing> findBorrowingById(book book, Patron patron);
}
