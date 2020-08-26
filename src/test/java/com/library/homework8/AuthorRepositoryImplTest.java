package com.library.homework8;

import com.library.homework8.dao.AuthorRepository;
import com.library.homework8.domain.Author;
import com.library.homework8.domain.Genre;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AuthorRepositoryImplTest {
    @Autowired
    AuthorRepository authorRepository;

    @Test
    @Transactional
    public void test() {
        Author author = authorRepository.getById(1L);
        Author author1 = authorRepository.findById(2L).orElseThrow();
        Author author2 = authorRepository.findAuthor(1L);
        List<String> genres1 = author.getGenres().stream().map(Genre::getName).collect(Collectors.toList());
        List<String> genres2 = author2.getGenres().stream().map(Genre::getName).collect(Collectors.toList());
        System.out.println(genres1);
        System.out.println(genres2);
    }
}
