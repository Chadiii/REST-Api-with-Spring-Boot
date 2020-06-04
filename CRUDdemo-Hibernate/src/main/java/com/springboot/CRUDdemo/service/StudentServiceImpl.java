package com.springboot.CRUDdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.CRUDdemo.dao.StudentDAO;
import com.springboot.CRUDdemo.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentDAO studentDAO;
	
	@Autowired
	public StudentServiceImpl(StudentDAO theStudentDAO) {
		studentDAO = theStudentDAO;
	}
	
	@Override
	@Transactional
	public List<Student> findAll() {
		return studentDAO.findAll();
	}

	@Override
	@Transactional
	public Student findById(int theId) {
		return studentDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Student theStudent) {
		studentDAO.save(theStudent);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		studentDAO.deleteById(theId);
	}

}
