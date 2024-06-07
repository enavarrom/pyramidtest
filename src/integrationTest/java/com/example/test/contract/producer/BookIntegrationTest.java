package com.example.test.contract.producer;

import com.example.test.contract.producer.service.BookService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@Sql(value = "/books.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
class BookIntegrationTest {

    @Autowired
    private BookService bookService;

    @Test
    void findOneBookWhenExistByKeyword() {
        var resultBooks = bookService.findBooks("Programming");
        Assertions.assertThat(resultBooks)
                .isNotEmpty()
                .hasSize(1);
    }

    @Test
    void findAllBooksWhenExistByKeyword() {
        var resultBooks = bookService.findBooks("Java");
        Assertions.assertThat(resultBooks)
                .isNotEmpty()
                .hasSize(2);
    }

    @Test
    void findBooksWhenNotExistByKeyword() {
        var resultBooks = bookService.findBooks("Other");
        Assertions.assertThat(resultBooks)
                .isEmpty();
    }

}
