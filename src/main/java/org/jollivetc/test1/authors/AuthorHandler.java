package org.jollivetc.test1.authors;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

@Component
public class AuthorHandler {

    private final AuthorRepository authorRepository;

    public AuthorHandler(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Mono<ServerResponse> findAll(ServerRequest serverRequest){
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(
                BodyInserters.fromPublisher(authorRepository.findAll().log(), Author.class));
    }

    public Mono<ServerResponse> findById(ServerRequest serverRequest){
        Mono<String> authorId= Mono.just(serverRequest.pathVariable("id"));
        authorRepository.findById(authorId, Author.class).subscribe(System.out::println);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(
                    BodyInserters.fromPublisher( authorRepository.findById(authorId, Author.class), Author.class)
        );
    }
}
