package com.revature.week6challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.week6challenge.model.Course;
import com.revature.week6challenge.model.Student;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

	public List<Course> getByStudent(Student student);

}
