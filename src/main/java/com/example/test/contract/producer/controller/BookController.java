package com.example.test.contract.producer.controller;

import com.example.test.contract.producer.entity.Book;
import com.example.test.contract.producer.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> findBooks(@RequestParam String titleKeyword) {
        return ResponseEntity.ok(bookService.findBooks(titleKeyword));
    }
}
