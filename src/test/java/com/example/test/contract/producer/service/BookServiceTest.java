package com.example.test.contract.producer.service;

import com.example.test.contract.producer.entity.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookServiceTest {


    private BookService bookService;

    @BeforeEach
    void setUp() {
        bookService = new BookService();
    }

    @Test
    void testSortedBooks() {
        // Arrange
        BookService bookService = new BookService();
        List<Book> unsortedBooks = List.of(
                new Book("C", "Author C"),
                new Book("A", "Author A"),
                new Book("B", "Author B")
        );

        // Act
        List<Book> sortedBooks = ReflectionTestUtils.invokeMethod(bookService,
                "sortedBooks", unsortedBooks);

        // Assert
        assert sortedBooks != null;
        assertEquals("A", sortedBooks.get(0).getTitle());
        assertEquals("B", sortedBooks.get(1).getTitle());
        assertEquals("C", sortedBooks.get(2).getTitle());
    }


}