package com.library.homework8.dao.impl;

import com.library.homework8.dao.AuthorDAO;
import com.library.homework8.domain.Author;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
@Data
public class AuthorDaoImpl implements AuthorDAO {
    private final NamedParameterJdbcOperations jdbc;

    @Override
    public Long count() {
        Map<String, Long> map = Collections.singletonMap("count", null);
        Long result = jdbc.queryForObject("select count(*) from authors", map, Long.class);
        return result == null ? 0 : result;
    }

    @Override
    public void insert(Author author) {
        Map<String, Object> map = new HashMap<>();
        map.put("id",author.getId());
        map.put("name",author.getName());
        jdbc.update("insert into authors (id, name) values (:id, :name)",map);
    }

    @Override
    public Author getById(Long authorId) {
        Map<String, Object> map = Collections.singletonMap("authorId", authorId);
        return jdbc.queryForObject("select * from authors where id = :authorId", map, new AuthorMapper());
    }

    @Override
    public Author getAuthorByName(String authorName) {
        Map<String, Object> map = Collections.singletonMap("authorName", authorName);
        return jdbc.queryForObject("select * from authors where name = :authorName", map, new AuthorMapper());
    }

    @Override
    public List<Author> getAllAuthors() {
        return jdbc.query("select * from authors", new AuthorMapper());
    }

    @Override
    public void deleteAuthor(Long authorId) {
        Map<String, Object> map = Collections.singletonMap("authorId", authorId);
        jdbc.update("delete from books2authors where authorId = :authorId", map);
        jdbc.update("delete from AUTHORS2GENRES where authorId = :authorId", map);
        jdbc.update("delete from authors where id = :authorId", map);
    }

    @Override
    public void update(Author oldAuthor, String newAuthorName) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", oldAuthor.getId());
        map.put("name", oldAuthor.getName());
        jdbc.update("update authors set name = :newAuthorName where id = oldAuthor.getId()",map);
    }

    private static class AuthorMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            Long id = rs.getLong("id");
            String name = rs.getString("name");
            return new Author(id, name);
        }
    }
}
