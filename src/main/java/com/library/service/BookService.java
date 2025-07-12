package com.library.service;

import com.library.dto.Book;

import java.util.List;

public interface BookService {
    Book addBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(Integer id);
    void deleteBook(Integer id);
    Book updateAvailability(Integer id, Boolean available);
}

