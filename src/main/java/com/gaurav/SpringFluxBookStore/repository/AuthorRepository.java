package com.gaurav.SpringFluxBookStore.repository;

import com.gaurav.SpringFluxBookStore.model.Author;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public interface AuthorRepository extends ReactiveMongoRepository<Author, Integer> {

    Flux<Author> findByNameRegex(String nameRegex);

    Mono<Author> findByName(String name);
}
