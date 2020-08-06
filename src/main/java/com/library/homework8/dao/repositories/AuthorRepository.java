/*
package com.library.homework8.dao.repositories;

import com.library.homework8.dao.AuthorDAO;
import com.library.homework8.domain.AuthorEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AuthorRepository implements AuthorDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Long count() {
        TypedQuery<Long> query =  em.createQuery("select COUNT (a) from AuthorEntity a", Long.class);
        return query.getSingleResult();
    }

    @Override
    public void insert(AuthorEntity authorEntity) {
        em.persist(authorEntity);
    }

    @Override
    public AuthorEntity getById(Long authorId) {
        TypedQuery<AuthorEntity> query = em.createQuery("select a from AuthorEntity a where a.id = :id ", AuthorEntity.class);
        query.setParameter("id", authorId);
        return query.getSingleResult();
    }

    @Override
    public AuthorEntity getAuthorByName(String authorName) {
        TypedQuery<AuthorEntity> query = em.createQuery("select a from AuthorEntity a where a.id = :name ", AuthorEntity.class);
        query.setParameter("name", authorName);
        return query.getSingleResult();
    }

    @Override
    public List<AuthorEntity> getAllAuthors() {
        return em.createQuery("select a from AuthorEntity a", AuthorEntity.class).getResultList();
    }

    @Override
    public int deleteAuthor(Long authorId) {
        Query query = em.createQuery("delete from AuthorEntity a where a.id = :id");
        query.setParameter("id", authorId);
        return query.executeUpdate();
    }

    @Override
    public void update(String authorName, String newAuthorName) {
        AuthorEntity authorEntity = getAuthorByName(authorName);
        authorEntity.setName(newAuthorName);
        em.persist(authorEntity);
    }

}
*/
