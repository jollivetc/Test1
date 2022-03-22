package org.jollivetc.test1.notes;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface NoteRepository extends ReactiveCrudRepository<Note, Long> {

    @Query("select * from Note where author_id= :id")
    Flux<Note> findNotesByAuthorId(Long id);
}
