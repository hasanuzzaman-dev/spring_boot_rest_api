package com.hasan.springbootrestapi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String authorName;
    private String authorAddress;
    private String language;

    @OneToOne(mappedBy = "author")
    @JsonBackReference
    private Book book;

    public Author() {
    }

    public Author(int id, String authorName, String authorAddress, String language, Book book) {
        this.id = id;
        this.authorName = authorName;
        this.authorAddress = authorAddress;
        this.language = language;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorAddress() {
        return authorAddress;
    }

    public void setAuthorAddress(String authorAddress) {
        this.authorAddress = authorAddress;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", authorAddress='" + authorAddress + '\'' +
                ", language='" + language + '\'' +
                ", book=" + book +
                '}';
    }
}
