package com.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.dto.ContactDto;
import com.springrest.entities.ContactModel;
import com.springrest.entities.Student;
import com.springrest.execption.ExceptionMaster;
import com.springrest.repository.ContactRepository;
import com.springrest.service.StudentService;

@RestController
@RequestMapping
public class MyController {
	
	
	private final StudentService studentService;
		
	private final ContactRepository contactRepo;
	
	@Autowired
	public MyController(StudentService studentService, ContactRepository contactRepo) {
		super();
		this.studentService = studentService;
		this.contactRepo = contactRepo;
	}
	
	@GetMapping("/getinfo")
	
	public String getInfo() {
		
		return "my name is chingchong";
		
		
	}
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		
		List<Student> students = studentService.getAllstudents();		
		return students;
		
	}
	
	@GetMapping("/students/{id}")
	public Student getOneStudent(@PathVariable("id") int id) {
		
		System.out.println(studentService.getOneStudent(id));
		return null; 
		
	}
	@GetMapping("/contacts")
	public List<ContactModel> getAllContactDetails(){
		List<ContactModel> models = contactRepo.findAll();
		
		return models;
	}
	@GetMapping("/contact/{id}")
	public ResponseEntity<ContactModel> getById(@PathVariable String id) {
		
		ContactModel mod = contactRepo.findById(Integer.parseInt(id)).get();
	
		if(mod!=null) {
			return new ResponseEntity<ContactModel>(mod,HttpStatus.ACCEPTED);
		}else {
			return  ResponseEntity.badRequest().build();
		}
		
	}
	@PostMapping("/create")
	public ResponseEntity<?> createRecord(@RequestBody ContactDto contact) {
		
    try {
		ContactModel model = new ContactModel();
		
		model.setFirst_name(contact.getFirst_name());
		model.setLast_name(contact.getLast_name());
		model.setEmail(contact.getEmail());
		model.setMobile(contact.getMobile());
		
		contactRepo.save(model);
		
		return ResponseEntity.ok(model);
        }
		catch(Exception e){
			return ResponseEntity.internalServerError().body("Record is Exist");
		}
    
		
	}	
	

}
