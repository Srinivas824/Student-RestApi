package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDao;
import com.example.demo.student.Student;

@Service
public class StudentService {
	
	@Autowired
	StudentDao studentdao;
	
	public String addStudent(Student student) {
		String result =studentdao.addStudentToDb(student);
		return result;
	}
	
	public Student getStudentById(Integer id) {
		Student student = studentdao.getStudentFromDb(id);
		return student;
	}
	
	public Student getStudentByName(String name) {
	Student s = studentdao.getStudentNameFromDb(name);
	return s;
	}
	
	public Student upadteStudent(Student student) {
		return studentdao.updateStudentFRomDb(student);
	}
	
	public String deleteStudent(Integer id) {
		return studentdao.deleteStudentFomDb(id);
	}

}
