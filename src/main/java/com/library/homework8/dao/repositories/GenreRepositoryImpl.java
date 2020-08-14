package com.library.homework8.dao.repositories;

import com.library.homework8.dao.GenreRepository;
import com.library.homework8.domain.Genre;

import java.util.List;

public class GenreRepositoryImpl implements GenreRepository {
    @Override
    public void insert(Genre genreEntity) {

    }

    @Override
    public Genre getById(Long genreId) {
        return null;
    }

    @Override
    public Genre getGenreByName(String genreName) {
        return null;
    }

    @Override
    public List<Genre> getAllGenres() {
        return null;
    }

    @Override
    public void deleteGenre(Long genreId) {

    }

    @Override
    public void update(Genre oldGenreEntity, String newGenreName) {

    }
}
