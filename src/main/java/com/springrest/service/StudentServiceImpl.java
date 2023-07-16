package com.springrest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springrest.entities.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	private List<Student> student;

	@Override
	public List<Student> getAllstudents() {
		student= new ArrayList<Student>();
		student.add(new Student(101,"vibek",606));
		student.add(new Student(102,"jhumi",502));
		student.add(new Student(103,"niraj",443));
		student.add(new Student(104,"ritu",656));
		student.add(new Student(105,"viky",566));
		
		return student;
	}

	@Override
	public Student getOneStudent(int id) {
	    List<Student> student1 = student.stream().filter(x->x.getId()==id).collect(Collectors.toList());
		return (Student) student1;
	}
}


