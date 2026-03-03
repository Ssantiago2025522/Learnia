package com.proyecto.Learnia;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class
	LearniaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LearniaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Api funciona");
	}
}
