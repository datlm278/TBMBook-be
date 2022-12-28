package com.example.tbmbookbe.controller;

import com.example.tbmbookbe.dto.request.BookRequest;
import com.example.tbmbookbe.dto.response.BookResponse;
import com.example.tbmbookbe.services.book.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<BookResponse> createBook(@RequestBody BookRequest request) {
        return ResponseEntity.ok().body(bookService.create(request));
    }

    @PostMapping(value = "/update")
    public ResponseEntity<BookResponse> updateBook(@RequestParam Integer id, @RequestBody BookRequest request) {
        return ResponseEntity.ok().body(bookService.update(id, request));
    }

    @GetMapping(value = "/find-by-id")
    public ResponseEntity<BookResponse> findBookById(@RequestParam Integer id) {
        return ResponseEntity.ok().body(bookService.findById(id));
    }

}
