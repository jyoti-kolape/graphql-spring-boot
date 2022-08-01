package com.example.graphqlspringboot.repository;

import com.example.graphqlspringboot.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
