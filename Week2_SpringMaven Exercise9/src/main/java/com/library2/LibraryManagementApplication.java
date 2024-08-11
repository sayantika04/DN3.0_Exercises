package com.library2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the BookService bean from the context
        BookService bookService = context.getBean(BookService.class);

        // Call methods to test AOP functionality
        bookService.someMethod(); // This will be intercepted by LoggingAspect
        bookService.anotherMethod(); // This will also be intercepted by LoggingAspect
    }
}



