package org.jollivetc.test1.authors;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AuthorRepository extends ReactiveCrudRepository<Author, Long> {
    Mono<Author> findById(String authorId, Class<Author> authorClass);
}
