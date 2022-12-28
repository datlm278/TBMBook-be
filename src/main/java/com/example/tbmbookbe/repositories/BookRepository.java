package com.example.tbmbookbe.repositories;

import com.example.tbmbookbe.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
