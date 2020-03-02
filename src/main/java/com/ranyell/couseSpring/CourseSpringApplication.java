package com.ranyell.couseSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ranyell.couseSpring.services.S3Service;

@SpringBootApplication
public class CourseSpringApplication implements CommandLineRunner {
		
	@Autowired
	private S3Service s3Service;

	public static void main(String[] args) {
		SpringApplication.run(CourseSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		s3Service.uploadFile("/home/ranyell/Downloads/imagem.png");
	}

}
