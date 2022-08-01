package com.example.graphqlspringboot.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer age;

    public Author(Long id) {
        this.id = id;
    }
    public Author(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
