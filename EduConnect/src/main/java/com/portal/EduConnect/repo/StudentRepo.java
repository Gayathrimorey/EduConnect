package com.portal.EduConnect.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.EduConnect.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

    Student findByFname(String fname);

}