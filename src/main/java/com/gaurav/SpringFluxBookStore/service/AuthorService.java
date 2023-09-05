package com.gaurav.SpringFluxBookStore.service;

import com.gaurav.SpringFluxBookStore.model.Author;
import com.gaurav.SpringFluxBookStore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Mono<Author> addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Flux<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Flux<Author> getSelectedAuthor(String names) {
        return authorRepository.findByNameRegex(names);
    }

    public Mono<Author> getBookByAuthor(String name){
        return authorRepository.findByName(name);
    }
}
