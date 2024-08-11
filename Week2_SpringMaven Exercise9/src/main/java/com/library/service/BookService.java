package com.library.service;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    public void someMethod() {
        System.out.println("Executing someMethod in BookService");
    }

    public void anotherMethod() {
        System.out.println("Executing anotherMethod in BookService");
    }
}
