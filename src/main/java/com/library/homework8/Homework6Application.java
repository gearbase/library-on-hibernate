package com.library.homework8;

import com.library.homework8.dao.AuthorRepository;
import com.library.homework8.domain.Author;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.h2.tools.Console;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@SpringBootApplication
public class Homework6Application implements CommandLineRunner {

	@Autowired
	AuthorRepository authorRepository;

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(Homework6Application.class, args);
		//Console.main(args);
	}

	@Transactional(propagation = Propagation.NESTED)
	public void testTest(){
		Author author = authorRepository.getById(1L);
		Hibernate.initialize(author.getGenres());
		int size = author.getGenres().size();
		System.out.println(size);
	}

	//todo Модная штука, как дергать методы прям из класса приложения
	@Override
	public void run(String... args) throws Exception {
		//testTest();
	}
}
