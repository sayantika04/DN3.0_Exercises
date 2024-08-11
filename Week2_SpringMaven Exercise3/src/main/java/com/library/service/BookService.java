package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter method for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Additional methods for BookService
    public void someServiceMethod() {
        // Example method using BookRepository
        bookRepository.someRepositoryMethod();
    }
}
