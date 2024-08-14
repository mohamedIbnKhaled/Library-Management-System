package com.example.Library.Management.System.book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookReposutiry extends  JpaRepository<book,Long>  {

}
