package com.springrest.service;

import java.util.List;

import com.springrest.entities.Student;

public interface StudentService {

	public List<Student> getAllstudents();

	public Student getOneStudent(int id);

	

	

}
