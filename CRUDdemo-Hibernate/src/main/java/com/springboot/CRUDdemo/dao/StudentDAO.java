package com.springboot.CRUDdemo.dao;

import java.util.List;

import com.springboot.CRUDdemo.entity.Student;

public interface StudentDAO {

	public List<Student> findAll();
	
	public Student findById(int theId);
	
	public void save(Student theStudent);
	
	public void deleteById(int theId);
	
}
