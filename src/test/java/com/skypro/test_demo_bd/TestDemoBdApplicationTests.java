package com.skypro.test_demo_bd;

import com.skypro.test_demo_bd.controller.BooksController;

import com.skypro.test_demo_bd.model.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestDemoBdApplicationTests {
    @LocalServerPort
    private int port;

    @Autowired
    private BooksController booksController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws Exception {
        Assertions.assertThat(booksController).isNotNull();
    }

    @Test
    public void testDefaultMessage() throws Exception {
        Assertions.assertThat(
                        this.restTemplate.getForObject("http://localhost:" + port + "/", String.class))
                .contains("Hola");
    }

    @Test
    public void testGetBooks() throws Exception {
        Assertions.assertThat(
                        this.restTemplate.getForObject("http://localhost:" + port + "/books", String.class))
                .isNotNull();
    }

    @Test
    public void testPostBooks() throws Exception {
        Book book = new Book();
        book.setName("Lalala");
        book.setAuthor("Myke Towers");
        Assertions.assertThat(
                        this.restTemplate.postForObject("http://localhost:" + port + "/books", book, String.class))
                .isNotNull();

    }
}
