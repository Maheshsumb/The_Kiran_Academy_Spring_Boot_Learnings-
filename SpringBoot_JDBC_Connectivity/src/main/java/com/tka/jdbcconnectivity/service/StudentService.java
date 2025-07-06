package com.tka.jdbcconnectivity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.jdbcconnectivity.dao.StudentDao;
import com.tka.jdbcconnectivity.entities.Student;

@Service
public class StudentService {
	@Autowired
	StudentDao sd;
	public String insertData(Student s) {
		return sd.insertData(s);
	}
	
	public String deleteData(int sId) {
		return sd.deleteData(sId);
	}
	
	public Student displaySpecificData(int sId) {
		return sd.displaySpecificData(sId);
	}

}
