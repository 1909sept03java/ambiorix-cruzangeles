package com.revature.week6challenge.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.week6challenge.model.Course;
import com.revature.week6challenge.model.Student;
import com.revature.week6challenge.service.CourseService;

@RestController
@RequestMapping(value = "/course")
public class CourseController {

	private CourseService courseService;

	@Autowired
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Course>> getAll() {
		return new ResponseEntity<>(this.courseService.allCourses(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Course> getCourseById(@PathVariable int id) {
		Course course = this.courseService.getCourseById(id);
		if (course == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(course, HttpStatus.OK);
		}
	}

	/*
	 * 
	 * @GetMapping(value = "/student/{whatever}") public
	 * ResponseEntity<List<Course>> getCourseByStudent(@PathVariable int whatever) {
	 * return new ResponseEntity<>( this.courseService.coursesByStudent(new
	 * Student(whatever, "", new ArrayList<Course>())), HttpStatus.OK); }
	 */

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> addCourse(@Valid @RequestBody Course course) {
		ResponseEntity<String> response = null;
		try {
			this.courseService.addCourse(course);
			response = new ResponseEntity<>("COURSE CREATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<>("FAILED TO CREATE COURSE", HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> deleteCourse(@Valid @RequestBody Course course) {
		ResponseEntity<String> response = null;
		try {
			this.courseService.deleteCourse(course);
			response = new ResponseEntity<>("COURSE DELETED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<>("FAILED TO DELETE COURSE", HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
}
