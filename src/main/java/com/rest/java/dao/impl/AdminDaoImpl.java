package com.rest.java.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.java.dao.AdminDao;
import com.rest.java.entity.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public Admin addAdmin(Admin admin) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(admin);
		tx.commit();
		session.close();
		return admin;
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.update(admin);
		tx.commit();
		session.close();
		return admin;
	}

	@Override
	public Admin getAdminById(Integer id) {
		Session session=sf.openSession();
		Admin a=session.get(Admin.class, id);
		session.close();
		return a;
	}

	@Override
	public Admin deleteAdmin(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> getAllAdmins() {
		
		Session session=sf.openSession();
		String getAllAdmins="FROM Admin";
		Query q=session.createQuery(getAllAdmins);
		return q.list();
	}

}
