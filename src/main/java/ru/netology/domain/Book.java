package ru.netology.domain;

import java.util.Objects;

public class Book extends Product {
    private String author;


    public Book() {
        super();
    }

    public Book(int id, String name, String author, int price) {
        super(id, name, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return super.equals(o) && Objects.equals(author, book.author);

    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author);
    }
}