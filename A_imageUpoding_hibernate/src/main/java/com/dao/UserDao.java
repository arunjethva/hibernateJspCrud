package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.User;

public class UserDao {

	SessionFactory sf = null;

	public UserDao() {
		sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
	}

	public void addOrUpdate(User u) {
		Session s = sf.openSession();
		Transaction tx = null;
		tx = s.beginTransaction();
		s.saveOrUpdate(u);
		tx.commit();
	}

	public List<User> viewAlluser() {
		Session s = sf.openSession();
		Transaction tx = null;
		tx = s.beginTransaction();
		return s.createQuery("from User").list();

	}

	public int deleteUser(int id) {
		int i = 0;
		Session s = sf.openSession();
		Transaction tx = null;
		tx = s.beginTransaction();
		s.delete(s.get(User.class, id));
		tx.commit();
		i = 1;

		return i;
	}

	public User userById(int id) {

		
		Session s = sf.openSession();
		Transaction tx = null;
		tx = s.beginTransaction();
		User u = s.load(User.class, id);
		
		return u;
		

		
	}

}
