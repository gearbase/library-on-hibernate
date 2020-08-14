package com.library.homework8.dao;

import com.library.homework8.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository /*extends JpaRepository<Book, Long>*/ {
    void insert(Book bookEntity);
    Book getById(Long bookId);
    Book getBookByName(String bookName, Long authorId);
    List<Book> getAllBooks();
    void deleteBook(Long bookId);
    void update(String bookName, String newBookName, Long authorId);
}
