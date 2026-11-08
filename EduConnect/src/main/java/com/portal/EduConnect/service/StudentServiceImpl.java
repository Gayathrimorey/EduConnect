package com.portal.EduConnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.EduConnect.model.Student;
import com.portal.EduConnect.repo.StudentRepo;

//how to do --->Business Logics
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepo studentRepo;

	@Override
	public Student createStudent(Student s) {
		return studentRepo.save(s);
	}

	@Override
	public List<Student> getAllStudents() {

		return studentRepo.findAll();
	}

	@Override
	public Student getStudentById(Integer sid) {

		return studentRepo.findById(sid).orElseThrow();
	}

	@Override
	public Student updateStudent(Student s, Integer id) {
		Student studentInfofromDb = getStudentById(id);
		studentInfofromDb.setAge(s.getAge());
		studentInfofromDb.setFname(s.getFname());
		studentInfofromDb.setLname(s.getLname());
		studentInfofromDb.setTotal_marks(s.getTotal_marks());

		return studentRepo.save(studentInfofromDb);
	}
	
	

	@Override
	public void deleteStudentById(Integer id) {
		studentRepo.deleteById(id);

	}

	@Override
	public Student getStudentByfname(String name) {
		return studentRepo.findByFname(name);
	}

}
