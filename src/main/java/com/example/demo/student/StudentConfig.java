package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args -> {
			Student bryan = new Student(
					1L, // id
					"Bryan", // Name
					"bryan@gmail.com", // Email
					LocalDate.of(1994, 12, 20) // Date of birth
			);
			
			Student alex = new Student(
					"Alex", // Name
					"alex@gmail.com", // Email
					LocalDate.of(2000, 12, 20) // Date of birth
			);
			
			
			repository.saveAll(
					List.of(bryan,alex)
			);
			
		};
	}
}
