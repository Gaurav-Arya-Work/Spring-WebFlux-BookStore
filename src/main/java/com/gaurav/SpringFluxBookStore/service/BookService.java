package com.gaurav.SpringFluxBookStore.service;

import com.gaurav.SpringFluxBookStore.model.Book;
import com.gaurav.SpringFluxBookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Flux<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Flux<Book> getBooksByGenre(String genre) {
        return bookRepository.findBooksByGenre(genre);
    }

    public Mono<Book> addBook(Book book) {
        return bookRepository.save(book);
    }

    public Flux<Book> getBookByGenreAndCopies(String genre, int copiesAvailable) {
        return bookRepository.findBooksByGenreAndCopiesAvailable(genre, copiesAvailable);
    }

    public Flux<Book> getBooks(int id) {
        return bookRepository.findByAuthorId(id);
    }

    public Flux<Book> getBookByAuthorId(int aid) {
        return bookRepository.findByAuthorId(aid);
    }
}
