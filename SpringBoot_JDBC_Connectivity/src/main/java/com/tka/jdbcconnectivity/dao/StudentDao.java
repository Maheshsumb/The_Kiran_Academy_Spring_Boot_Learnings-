package com.tka.jdbcconnectivity.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.jdbcconnectivity.entities.Student;

@Repository
public class StudentDao {

	@Autowired
	SessionFactory factory;

	public String insertData(Student s) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		ss.persist(s);
		tr.commit();
		ss.close();

		return "Data Inserted.............";
	}

	public String deleteData(int sId) {

		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		Student s =ss.get(Student.class,sId);
		ss.remove(s);
		tr.commit();
		ss.close();
		return "Data is deleted for sId: "+sId+" ..............";
	}
	
	public Student displaySpecificData(int sId) {
		Session ss = factory.openSession();
		Student s= ss.get(Student.class, sId);
		ss.close();
		return s;
		
	}

}
