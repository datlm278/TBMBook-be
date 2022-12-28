package com.example.tbmbookbe.services.book;

import com.example.tbmbookbe.dto.request.BookRequest;
import com.example.tbmbookbe.dto.response.BookResponse;
import com.example.tbmbookbe.models.Book;
import com.example.tbmbookbe.repositories.BookRepository;
import com.example.tbmbookbe.repositories.ProducerRepository;
import com.example.tbmbookbe.repositories.TypeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {
    private final BookRepository bookRepository;
    private final TypeRepository typeRepository;
    private final ProducerRepository producerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BookService(BookRepository bookRepository,
                       TypeRepository typeRepository,
                       ProducerRepository producerRepository,
                       ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.typeRepository = typeRepository;
        this.producerRepository = producerRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public BookResponse create(BookRequest request) {
        Book book = modelMapper.map(request, Book.class);

        if (typeRepository.findById(request.getTypeId()).isEmpty()) {
            throw new EntityNotFoundException("type isn't existed");
        }

        if (producerRepository.findById(request.getProducerId()).isEmpty()) {
            throw new EntityNotFoundException("producer isn't existed");
        }

        book = bookRepository.save(book);

        return modelMapper.map(book, BookResponse.class);
    }

    @Override
    public BookResponse update(Integer id, BookRequest request) {
        Book book = modelMapper.map(request, Book.class);

        bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("book isn't existed"));

        typeRepository.findById(request.getTypeId()).orElseThrow(() -> new EntityNotFoundException("type isn't existed"));

        producerRepository.findById(request.getProducerId()).orElseThrow(
                () -> new EntityNotFoundException("producer isn't existed"));

        book = bookRepository.save(book);

        return modelMapper.map(book, BookResponse.class);
    }

    @Override
    public BookResponse findById(Integer id) {

        Book book = bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("book isn't existed"));

        return modelMapper.map(book, BookResponse.class);
    }
}
