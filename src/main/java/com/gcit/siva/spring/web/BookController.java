package com.gcit.siva.spring.web;

import com.gcit.siva.spring.BookServiceApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@Component
class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    Iterable<BookServiceApplication.Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping
    BookServiceApplication.Book addNewBook(@RequestBody BookServiceApplication.Book book) {
        return bookRepository.save(book);
    }
}