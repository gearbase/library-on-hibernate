package com.library.homework8.domain;

public class References {
    private final int bookId;
    private final int authorId;
    private final int genreId;

    public References(int bookId, int authorId, int genreId) {
        this.bookId = bookId;
        this.authorId = authorId;
        this.genreId = genreId;
    }

    public int getBookId() {
        return bookId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public int getGenreId() {
        return genreId;
    }
}
