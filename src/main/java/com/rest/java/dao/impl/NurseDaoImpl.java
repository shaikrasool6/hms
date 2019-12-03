package com.rest.java.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.java.dao.NurseDao;
import com.rest.java.entity.Nurse;
@Repository
public class NurseDaoImpl implements NurseDao{
	
	@Autowired
	private SessionFactory sf;

	@Override
	public Nurse addNurse(Nurse nurse) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(nurse);
		tx.commit();
		session.close();
		return nurse;
	}

	@Override
	public Nurse updateNurse(Nurse nurse) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.update(nurse);
		tx.commit();
		session.close();
		return nurse;
	}

	@Override
	public Nurse getOneNurseById(Integer id) {
		Session session=sf.openSession();
		Nurse n=session.get(Nurse.class, id);
		session.close();
		return n;
	}

	@Override
	public Nurse deleteOneNurseById(Integer id) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Nurse n=session.get(Nurse.class, id);
		if(n!=null) {
			n.setnId(id);
			session.delete(n);
		}
		tx.commit();
		session.close();
		return n;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Nurse> getAllNurses() {
		Session session=sf.openSession();
		String getAll="FROM Nurse";
		Query q=session.createQuery(getAll);
		return q.list();
	}

}
