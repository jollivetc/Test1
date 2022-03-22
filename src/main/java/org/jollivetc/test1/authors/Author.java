package org.jollivetc.test1.authors;

import org.jollivetc.test1.notes.Note;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;

@Table
public class Author {
    @Id
    private Long id;
    private String username;
    private String mail;
    @Transient
    private Set<Note> authorNotes = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Set<Note> getAuthorNotes() {
        return authorNotes;
    }

    public void setAuthorNotes(Set<Note> authorNotes) {
        this.authorNotes = authorNotes;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", mail='" + mail + '\'' +
                ", authorNotes=" + authorNotes +
                '}';
    }
}
