package com.revature.week6challenge.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.week6challenge.model.Student;
import com.revature.week6challenge.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	private StudentService studentService;

	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getAll() {
		return new ResponseEntity<>(this.studentService.allStudents(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Student> getStudentById(@PathVariable int id) {
		Student student = this.studentService.getStudentById(id);
		if (student == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(student, HttpStatus.OK);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> addStudent(@Valid @RequestBody Student student) {
		ResponseEntity<String> response = null;
		try {
			this.studentService.addStudent(student);
			response = new ResponseEntity<>("STUDENT CREATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<>("FAILED TO CREATE STUDENT", HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> deleteStudent(@Valid @RequestBody Student student) {
		ResponseEntity<String> response = null;
		try {
			this.studentService.deleteStudent(student);
			response = new ResponseEntity<>("STUDENT DELETED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<>("FAILED TO DELETE STUDENT", HttpStatus.BAD_REQUEST);
		}
		return response;
	}

}
