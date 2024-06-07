import com.example.test.contract.producer.entity.Book;
import com.example.test.contract.producer.repository.BookRepository;
import com.example.test.contract.producer.service.BookService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

class BookServiceComponentTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findBooksWhenExistByKeyword() {
        List<Book> existBooks = List.of(new Book("B libro1","autor1"),
                new Book("A libro2", "autor2"));

        //When
        Mockito.doReturn(existBooks)
                .when(bookRepository)
                .findByTitleContaining(Mockito.anyString());

        //Then
        List<Book> resultBooks = bookService.findBooks("foo");

        //Assert
        Assertions.assertThat(resultBooks)
                .isNotEmpty()
                .containsAll(existBooks);

        Mockito.verify(bookRepository, Mockito.times(1))
                .findByTitleContaining(Mockito.anyString());
    }

    @Test
    void findBooksWhenNotExistByKeyword() {
        //When
        Mockito.doReturn(Collections.emptyList())
                .when(bookRepository)
                .findByTitleContaining(Mockito.anyString());

        //Then
        List<Book> resultBooks = bookService.findBooks("foo");

        //Assert
        Assertions.assertThat(resultBooks)
                .isEmpty();

        Mockito.verify(bookRepository, Mockito.times(1))
                .findByTitleContaining(Mockito.anyString());
    }



}
