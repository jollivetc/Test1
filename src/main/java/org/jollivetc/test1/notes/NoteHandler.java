package org.jollivetc.test1.notes;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class NoteHandler {

    private final NoteRepository noteRepository;

    public NoteHandler(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Mono<ServerResponse> findAll(ServerRequest serverRequest){
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(noteRepository.findAll(), Note.class);
    }
}
