package com.jwt.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jwt.hibernate.bean.User;

public class UserDAO {

	// 1. configuring hibernate
	private Configuration configuration = new Configuration().configure();

	// 2. create sessionfactory
	private SessionFactory sessionFactory = configuration.buildSessionFactory();
	// 3. Get Session object
	Session session = sessionFactory.openSession();

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addUserDetails(String userName, String password, String email,
			String phone, String city) {
		try {

			// 4. Starting Transaction
			Transaction transaction = session.beginTransaction();
			User user = new User();
			user.setUsername(userName);
			user.setPassword(password);
			user.setEmail(email);
			user.setCity(city);
			user.setPhone(phone);
			session.save(user);
			transaction.commit();
			System.out.println("\n\n Details Added \n");

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}

	}

	public void getUserLoginDetails(String userName, String password) {
		try {

			session.get(User.class, userName);
			System.out.println("\n\n User Logged in \n");

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}

	}

	public List<User> getUser(String username, String password) {
		String query = "from User user where username=? and password=?";
		org.hibernate.Query queryObj = session.createQuery(query);
		queryObj.setString(0, username);
		queryObj.setString(1, password);
		List<User> records = queryObj.list();
		return records;
	}

	public List<User> getUsers() {
		return getCurrentSession().createQuery("from User").list();
	}

}
