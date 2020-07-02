package com.library.homework8.dao.impl;

import com.library.homework8.dao.BookDAO;
import com.library.homework8.domain.Book;
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
public class BookDaoImpl implements BookDAO {
    private final NamedParameterJdbcOperations jdbc;

    @Override
    public Long count() {
        Map<String, Long> map = Collections.singletonMap("count", null);
        Long result = jdbc.queryForObject("select count(*) from books", map, Long.class);
        return result == null ? 0 : result;
    }

    @Override
    public void insert(Book book) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", book.getId());
        map.put("name", book.getName());
        jdbc.update("insert into books (id, name) values (:id, :name)", map);
    }

    @Override
    public Book getById(Long bookId) {
        Map<String, Object> map = Collections.singletonMap("bookId", bookId);
        return jdbc.queryForObject("select * from books where id = :bookId", map, new BookMapper());
    }

    @Override
    public Book getBookByName(String bookName, Long authorId) {
        Map<String, Object> map = new HashMap<>();
        map.put("authorId", authorId);
        map.put("bookName", bookName);
        return jdbc.queryForObject("select * from books b " +
                "join books2authors b2a on b.id = b2a.bookId " +
                "join authors a on a.id = b2a.authorId " +
                "where a.id = :authorId " +
                "and b.name = :bookName", map, new BookMapper());

    }

    @Override
    public List<Book> getAllBooks() {
        return jdbc.query("select * from books", new BookMapper());
    }

    @Override
    public void deleteBook(Long bookId) {
        Map<String, Object> map = Collections.singletonMap("bookId", bookId);
        jdbc.update("delete from books2authors where bookId = :bookId", map);
        jdbc.update("delete from BOOKS2GENRES where bookId = :bookId", map);
        jdbc.update("delete from books where id = :bookId", map);
    }

    @Override
    public void update(String bookName, String newBookName, Long authorId) {
        Long bookId = getBookByName(bookName, authorId).getId();
        Map<String, Object> map = new HashMap<>();
        map.put("id", bookId);
        map.put("name", newBookName);
        jdbc.update("update books set name = :name where id = :id", map);
    }

    private static class BookMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Long id = rs.getLong("id");
            String name = rs.getString("name");
            return new Book(id, name);
        }
    }
}
