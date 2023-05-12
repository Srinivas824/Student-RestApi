package com.example.demo.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.example.demo.student.Student;
@Repository
public class StudentDao {
	
	HashMap<Integer, Student> studentdb = new HashMap<>();

	
	public String addStudentToDb(Student student) {
		int key = student.getId();
		studentdb.put(key, student);
		
		return "student add Sucessfully";
	}
	public Student getStudentFromDb(int id) {
		if(studentdb.containsKey(id)) {
			return studentdb.get(id);
		}
	
	return null;
		
	}
	public Student getStudentNameFromDb(String searchname) {
		for(Student s : studentdb.values()) {
			if(s.getName().equalsIgnoreCase(searchname)) {
				return s;
			}
		}
		return null;

	}
	public Student updateStudentFRomDb(Student student) {
		int key = student.getId();
		Student s= studentdb.put(key, student);
		return s;
		
	}
	public String deleteStudentFomDb(Integer id) {
		studentdb.remove(id);
		return "student delete sucessfully";
	}
}
