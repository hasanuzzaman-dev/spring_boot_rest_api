package com.hasan.springbootrestapi.repositories;

import com.hasan.springbootrestapi.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {

    Book findById(int id);
}
