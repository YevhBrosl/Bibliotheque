package com.bibliotheque.models;

public class Book {

    private int id;
    private String title;
    private String authorName;
    private String authorSurname;
    private String year;
    private String isbn;
    private String publisher;
    private int quantity;
    private int available;

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getId() {
        return id;
    }

    public Book setId(int id) {
        this.id = id;
        return this;
    }

    public String getAuthorName() {
        return authorName;
    }

    public Book setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public Book setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
        return this;
    }

    public String getYear() {
        return year;
    }

    public Book setYear(String year) {
        this.year = year;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public Book setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public Book setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public Book setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public int getAvailable() {
        return available;
    }

    public Book setAvailable(int available) {
        this.available = available;
        return this;
    }
}
