/*
package com.library.homework8.shell;

import com.library.homework8.dao.BookDAO;
import com.library.homework8.domain.BookEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
*//*
@ShellComponent
@RequiredArgsConstructor
public class ShellBooks {
    private final BookDAO bookDAO;

    @ShellMethod(key = {"bc", "booksCount"}, value = "count book")
    public void booksCount() {
        System.out.println(bookDAO.count());
    }


    @ShellMethod(key = {"inb", "insertBook"}, value = "insertBook")
    public void insertBook(@ShellOption(value = {"id, ID"}, defaultValue = ShellOption.NULL) Long id, String name) {
        BookEntity author = new BookEntity();
        author.setId(id);
        author.setName(name);
        bookDAO.insert(author);
        System.out.println("Вставлен книга: " + author);
    }


    @ShellMethod(key = {"getbi", "getBookById"}, value = "getBookById")
    public void getBookById(Long authorId) {
        System.out.println("книга с ID = " + authorId + ": " + bookDAO.getById(authorId));
    }


    @ShellMethod(key = {"getbn", "getBookByName"}, value = "getBookByName")
    public void getBookByName(String authorName, Long authorId) {
        System.out.println("книга с именем = " + authorName + ": " + bookDAO.getBookByName(authorName,authorId));
    }


    @ShellMethod(key = {"getallb", "getAllBooks"}, value = "getAllBooks")
    public void getAllBooks() {
        System.out.println("Все авторы:");
        bookDAO.getAllBooks().forEach(System.out::println);
    }


    @ShellMethod(key = {"delb", "deleteBook"}, value = "deleteBook")
    public void deleteBook(Long authorId) {
        bookDAO.deleteBook(authorId);
        System.out.println("Удален книга с ID = " + authorId);
    }


    @ShellMethod(key = {"upb", "updateBook"}, value = "updateBook")
    public void updateBook(String name, String newBookName, Long authorId) {
        bookDAO.update(name, newBookName, authorId);
        System.out.println("Имя книги" + name + " обновлено на " + newBookName);
    }

}*/
