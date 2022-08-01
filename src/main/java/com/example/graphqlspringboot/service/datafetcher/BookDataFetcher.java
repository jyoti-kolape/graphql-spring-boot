package com.example.graphqlspringboot.service.datafetcher;

import com.example.graphqlspringboot.model.Book;
import com.example.graphqlspringboot.repository.BookRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookDataFetcher implements DataFetcher<Optional<Book>> {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Optional<Book> get(DataFetchingEnvironment environment) throws Exception {
        return bookRepository.findById(environment.getArgument("id"));
    }
}
