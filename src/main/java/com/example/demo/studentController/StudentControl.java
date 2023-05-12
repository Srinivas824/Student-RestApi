package com.example.demo.studentController;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.StudentService;
import com.example.demo.student.Student;

@RestController
public class StudentControl {
	
	@Autowired
	StudentService studentService;
	
	
	@PostMapping("/add_student")
	public ResponseEntity<String> addStudent(@RequestBody() Student student){
		String response = studentService.addStudent(student);
		
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	@GetMapping("/student_get_by_id")
	public ResponseEntity<Student> getStudentById(@RequestParam("id")Integer id) {
		
		Student studentResult = studentService.getStudentById(id);
		if(studentResult==null) {
			return new ResponseEntity<Student>(studentResult, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(studentResult, HttpStatus.OK);
	}
	
	@GetMapping("/get_by_path/{id}")
	public ResponseEntity<Student> getStudentByPath(@PathVariable("id")Integer id){
		
		Student studentResult = studentService.getStudentById(id);
		if(studentResult==null) {
			return new ResponseEntity<Student>(studentResult, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(studentResult, HttpStatus.OK);
	}
	
	@GetMapping("/get_student_by_name")
	public ResponseEntity<Student> getStudentByName(@RequestParam("name")String searchname) {
		Student studentResult = studentService.getStudentByName(searchname);
		if(studentResult==null) {
			return new ResponseEntity<Student>(studentResult, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(studentResult, HttpStatus.OK);

	}
	@DeleteMapping("/delete_by_id")
	public ResponseEntity<String> deleteById(@RequestParam("id")Integer id) {
		String studentResult = studentService.deleteStudent(id);
		return new ResponseEntity<>(studentResult,HttpStatus.OK);	
	}
	
	@PutMapping("/update_student")
	public ResponseEntity<Student> updateStudent(@RequestBody()Student student) {
		Student s = studentService.upadteStudent(student);
		return new ResponseEntity<>(s, HttpStatus.ACCEPTED);
	}

}
