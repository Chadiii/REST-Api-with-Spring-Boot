package com.springboot.CRUDdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.CRUDdemo.entity.Student;
import com.springboot.CRUDdemo.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private StudentService studentService;
	
	// quick inject of student Service (constructor injection)
	@Autowired
	public StudentRestController(StudentService theStudentService) {
		studentService = theStudentService;
	}
	
	// expose "/students" and return list of students
	@GetMapping("/students")
	public List<Student> findAll(){
		return studentService.findAll();
	}
	
	// expose "/students/{studentId}" and return student with id studentId
		@GetMapping("/students/{studentId}")
		public  Student getStudent(@PathVariable int studentId){
			
			Student theStudent = studentService.findById(studentId);
			
			if(theStudent == null) {
				throw new RuntimeException("Student id not Found - " + studentId);
			}
			return theStudent;
		}
	
	// add mapping  for POST /student - add new student
		
		@PostMapping("/students")
		public Student addStudent(@RequestBody Student theStudent) {
			
			// also just in case the pass an id in JSON ... set id to 0
			// this is to force a save of new item ... instead of update
			
			theStudent.setId(0);
			
			studentService.save(theStudent);
			
			return theStudent;
		}
		
	// add mapping for PUT /student - update existing student
		@PutMapping("/students")
		public Student updateStudent(@RequestBody Student theStudent) {
			studentService.save(theStudent);
			
			return theStudent;
		}
		
	// add mapping for PUT /student - update existing student
		@DeleteMapping("/students/{studentId}")
		public String deleteStudent(@PathVariable int studentId) {
			
			Student tempStudent = studentService.findById(studentId);
			
			// throw exception if null
			
			if(tempStudent == null) {
				throw new RuntimeException("Student id not Found - " + studentId);
			}
			
			studentService.deleteById(studentId);
			
			return "Deleted student id - " + studentId;
			
		}

}
