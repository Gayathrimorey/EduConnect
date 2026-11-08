package com.portal.EduConnect.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.EduConnect.model.Student;
import com.portal.EduConnect.service.StudentService;

@CrossOrigin(origins = "http://localhost:5173")

//http://localhost:9988/student
@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;

	@GetMapping("/wel")
	String welcome() {
		return "Welcome the most easy concept of spring boot";

	}

	@DeleteMapping("/delete/{sid}")
	String deleteStudent(@PathVariable Integer sid) {
		studentService.deleteStudentById(sid);
		return "Deleted student" + sid + "succesfully";

	}

	// http://localhost:9988/student/update/1
	@PutMapping("update/{sid}")
	Student updateStudent(@RequestBody Student s, @PathVariable Integer sid) {
		return studentService.updateStudent(s, sid);

	}

	// http://localhost:9988/student/getAllStudents
	@GetMapping("/getAllStudents")
	List<Student> getAllStudents() {
		return studentService.getAllStudents();

	}

	// http://localhost:9988/student/getStudent/2
	@GetMapping("/getStudent/{sid}")
	Student getStudent(@PathVariable Integer sid) {
		return studentService.getStudentById(sid);

	}

	// http://localhost:9988/student/getStudent/Gayathri

	@GetMapping("/getStudent/fname/{fname}")
	public Student getStudent(@PathVariable("fname") String fname) {

		return studentService.getStudentByfname(fname);
	}

	@PostMapping("/ss")
	Student createStudent(@RequestBody Student s) {
		return studentService.createStudent(s);

	}

}
