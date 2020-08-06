package com.library.homework8;

import com.library.homework8.dao.*;
import com.library.homework8.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AuthorRepositoryTest {
    @Autowired
    AuthorDAO authorDAO;
    @Autowired
    BookDAO bookDAO;
    @Autowired
    AuthorGenreRepository authorGenreRepository;
    @Autowired
    GenreDAO genreDAO;
    @Autowired
    BookAuthorRepository bookAuthorRepository;

    private void insert() {
        Author author = authorDAO.findById(1L).orElseThrow();
        Genre genre = genreDAO.findById(1L).orElseThrow();
        AuthorGenreEntity authorGenreEntity = new AuthorGenreEntity();
        authorGenreEntity.setAuthor(author);
        authorGenreEntity.setGenre(genre);
        authorGenreRepository.save(authorGenreEntity);
    }

    @Test
    @Transactional
    public void test1() {
        //insert();
        //AuthorEntity authorEntity = dao.getById(1L);
        /*List<GenreEntity> genreEntities = genreDAO.findAll();
        List<BookEntity> bookEntities = bookDAO.findAll();
        List<AuthorEntity> authorEntities = authorDAO.findAll();
        List<BookAuthorEntity> authorRepositoryAll = bookAuthorRepository.findAll();
        System.out.println();


        List<AuthorGenreEntity> authorGenreEntity = authorGenreRepository.findAllByAuthor_Id(1L);
        System.out.println();*/
        Author author = authorDAO.findById(1L).orElseThrow();
        author.getAuthorGenres().forEach(authorGenreEntity -> System.out.println(authorGenreEntity.getGenre().getName()));
        System.out.println();
        //List<AuthorGenreEntity> genreEntities = authorGenreRepository.findAll();
        //AuthorEntity author = genreEntities.get(0).getAuthor();
        //System.out.println(author.getName());
        //BookEntity bookEntity = bookDAO.getById(1L);
        //List<BookAuthorEntity> bookAuthors = bookEntity.getBookAuthors();
        //List<BookGenreEntity> bookGenres = bookEntity.getBookGenres();
        //Hibernate.initialize(bookGenres);
        //Hibernate.initialize(authorEntity.getAuthorGenres());
        /*List<AuthorGenreEntity> authorGenres = authorEntity.getAuthorGenres();
        System.out.println(authorGenres);
        List<BookAuthorEntity> authorBooks = authorEntity.getAuthorBooks();*/

        //System.out.println(authorEntity.getAuthorGenres().get(0).getId());
       /* System.out.println(authorEntity.getAuthorGenres().get(0).getId());
        Long authorGenreEntity = allAuthors.get(0).getAuthorGenres().get(0).getId();
        System.out.println(authorGenreEntity);*/
        /*List<AuthorEntity> authorEntity = dao.findAll();
        System.out.println(authorEntity.get(0).getAuthorGenres().get(0).getId());*/
    }
}
