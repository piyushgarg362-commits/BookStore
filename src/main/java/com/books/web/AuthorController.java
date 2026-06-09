package com.books.web;

import com.books.model.Author;
import com.books.repo.AuthorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthorController {
    private final AuthorRepository repository;

    @Autowired
    public AuthorController(AuthorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/author/list")
    public List<Author> getAuthorsList() {
        return repository.findAll();
    }

    @GetMapping("/author/{id}")
    public Author getAuthor(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/author/create")
    public Author createAuthor(@RequestBody Author author) {
        return repository.saveAndFlush(author);
    }
}