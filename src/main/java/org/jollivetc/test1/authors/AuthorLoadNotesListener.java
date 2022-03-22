package org.jollivetc.test1.authors;

import org.jollivetc.test1.notes.NoteRepository;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.r2dbc.mapping.event.AfterConvertCallback;
import org.springframework.data.relational.core.sql.SqlIdentifier;
import org.springframework.stereotype.Component;

@Component
public class AuthorLoadNotesListener implements AfterConvertCallback<Author> {

    @Autowired @Lazy
    private NoteRepository noteRepository;
    @Override
    public Publisher<Author> onAfterConvert(Author entity, SqlIdentifier table) {
        return noteRepository.findNotesByAuthorId(entity.getId())
                    .map(note -> {
                        if (note != null) entity.getAuthorNotes().add(note);
                        return entity;
                    })
                    .takeLast(1)		// shrink JOIN duplicates
                    .single(entity);	// avoid no note authors skip
    }
}
