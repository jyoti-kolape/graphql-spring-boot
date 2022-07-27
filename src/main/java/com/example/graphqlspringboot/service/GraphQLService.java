package com.example.graphqlspringboot.service;

import com.example.graphqlspringboot.model.Book;
import com.example.graphqlspringboot.repository.BookRepository;
import com.example.graphqlspringboot.service.datafetcher.AllBookDataFetcher;
import com.example.graphqlspringboot.service.datafetcher.BookDataFetcher;
import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

@Service
@Component
public class GraphQLService {

    @Autowired
    BookRepository bookRepository;

    @Value("classpath:books.graphql")
    Resource resource;

    private GraphQL graphQL;

    @Autowired
    private AllBookDataFetcher allBookDataFetcher;
    @Autowired
    private BookDataFetcher bookDataFetcher;

    @PostConstruct
    private void loadSchema() throws IOException{
        loadDataIntoHSQL();
        File schemaFile = resource.getFile();
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring runtimeWiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
        graphQL =GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring.dataFetcher("allBooks", allBookDataFetcher)
                        .dataFetcher("book", bookDataFetcher))
                .build();
    }

    public GraphQL getGraphQL() {
        return graphQL;
    }

    private void loadDataIntoHSQL() {

        Stream.of(
                new Book("123", "Books of Clouds", "Kindle Edition", new String[]{"Chloe Aridjis"},"Nov 2017"),
                new Book("124", "Cloud Artchitecture and Engineering", "Orielly", new String[]{"Peter", "Sam"},"Jan 2015"),
                new Book("125", "Java 9 Programming", "Orielly", new String[]{"Venkat", "Ram"},"Jan 2016")
        ).forEach(book -> {
            bookRepository.save(book);
        });

    }
}
