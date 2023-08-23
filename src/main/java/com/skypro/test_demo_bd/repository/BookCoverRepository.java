package com.skypro.test_demo_bd.repository;

import com.skypro.test_demo_bd.model.Book;
import com.skypro.test_demo_bd.model.BookCover;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookCoverRepository extends JpaRepository<BookCover, Long> {
    Optional<BookCover> findByBookId(Long bookId);
}
