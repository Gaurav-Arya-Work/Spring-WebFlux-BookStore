package com.gaurav.SpringFluxBookStore.controller;

import com.gaurav.SpringFluxBookStore.model.Author;
import com.gaurav.SpringFluxBookStore.model.Book;
import com.gaurav.SpringFluxBookStore.service.AuthorService;
import com.gaurav.SpringFluxBookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;


    @GetMapping
    public Flux<Author> getAllAuthor(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/getByAuthorName")
    public Flux<Author> getAuthorsByNameRegex(@RequestParam String nameRegex) {
        return authorService.getSelectedAuthor(nameRegex);
    }

    @GetMapping("/findBookByAuthor")
    public Flux<Book> getBookByAuthor(@RequestParam String name) {
        return authorService.getBookByAuthor(name).flatMapMany(author -> bookService.getBookByAuthorId(author.getAid()));
    }

    @PostMapping
    public Mono<Author> addAuthor(@RequestBody Author author){
        return authorService.addAuthor(author);
    }
}
