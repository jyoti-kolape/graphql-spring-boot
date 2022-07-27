package com.example.graphqlspringboot.repository;

import com.example.graphqlspringboot.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
