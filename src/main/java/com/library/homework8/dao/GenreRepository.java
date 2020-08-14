package com.library.homework8.dao;

import com.library.homework8.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository /*extends JpaRepository<Genre, Long>*/ {
    void insert(Genre genreEntity);
    Genre getById(Long genreId);
    Genre getGenreByName(String genreName);
    List<Genre> getAllGenres();
    void deleteGenre (Long genreId);
    void update(Genre oldGenreEntity, String newGenreName);
}
