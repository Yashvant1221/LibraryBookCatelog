package com.library.service;

import com.library.dto.Book;
import com.library.exception.BookNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BookServiceImpl implements BookService {

    private final List<Book> bookList = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    @Override
    public Book addBook(Book book) {
        book.setId(idCounter.getAndIncrement());
        bookList.add(book);
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookList;
    }

    @Override
    public Book getBookById(Integer id) {
        return bookList.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Book not found with ID: " + id));
    }

    @Override
    public void deleteBook(Integer id) {
        Book book = getBookById(id);
        bookList.remove(book);
    }

    @Override
    public Book updateAvailability(Integer id, Boolean available) {
        Book book = getBookById(id);
        book.setAvailable(available);
        return book;
    }

}
