package com.skypro.test_demo_bd.service;

import com.skypro.test_demo_bd.model.Book;
import com.skypro.test_demo_bd.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book findBook(long id) {
        return bookRepository.findById(id).get();
    }

    public Book editBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }

    public Collection<Book> getAllBooks() {
        return bookRepository.findAll();

    }

    public Book findByName(String name) {
        return bookRepository.findByNameIgnoreCase(name);
    }

    public Collection<Book> findBooksByAuthor(String author) {
        return bookRepository.findBooksByAuthorContainsIgnoreCase(author);
    }

    public Collection<Book> findAllByNameContains(String part) {
        return bookRepository.findAllByNameContainsIgnoreCase(part);
    }
}
