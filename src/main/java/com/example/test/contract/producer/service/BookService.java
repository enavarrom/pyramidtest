package com.example.test.contract.producer.service;

import com.example.test.contract.producer.entity.Book;
import com.example.test.contract.producer.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findBooks(String titleKeyword) {
        return sortedBooks(bookRepository.findByTitleContaining(titleKeyword));
    }

    private List<Book> sortedBooks(List<Book> books) {
        return books
                .stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .toList();
    }

}
