package com.library.homework8.dao;

import com.library.homework8.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>, CustomAuthorRepository {

    @Query("select a from Author a where a.id = :id")
    Author findAuthor(@Param("id") Long id);

    /*void insert(Author authorEntity);

    Author getById(Long authorId);

    Author getAuthorByName(String authorName);

    List<Author> getAllAuthors();

    int deleteAuthor(Long authorId);

    void update(String authorName, String newAuthorName);*/
}
