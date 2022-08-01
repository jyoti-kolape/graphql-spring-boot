package com.example.graphqlspringboot.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphqlspringboot.model.Author;
import com.example.graphqlspringboot.model.Tutorial;
import com.example.graphqlspringboot.repository.AuthorRepository;
import com.example.graphqlspringboot.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private TutorialRepository tutorialRepository;

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }
    public Iterable<Tutorial> findAllTutorials() {
        return tutorialRepository.findAll();
    }
    public long countAuthors() {
        return authorRepository.count();
    }
    public long countTutorials() {
        return tutorialRepository.count();
    }
}
