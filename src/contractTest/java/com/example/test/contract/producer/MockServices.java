package com.example.test.contract.producer;

import com.example.test.contract.producer.entity.Book;
import com.example.test.contract.producer.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

public class MockServices {

    @MockBean
    private BookService bookService;

    @BeforeEach
    public void mockData() {
        mockBooks();
    }

    private void mockBooks() {
        Mockito.doReturn(List.of(
                        new Book("Foo Book","John Doe"),
                        new Book("Another Foo Book","Jane Smith")))
                .when(bookService)
                .findBooks("foo");
    }
}
