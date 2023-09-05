package com.gaurav.SpringFluxBookStore.repository;

import com.gaurav.SpringFluxBookStore.model.Book;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface BookRepository extends ReactiveMongoRepository<Book, Integer> {

    Flux<Book> findBooksByGenre(String genre);

    @Query(value = "{'genre': ?0, 'copiesAvailable': {$gt: ?1}}")
    Flux<Book> findBooksByGenreAndCopiesAvailable(String genre, int copiesAvailable);

    Flux<Book> findByAuthorId(int id);
}
