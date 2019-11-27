package com.rest.java.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.java.dao.PatientDao;
import com.rest.java.entity.Patient;

@Repository
public class PatientDaoImpl implements PatientDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Patient addPatient(Patient pnt) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(pnt);
		tx.commit();
		session.close();
		return pnt;
	}

	@Override
	public Patient updatePatient(Patient pnt) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.update(pnt);
		tx.commit();
		session.close();
		return pnt;
	}

	@Override
	public Patient getOnePatient(Integer id) {
		Session session=sf.openSession();
		Patient patient=session.get(Patient.class, id);
		session.close();
		return patient;
	}

	@Override
	public Patient deletePatient(Integer id) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Patient patient=session.get(Patient.class, id);
		
		if(patient !=null) {
			patient.setPid(id);
			session.delete(patient);
		}
		tx.commit();
		session.close();
		return patient;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> getAllPatients() {
		Session session=sf.openSession();
		String getPatients="FROM Patient";
		Query query=session.createQuery(getPatients);
		return query.list();
	}

}
