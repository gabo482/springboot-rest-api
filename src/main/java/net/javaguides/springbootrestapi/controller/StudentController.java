package net.javaguides.springbootrestapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.javaguides.springbootrestapi.beans.Student;

@RestController
public class StudentController {
	
	
	List <Student> students = new ArrayList <>();
	/*
	*	Get student:
	*	curl http://localhost:8080/student
	*/	
	@GetMapping("student")
	public Student getStudent() {
		Student student = new Student(1,"juan","perez");
		return student;
	}
	/*
	*	Get all students:
	*	curl http://localhost:8080/students
	*/	
	@GetMapping("students")
	public List <Student> getStudents() {
		students = new ArrayList <>();
			students.add(new Student(1,"hugo","ramirez"));
			students.add(new Student(2,"paco","gomez"));
			students.add(new Student(3,"luis","sanchez"));
			students.add(new Student(4,"donald","perez"));
			students.add(new Student(5,"mickey","ruiz"));		
		return students;
	}
	
	/*
	*	Get all students:
	*	curl http://localhost:8080/students/1
	*/	
	@GetMapping("students/{id}")
	public Student getStudentById ( @PathVariable("id") int id ) {				
		// Student student = students.get(id);
		Student student =new Student();
		
		for (Student obj: students) {
			if(Objects.equals(id, obj.getId())) {
				student = obj;
			}				
		}		
		return 	student; 				
	} 	
}