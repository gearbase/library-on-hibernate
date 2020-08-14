package com.library.homework8.dao.repositories;

import com.library.homework8.dao.AuthorRepository;
import com.library.homework8.dao.CustomAuthorRepository;
import com.library.homework8.domain.Author;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AuthorRepositoryImpl implements CustomAuthorRepository {
    @PersistenceContext
    private EntityManager em;

    //В adp аналогичный класс просто сделан отдельным классом MetaReportRepository
    //не абстрактным и т.д., на него повешана аннотация репозиторий и этот класс не
    //имплементирует ни какие интерфейсы. Подумать, как можно сделать.

    //@Override
    public void insert(Author Author) {
        em.persist(Author);
    }

   @Override
    public Author getById(Long authorId) {
        TypedQuery<Author> query = em.createQuery("select a from Author a where a.id = :id ", Author.class);
        query.setParameter("id", authorId);
        return query.getSingleResult();
    }

   // @Override
    public Author getAuthorByName(String authorName) {
        TypedQuery<Author> query = em.createQuery("select a from Author a where a.id = :name ", Author.class);
        query.setParameter("name", authorName);
        return query.getSingleResult();
    }

    //@Override
    public List<Author> getAllAuthors() {
        return em.createQuery("select a from Author a", Author.class).getResultList();
    }

    //@Override
    public int deleteAuthor(Long authorId) {
        Query query = em.createQuery("delete from Author a where a.id = :id");
        query.setParameter("id", authorId);
        return query.executeUpdate();
    }

   // @Override
    public void update(String authorName, String newAuthorName) {
        Author Author = getAuthorByName(authorName);
        Author.setName(newAuthorName);
        em.persist(Author);
    }

}
