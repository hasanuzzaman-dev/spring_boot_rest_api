package com.hasan.springbootrestapi.services;

import com.hasan.springbootrestapi.entities.Book;
import com.hasan.springbootrestapi.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {

        List<Book> bookList = (List<Book>) this.bookRepository.findAll();
        return bookList;
    }

    public Book getBookById(int id) {
        Book findBook = null;
        try {
            findBook = this.bookRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return findBook;
    }

    // adding the book
    public Book addBook(Book book) {
        Book resultBook = bookRepository.save(book);
        return resultBook;
    }

    // delete book
    public void deleteBook(int bookId) {
        bookRepository.deleteById(bookId);
    }

    public void updateBook(Book book, int id) {
        book.setId(id);
        bookRepository.save(book);
    }


}
