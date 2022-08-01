package com.example.graphqlspringboot.repository;

import com.example.graphqlspringboot.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
}
