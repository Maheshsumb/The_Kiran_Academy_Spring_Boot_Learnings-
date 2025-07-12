package com.tka.jdbcconnectivity.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.jdbcconnectivity.entities.Student;

import jakarta.persistence.Query;

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
		Student s = ss.get(Student.class, sId);
		ss.remove(s);
		tr.commit();
		ss.close();
		return "Data is deleted for sId: " + sId + " ..............";
	}

	public Student displaySpecificData(int sId) {
		Session ss = factory.openSession();

//		Student s= ss.get(Student.class, sId);

		String hqlQuery = "from Student where sID = :sID";
		Query query = ss.createQuery(hqlQuery, Student.class);
		query.setParameter("sID", sId);
		Student s = (Student) query.getSingleResult();
		ss.close();
		return s;

	}

	public String updateData(int sId, Student s) {

		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		Student s1 = ss.get(Student.class, sId);
		s1.setsName(s.getsName());
		s1.setsAge(s.getsAge());
		s1.setsCity(s.getsCity());
		ss.merge(s1);
		tr.commit();
		ss.close();
		return "Data of " + sId + " is updated.......";
	}

	public List<Student> getAllData() {
		Session ss = factory.openSession();
		String hqlQuery = "from Student";
		Query query = ss.createQuery(hqlQuery, Student.class);
		List<Student> lst = query.getResultList();
		ss.close();
		return lst;
	}

}
