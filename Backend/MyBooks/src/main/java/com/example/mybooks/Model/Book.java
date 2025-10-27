package com.example.mybooks.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    private String title;
    @NotNull
    private String author;
    private int publishingYear;
    private String isbn;

    public Book() {
    }
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
