DROP TABLE IF EXISTS AUTHORS;
CREATE TABLE AUTHORS
(
    id         bigserial PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS GENRES;
CREATE TABLE GENRES
(
    id        bigserial PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS BOOKS;
create TABLE BOOKS
(
    id       bigserial PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS BOOKS_GENRES;
create TABLE BOOKS_GENRES
(
    id       bigserial PRIMARY KEY,
    book_id   BIGINT,
    genre_id  BIGINT,
    foreign key (book_id) REFERENCES BOOKS (ID),
    foreign key (genre_id) REFERENCES GENRES (ID)
);

DROP TABLE IF EXISTS BOOKS_AUTHORS;
create TABLE BOOKS_AUTHORS
(
    id       bigserial PRIMARY KEY,
    book_id   BIGINT REFERENCES BOOKS (ID),
    author_id BIGINT REFERENCES AUTHORS (ID)
);

DROP TABLE IF EXISTS AUTHORS_GENRES;
create TABLE AUTHORS_GENRES
(
    id       serial PRIMARY KEY,
    author_id  BIGINT,
    genre_id BIGINT,
    foreign key (author_id) REFERENCES AUTHORS (ID),
    foreign key (genre_id) REFERENCES GENRES (ID)
);




