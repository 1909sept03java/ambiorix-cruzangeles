package com.revature.week6challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.week6challenge.model.Course;
import com.revature.week6challenge.model.Student;
import com.revature.week6challenge.repository.CourseRepository;

@Service
public class CourseService {

	private CourseRepository courseRepository;

	@Autowired
	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	public List<Course> allCourses() {
		return this.courseRepository.findAll();
	}

	public Course getCourseById(int id) {
		return this.courseRepository.findById(id).orElse(null);
	}

	public void addCourse(Course course) {
		this.courseRepository.save(course);
	}

	public void deleteCourse(Course course) {
		this.courseRepository.delete(course);
	}

	public List<Course> coursesByStudent(Student student) {
		return this.courseRepository.getByStudent(student);
	}
}
