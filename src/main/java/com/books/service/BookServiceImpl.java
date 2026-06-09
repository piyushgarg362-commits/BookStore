package com.books.service;

import com.books.model.Book;
import com.books.repo.BookRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository repository;

    @Autowired
    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Book saveAndFlush(Book book) {
        return repository.saveAndFlush(book);
    }

    @Override
    public List<Book> saveAll(Iterable<Book> books) {
        return repository.saveAll(books);
    }

    @Override
    public void deleteBook(Book book) {
        repository.delete(book);
    }
}