package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController // A specialized version of the @Controller. It includes the @Controller and @ResponseBody annotations, and as a result, simplifies the controller implementation. RestController is used for making restful web services. This annotation is used at the class level and allows the class to handle the requests made by the client. This annotation makes this class serve rest endpoints.

@RequestMapping(path="api/v1/student") // Creates a path for this class instead of just localhost, the new url will be http://localhost:8080/api/v1/student
public class StudentController {

	// Creating reference to StudentService
	private final StudentService studentService;
	
	// Passing the reference into the constructor
	@Autowired // For dependency injection
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping // RestFul endpoint
	public List<Student> getStudents() {
		return studentService.getStudents();
	}
	
	@PostMapping 
	public void registerNewStudent(@RequestBody Student student) {
		studentService.addNewStudent(student);
	}
	
	@DeleteMapping(path="{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long studentId) {
		studentService.deleteStudent(studentId);
	}
	
	@PutMapping(path="{studentId}")
	public void updateStudent(
			@PathVariable("studentId") Long studentId,
			@RequestParam(required=false) String name,
			@RequestParam(required=false) String email) {
		studentService.updateStudent(studentId, name, email);
	}
}
