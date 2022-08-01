package com.example.graphqlspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false, updatable = false)
    private Author author;

    public Tutorial(String title, String description, Author author) {
        this.title = title;
        this.description = description;
        this.author = author;
    }
}
