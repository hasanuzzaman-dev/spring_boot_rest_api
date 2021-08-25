package com.hasan.springbootrestapi.services;

import com.hasan.springbootrestapi.entities.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {

    private static List<Book> bookList = new ArrayList<>();

    static {
        bookList.add(new Book(2, "Java Complete Reference", "XYZ"));
        bookList.add(new Book(3, "Head First Java", "ABC"));
        bookList.add(new Book(4, "Java Programming", "ANM Bazlur Rahman"));
    }

    public List<Book> getAllBooks() {
        return bookList;
    }

    public Book getBookById(int id) {
        Book findBook = null;
        try {
            findBook = bookList.stream().filter(book ->
                    book.getId() == id
            ).findFirst().get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return findBook;
    }

    // adding the book
    public Book addBook(Book book) {
        return bookList.add(book);
    }

    // delete book
    public void deleteBook(int bookId) {
        bookList = bookList.stream().filter(book -> book.getId() != bookId).collect(Collectors.toList());
    }

    public void updateBook(Book book, int id) {
        bookList = bookList.stream().map(b -> {
            if (b.getId() == id) {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }

            return b;
        }).collect(Collectors.toList());
    }


}
