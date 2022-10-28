package com.gcit.siva.spring.web;

import com.gcit.siva.spring.BookServiceApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookServiceApplication.Book, Long> {}