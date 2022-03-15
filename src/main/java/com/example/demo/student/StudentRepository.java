package com.example.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// This interface accesses the database, specifically when working with JPA
@Repository // This interface is responsible for the data access
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	// SELECT * FROM student WHERE email = ?
	@Query("SELECT s FROM Student s WHERE s.email = ?1")
	Optional<Student> findStudentByEmail(String email);
}
