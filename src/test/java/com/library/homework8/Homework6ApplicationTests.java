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
	//@Transactional
	public void testAuthor(){
		// todo Если вызывающий метод не обернут в @Transactional, то даже, если все обращения к базе происходят
		//  в вызываемом методе, который обернут в @Transactional, все равно будет LAZY Exception
		//  Текущий метод не обернут, в AuthorService необернутый метод вызывает обернутый, получаем исключение
		//  Если текущий метод обернуть, либо обернуть метод testTest() в AuthorService (а текущий не оборачивать),
		//  то все будет работать. Причем, если обернуть testTest() в AuthorService, то initializeAuthor() можно не оборачивать
		authorService.testTest();
		testTest();
	}

	public void testTest(){
		Author author = authorService.testTest();
		//нет эксепшена, потому что getGenres() инициализировано ранее в сервисе AuthorService
		int size = author.getGenres().size();
		System.out.println(size);
	}
}
