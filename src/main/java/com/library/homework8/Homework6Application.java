package com.library.homework8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.h2.tools.Console;
import java.sql.SQLException;

@SpringBootApplication
public class Homework6Application {
	public static void main(String[] args) throws SQLException {
		SpringApplication.run(Homework6Application.class, args);
		Console.main(args);
	}

}
