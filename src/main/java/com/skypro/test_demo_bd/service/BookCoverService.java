package com.skypro.test_demo_bd.service;

import com.skypro.test_demo_bd.model.Book;
import com.skypro.test_demo_bd.repository.BookCoverRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Path;

@Service
@Transactional
public class BookCoverService {
    @Value("${books.cover.dir.path}")
    private String coversDir;

    private final BookService bookService;
    private final BookCoverRepository bookCoverRepository;

    public BookCoverService(BookService bookService, BookCoverRepository bookCoverRepository) {
        this.bookService = bookService;
        this.bookCoverRepository = bookCoverRepository;
    }

    public void uploadCover(Long bookId, MultipartFile file) throws IOException {
        Book book = bookService.findBook(bookId);

        Path filePath = Path.of(coversDir, bookId + "." + getExtension(file.getOriginalFilename()));
    }
}
