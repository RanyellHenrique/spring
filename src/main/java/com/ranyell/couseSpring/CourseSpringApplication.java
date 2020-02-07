package com.ranyell.couseSpring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ranyell.couseSpring.domain.Categoria;
import com.ranyell.couseSpring.repositories.CategoriaRepository;

@SpringBootApplication
public class CourseSpringApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CourseSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria c1 = new Categoria(null, "Informática");
		Categoria c2 = new Categoria(null, "Escritório");
		
		categoriaRepository.saveAll(Arrays.asList(c1, c2));
		
		
	}

}
