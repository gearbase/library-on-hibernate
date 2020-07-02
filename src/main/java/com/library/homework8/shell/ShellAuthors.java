
package com.library.homework8.shell;

import com.library.homework8.dao.AuthorDAO;
import com.library.homework8.domain.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@RequiredArgsConstructor
public class ShellAuthors {
    private final AuthorDAO authorDAO;

    
    @ShellMethod(key = {"ca", "count"}, value = "count")
    public void authorCount() {
        System.out.println(authorDAO.count());
    }

    
    @ShellMethod(key = {"ina", "insertAuthor"}, value = "insertAuthor")
    public void insertAuthor(@ShellOption(value = {"id, ID"}, defaultValue = ShellOption.NULL) Long id, String name) {
        Author author = new Author(id, name);
        authorDAO.insert(author);
        System.out.println("Вставлен автор: " + author);
    }

    
    @ShellMethod(key = {"getai", "getAuthorById"}, value = "getAuthorById")
    public Author getAuthorById(Long authorId) {
        System.out.println("Автор с ID = " + authorId + ": " + authorDAO.getById(authorId));
        return authorDAO.getById(authorId);
    }

    
    @ShellMethod(key = {"getan", "getAuthorByName"}, value = "getAuthorByName")
    public Author getAuthorByName(String authorName) {
        //System.out.println("Автор с именем = " + authorName + ": " + authorDAO.getAuthorByName(authorName));
        return authorDAO.getAuthorByName(authorName);
    }

    
    @ShellMethod(key = {"getalla", "getAllAuthors"}, value = "getAllAuthors")
    public void getAllAuthors() {
        System.out.println("Все авторы:");
        authorDAO.getAllAuthors().forEach(System.out::println);
    }

    
    @ShellMethod(key = {"dela", "deleteAuthor"}, value = "deleteAuthor")
    public void deleteAuthor(Long authorId) {
        authorDAO.deleteAuthor(authorId);
        System.out.println("Удален автор с ID = " + authorId);
    }

    
    @ShellMethod(key = {"upa", "updateAuthor"}, value = "updateAuthor")
    public void updateAuthor(Author oldAuthor, String newAuthorName) {
        authorDAO.update(oldAuthor, newAuthorName);
        System.out.println("Обновлено имя автора с ID = " + oldAuthor.getId());
        System.out.println("Имя " + oldAuthor.getName() + " обновлено на " + newAuthorName);
    }

}
