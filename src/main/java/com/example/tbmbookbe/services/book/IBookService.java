package com.example.tbmbookbe.services.book;

import com.example.tbmbookbe.dto.request.BookRequest;
import com.example.tbmbookbe.dto.response.BookResponse;

public interface IBookService {
    BookResponse create (BookRequest request);
    BookResponse update (Integer id, BookRequest request);
    BookResponse findById(Integer id);
}
