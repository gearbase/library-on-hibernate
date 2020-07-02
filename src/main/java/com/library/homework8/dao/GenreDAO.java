package com.library.homework8.dao;

import com.library.homework8.domain.Genre;

import java.util.List;

public interface GenreDAO {
    Long count();
    void insert(Genre genre);
    Genre getById(Long genreId);
    Genre getGenreByName(String genreName);
    List<Genre> getAllGenres();
    void deleteGenre (Long genreId);
    void update(Genre oldGenre, String newGenreName);
}
