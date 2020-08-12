package com.library.homework8.dao;

import com.library.homework8.domain.Author;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService (AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    public Author testTest(){
        Author author = authorRepository.findById(1L).orElseThrow();
        initializeAuthor(author);
        //Hibernate.initialize(author.getGenres());
        return author;
    }

    private void initializeAuthor(Author author) {
        Hibernate.initialize(author.getGenres());
    }

}
