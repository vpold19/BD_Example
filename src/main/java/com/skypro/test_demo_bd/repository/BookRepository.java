package com.skypro.test_demo_bd.repository;

import com.skypro.test_demo_bd.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByName(String name);

    Collection<Book> findBooksByAuthor(String author);

    Collection<Book> findAllByNameContains(String part);

}
