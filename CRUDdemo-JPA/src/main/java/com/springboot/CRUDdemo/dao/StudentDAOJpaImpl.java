package com.springboot.CRUDdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.CRUDdemo.entity.Student;

@Repository
public class StudentDAOJpaImpl implements StudentDAO {

	private EntityManager entityManager;
	
	@Autowired
	public StudentDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Student> findAll() {
		
		// create Query
		Query theQuery =
				entityManager.createQuery("from Student");
		
		// execute the query and get result
		
		List<Student> students = theQuery.getResultList();
		
		// return results
		return students;
	}

	@Override
	public Student findById(int theId) {
		
		// get student
		Student student = entityManager.find(Student.class, theId);
		
		// return student
		return student;
	}

	@Override
	public void save(Student theStudent) {
		
		// save or update the student
		Student dbStudent = entityManager.merge(theStudent);
		
		// update with id from db ... so we can get generated id for save/insert
		theStudent.setId(dbStudent.getId());

	}

	@Override
	public void deleteById(int theId) {
		
		Query theQuery = entityManager.createQuery(
				"delete from Student where id=:studentId");
		
		theQuery.setParameter("studentId", theId);
		
		theQuery.executeUpdate();

	}

}
