package com.example.graphqlspringboot.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphqlspringboot.model.Author;
import com.example.graphqlspringboot.model.Tutorial;
import com.example.graphqlspringboot.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TutorialResolver implements GraphQLResolver<Tutorial> {

    @Autowired
    private AuthorRepository authorRepository;

    public TutorialResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public Author getAuthor(Tutorial tutorial) {
        return authorRepository.findById(tutorial.getAuthor().getId()).orElseThrow(null);
    }
}
