package com.skypro.test_demo_bd.repository;

import com.skypro.test_demo_bd.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByNameIgnoreCase(String name);

    Collection<Book> findBooksByAuthorContainsIgnoreCase(String author);

    Collection<Book> findAllByNameContainsIgnoreCase(String part);

    //Collection<Book> findBooksByNameIgnoreCaseAndAuthorIgnoreCase(String name, String author);
//Collection<Book> findBooksByNameOrAuthorAndGreaterThan(String name, String author, Long number);
}
