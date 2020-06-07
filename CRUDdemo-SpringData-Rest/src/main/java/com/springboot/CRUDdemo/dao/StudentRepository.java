package com.springboot.CRUDdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.CRUDdemo.entity.Student;

//@RepositoryRestResource(path="members")
public interface StudentRepository extends JpaRepository<Student, Integer> {
	//no need to add anycode
}
