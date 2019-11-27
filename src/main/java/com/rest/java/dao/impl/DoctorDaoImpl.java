package com.rest.java.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.java.dao.DoctorDao;
import com.rest.java.entity.Doctor;

@Repository
public class DoctorDaoImpl implements DoctorDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Doctor addDoctor(Doctor dr) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(dr);
		tx.commit();
		session.close();
		return dr;
	}

	@Override
	public Doctor updateDoctor(Doctor dr) {
		
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.update(dr);
		tx.commit();
		session.close();
		return dr;
		
		
	}

	@Override
	public Doctor getOneDoctorById(Integer id) {
		
		Session session=sf.openSession();
		Doctor doc=session.get(Doctor.class, id);
		session.close();
		
		return doc;
	}

	@Override
	public Doctor deleteDoctorById(Integer id) {
		
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		Doctor doc=session.get(Doctor.class , id);
		
		if(doc !=null) {
			doc.setDrId(id);
			session.delete(doc);
		}
		tx.commit();
		session.close();
		
		return doc;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> getAllDoctors() {
		
		Session session = sf.openSession();
		
		String getAll="FROM Doctor";
		
		Query query=session.createQuery(getAll);

		return query.list();
	}

}
