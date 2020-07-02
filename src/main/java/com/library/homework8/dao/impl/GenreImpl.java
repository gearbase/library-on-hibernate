package com.library.homework8.dao.impl;

import com.library.homework8.dao.GenreDAO;
import com.library.homework8.domain.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class GenreImpl implements GenreDAO {
    private final NamedParameterJdbcOperations jdbc;

    @Override
    public Long count() {
        Map<String, Long> map = Collections.singletonMap("count", null);
        Long result = jdbc.queryForObject("select count(*) from genres", map, Long.class);
        return result == null ? 0 : result;
    }

    @Override
    public void insert(Genre genre) {
        Map<String, Object> map = new HashMap<>();
        map.put("id",genre.getId());
        map.put("name",genre.getName());
        jdbc.update("insert into genres (id, name) values (:id, :name)",map);
    }

    @Override
    public Genre getById(Long genreId) {
        Map<String, Object> map = Collections.singletonMap("authorId", genreId);
        return jdbc.queryForObject("select * from genres where id = :genreId", map, new GenreMapper());

    }

    @Override
    public Genre getGenreByName(String genreName) {
        Map<String, Object> map = new HashMap<>();
        map.put("genreName", genreName);
        return jdbc.queryForObject("select * from genres where name = :genreName", map, new GenreMapper());
    }

    @Override
    public List<Genre> getAllGenres() {
            return jdbc.query("select * from books", new GenreMapper());
        }

    @Override
    public void deleteGenre(Long genreId) {
        Map<String, Object> map = Collections.singletonMap("genreId", genreId);
        jdbc.update("delete from genres where id = :genreId", map);
    }

    @Override
    public void update(Genre oldGenre, String newGenreName) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", oldGenre.getId());
        map.put("name", oldGenre.getName());
        jdbc.update("update genres set name = :newGenreName where id = oldGenre.getId()",map);
    }

    private static class GenreMapper implements RowMapper<Genre> {

        @Override
        public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
            Long id = rs.getLong("id");
            String name = rs.getString("name");
            return new Genre(id, name);
        }
    }
}
