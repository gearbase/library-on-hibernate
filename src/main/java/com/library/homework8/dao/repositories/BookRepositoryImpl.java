
package com.library.homework8.dao.repositories;

import com.library.homework8.dao.BookRepository;
import com.library.homework8.domain.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext
    private EntityManager em;
    

    @Override
    public void insert(Book Book) {
        em.persist(Book);
    }

    @Override
    public Book getById(Long bookId) {
        TypedQuery<Book> query = em.createQuery("select a from Book a where a.id = :id ", Book.class);
        query.setParameter("id", bookId);
        return query.getSingleResult();
    }

    @Override
    public Book getBookByName(String bookName, Long authorId) {
        TypedQuery<Book> query = em.createQuery("select b from Book b join b.bookAuthors ba join ba.author a where a.id = :id", Book.class);
        //query.setParameter("name", bookName);
        query.setParameter("id", authorId);
        return query.getSingleResult();    }

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Override
    public void deleteBook(Long bookId) {

    }

    @Override
    public void update(String bookName, String newBookName, Long authorId) {

    }
}
