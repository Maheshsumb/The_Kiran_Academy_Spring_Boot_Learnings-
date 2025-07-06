package com.tka.jdbcconnectivity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tka.jdbcconnectivity.entities.Student;
import com.tka.jdbcconnectivity.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService ss;
	
	@PostMapping("/insert")
	public String insertData(@RequestBody  Student s) {
		 return ss.insertData(s);
	}
	
	@DeleteMapping("/delete/{sId}")
	public String deleteData(@PathVariable int sId) {
		return ss.deleteData(sId);
	}
	
	@GetMapping("/show/{sId}")
	public Student displaySpecificData(@PathVariable int sId) {
		return ss.displaySpecificData(sId);
	}
}
