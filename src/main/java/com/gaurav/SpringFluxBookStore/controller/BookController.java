package com.gaurav.SpringFluxBookStore.controller;

import com.gaurav.SpringFluxBookStore.model.Book;
import com.gaurav.SpringFluxBookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/hi")
    public String rootApi(){
        return "Start of the SpringBoot Application";
    }

    @GetMapping
    public ResponseEntity<Flux<Book>> getAllBooks(){
        return new ResponseEntity<Flux<Book>>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/{genre}")
    public ResponseEntity<Flux<Book>> getBookByGenre(@Valid @PathVariable String genre){
        return new ResponseEntity<Flux<Book>>(bookService.getBooksByGenre(genre), HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<Flux<Book>> getBooksByGenreAndCopiesAvailable(
            @Valid
            @RequestParam String genre,
            @RequestParam int copiesAvailable) {
        return new ResponseEntity<Flux<Book>>(bookService.getBookByGenreAndCopies(genre, copiesAvailable), HttpStatus.OK);
    }

    @PostMapping
    public Mono<Book> addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

}
