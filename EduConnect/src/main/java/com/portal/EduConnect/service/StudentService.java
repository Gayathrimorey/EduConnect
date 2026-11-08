package com.portal.EduConnect.service;

import java.util.List;

import com.portal.EduConnect.model.Student;
//interface what to do

public interface StudentService {
	public abstract Student createStudent(Student s);

	List<Student> getAllStudents();

	Student getStudentById(Integer sid);

	Student updateStudent(Student student, Integer id);

	void deleteStudentById(Integer id);

	Student getStudentByfname(String name);

}
