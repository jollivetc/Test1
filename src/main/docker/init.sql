CREATE SEQUENCE hibernate_sequence START 1;

CREATE TABLE Author (
                        id bigint primary key,
                        username varchar,
                        mail varchar
);

CREATE TABLE Note (
                      id bigint primary key,
                      title varchar,
                      content varchar,
                      author_id bigint,
                      FOREIGN KEY (author_id) REFERENCES Author(id)
);

INSERT INTO Author (id, username, mail) VALUES (nextval('hibernate_sequence'), 'username', 'username@email.com');
INSERT INTO Author (id, username, mail) VALUES (nextval('hibernate_sequence'), 'username2', 'username2@email.com');
INSERT INTO Author (id, username, mail) VALUES (nextval('hibernate_sequence'), 'username3', 'username3@email.com');

INSERT INTO Note(id, title, content, author_id) VALUES (nextval('hibernate_sequence'), 'Note 1', 'Ma note 1', 1);
INSERT INTO Note(id, title, content, author_id) VALUES (nextval('hibernate_sequence'), 'Note 2', 'Ma note 2', 1);
INSERT INTO Note(id, title, content, author_id) VALUES (nextval('hibernate_sequence'), 'Note 3', 'Ma note 3', 2);
