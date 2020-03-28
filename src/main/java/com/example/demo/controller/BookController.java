package com.example.demo.controller;

import com.example.demo.dto.BookDto;
import com.example.demo.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/book")
    public void addBook(@RequestBody BookDto bookDto) {
        bookService.addBook(bookDto);
    }

    /*
    localhost:8080/book/1?title=newTitle
     */
    @PutMapping("/book/{id}")
    public void updateBookTitle(@PathVariable Long id, @RequestParam String title) {
        bookService.updateBookTitle(id, title);
    }
}
