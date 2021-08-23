package com.hasan.springbootrestapi.controller;

import com.hasan.springbootrestapi.entities.Book;
import com.hasan.springbootrestapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks() {
        return this.bookService.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable("id") int id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        this.bookService.addBook(book);
        return book;

    }

    @DeleteMapping("books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId) {
        this.bookService.deleteBook(bookId);
    }

    // update book handler
    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable("id") int id) {
        this.bookService.updateBook(book, id);
        return book;

    }


}
