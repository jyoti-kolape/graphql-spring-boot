package com.example.graphqlspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Library {

    @Id
    private int id;
    private String name;
    private Address address;
    private List<Book> books;
}
