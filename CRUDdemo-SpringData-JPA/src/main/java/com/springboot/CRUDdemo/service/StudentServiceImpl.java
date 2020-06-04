package com.springboot.CRUDdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.CRUDdemo.dao.StudentRepository;
import com.springboot.CRUDdemo.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepo;
	
	@Autowired
	public StudentServiceImpl(StudentRepository theStudentRepo) {
		studentRepo = theStudentRepo;
	}
	
	@Override
	public List<Student> findAll() {
		return studentRepo.findAll();
	}

	@Override
	public Student findById(int theId) {
		
		Optional<Student> result = studentRepo.findById(theId);	
		Student theStudent = null;
		if(result.isPresent()) {
			theStudent = result.get();
		}else {
			// can't fin the student
			throw new RuntimeException("Did not find employee id - "+ theId);
		}
		
		return theStudent;
	}

	@Override
	public void save(Student theStudent) {
		studentRepo.save(theStudent);
	}

	@Override
	public void deleteById(int theId) {
		studentRepo.deleteById(theId);
	}

}
