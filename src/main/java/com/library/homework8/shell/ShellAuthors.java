/*

package com.library.homework8.shell;

import com.library.homework8.dao.AuthorDAO;
import com.library.homework8.domain.AuthorEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;
*//*
//@ShellComponent
@RequiredArgsConstructor
public class ShellAuthors {
    private final AuthorDAO authorDAO;

    
    @ShellMethod(key = {"ca", "count"}, value = "count")
    public void authorCount() {
        System.out.println(authorDAO.count());
    }

    
    @ShellMethod(key = {"ina", "insertAuthor"}, value = "insertAuthor")
    public void insertAuthor(@ShellOption(value = {"id, ID"}, defaultValue = ShellOption.NULL) Long id, String name) {
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setId(id);
        authorEntity.setName(name);
        authorDAO.insert(authorEntity);
        System.out.println("Вставлен автор: " + authorEntity);
    }

    
    @ShellMethod(key = {"getai", "getAuthorById"}, value = "getAuthorById")
    public AuthorEntity getAuthorById(Long authorId) {
        System.out.println("Автор с ID = " + authorId + ": " + authorDAO.getById(authorId));
        return authorDAO.getById(authorId);
    }

    
    @ShellMethod(key = {"getan", "getAuthorByName"}, value = "getAuthorByName")
    public AuthorEntity getAuthorByName(String authorName) {
        //System.out.println("Автор с именем = " + authorName + ": " + authorDAO.getAuthorByName(authorName));
        return authorDAO.getAuthorByName(authorName);
    }

    
    @ShellMethod(key = {"getalla", "getAllAuthors"}, value = "getAllAuthors")
    public void getAllAuthors() {
        System.out.println("Все авторы:");
        List<AuthorEntity> allAuthors = authorDAO.getAllAuthors();
        System.out.println(allAuthors.get(0).getAuthorGenres().get(0).getId());

        //authorDAO.getAllAuthors().forEach(authorEntity -> authorEntity.getAuthorGenres().forEach(genre -> System.out.println(genre.getId())));
    }

    
    @ShellMethod(key = {"dela", "deleteAuthor"}, value = "deleteAuthor")
    public void deleteAuthor(Long authorId) {
        authorDAO.deleteAuthor(authorId);
        System.out.println("Удален автор с ID = " + authorId);
    }

    
    @ShellMethod(key = {"upa", "updateAuthor"}, value = "updateAuthor")
    public void updateAuthor(String oldAuthorEntity, String newAuthorName) {
        authorDAO.update(oldAuthorEntity, newAuthorName);
        System.out.println("Обновлено имя автора с ID = " + oldAuthorEntity);
        System.out.println("Имя " + oldAuthorEntity + " обновлено на " + newAuthorName);
    }

}
*/
