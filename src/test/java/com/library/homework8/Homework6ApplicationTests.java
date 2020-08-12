package com.library.homework8;

import com.library.homework8.dao.AuthorRepository;
import com.library.homework8.dao.AuthorService;
import com.library.homework8.domain.Author;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class Homework6ApplicationTests {
	@Autowired
	AuthorService authorService;
	@Autowired
	AuthorRepository authorRepository;
	@Test
	void contextLoads() {
	}


	@Test
	@Transactional
	public void testAuthor(){
		Author author = authorRepository.findById(1L).orElseThrow();
		Hibernate.initialize(author.getGenres());
		System.out.println(author.getGenres().size());

		testTest();
	}

	public void testTest(){
		Author author = authorService.testTest();
		//нет эксепшена, потому что getGenres() инициализировано ранее в сервисе AuthorService
		int size = author.getGenres().size();
		System.out.println(size);
	}
}
