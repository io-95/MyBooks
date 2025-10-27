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
    public Book(String title, String author, int publishingYear, String isbn) {
        this.title = title;
        this.author = author;
        this.publishingYear = publishingYear;
        this.isbn = isbn;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
