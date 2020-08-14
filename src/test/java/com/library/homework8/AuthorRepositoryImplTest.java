package com.library.homework8;

import com.library.homework8.dao.AuthorRepository;
import com.library.homework8.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AuthorRepositoryImplTest {
    @Autowired
    AuthorRepository authorRepository;

    @Test
    public void test() {
        Author author = authorRepository.getById(1L);
        Author author1 = authorRepository.findById(2L).orElseThrow();
        Author author2 = authorRepository.findAuthor(1L);
        System.out.println(author.getName());
    }
}
