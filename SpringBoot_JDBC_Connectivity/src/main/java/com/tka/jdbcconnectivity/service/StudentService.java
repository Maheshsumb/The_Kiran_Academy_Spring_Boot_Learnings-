package com.tka.jdbcconnectivity.service;

import java.util.List;

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
	
	public String updateData(int sId, Student s) {
		return sd.updateData(sId, s);
	}
	public List<Student> getAllData(){
		return sd.getAllData();
	}

}
