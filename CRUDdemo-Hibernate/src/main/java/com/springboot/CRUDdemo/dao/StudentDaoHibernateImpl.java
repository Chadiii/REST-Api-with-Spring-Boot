package com.springboot.CRUDdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.CRUDdemo.entity.Student;

@Repository
public class StudentDaoHibernateImpl implements StudentDAO {

	// define field for entity manager
	
	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public StudentDaoHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Student> findAll() {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Student> theQuery = 
				currentSession.createQuery("from Student", Student.class);
		
		// execute query and get result list
		List<Student> students = theQuery.getResultList();
		
		// return the result
		return students;
	}

	@Override
	public Student findById(int theId) {
		
		// get the current Hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
				
		// get the student
			Student theStudent = 
					currentSession.get(Student.class, theId);
				
		// return the result
		return theStudent;
	}

	@Override
	public void save(Student theStudent) {
		
		// get the current Hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
		
		// save student
			currentSession.saveOrUpdate(theStudent);
		
	}

	@Override
	public void deleteById(int theId) {
		
		// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
		
		// delete object with primary key
			Query theQuery =
					currentSession.createQuery("delete from Student where id=:studentId");
			
			theQuery.setParameter("studentId", theId);
			
			theQuery.executeUpdate();
	}

}
