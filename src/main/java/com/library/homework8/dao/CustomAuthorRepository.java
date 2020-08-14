package com.library.homework8.dao;

import com.library.homework8.domain.Author;

public interface CustomAuthorRepository {
    Author getById(Long authorId);
}
