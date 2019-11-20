package com.rest.java.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.java.dao.HospitalDao;
import com.rest.java.entity.Hospital;

/**
 * 
 * This is Implementation calss of HospitalDao, in this class data will be
 * transfer to data base with the help of Hibernate
 * 
 * This is Implementation calss of HospitalDao, in this class data will be
 * transfer to data base with the help of Hibernate
 * 
 * 
 * @author Shaik
 *
 */
@Repository
public class HospitalDaoImpl implements HospitalDao {

	@Autowired
	private SessionFactory sf;

	/**
	 *
	 */
	@Override
	public Hospital addHospital(Hospital hospital) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(hospital);
		tx.commit();
		session.close();
		return hospital;
	}

	@Override
	public Hospital updateHospital(Hospital hospital) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.update(hospital);
		tx.commit();
		session.close();
		return hospital;
	}

	@Override

	public Hospital deleteHospital(Integer id) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Hospital h = session.get(Hospital.class, id);
		if (h != null) {
			h.setHospId(id);
			session.delete(h);
		}
		tx.commit();
		session.close();
		return h;
	}

	@Override

	public Hospital getOneHospital(Integer id) {

		Session session = sf.openSession();
		Hospital h = session.get(Hospital.class, id);
		session.close();
		return h;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Hospital> getAllHospitals() {

		Session session = sf.openSession();
		String getAllHospitals = "FROM Hospital";
		Query q = session.createQuery(getAllHospitals);
		return q.list();
	}

	@Override
	public Hospital searchHospital(String name) {
		Session session = sf.openSession();
		Hospital h = session.get(Hospital.class, name);
		session.close();
		return h;
	}

}
