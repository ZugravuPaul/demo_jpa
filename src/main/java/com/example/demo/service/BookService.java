package com.example.demo.service;

import com.example.demo.Book;
import com.example.demo.BookRepository;
import com.example.demo.dto.BookDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepository bookRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDto> getAllBooks() {
        return ((List<Book>)  bookRepository.findAll()).stream()
                .map(book -> modelMapper.map(book, BookDto.class))
                .collect(Collectors.toList());
    }
}
