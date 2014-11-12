package com.jwt.hibernate.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jwt.hibernate.bean.Client;
import com.jwt.hibernate.bean.ServiceLine;
import com.jwt.hibernate.bean.Skill;
import com.jwt.hibernate.bean.User;

public class ClientDAO {

	// 1. configuring hibernate
	private Configuration configuration = new Configuration().configure();

	// 2. create sessionfactory
	private SessionFactory sessionFactory = configuration.buildSessionFactory();
	// 3. Get Session object
	Session session = sessionFactory.openSession();

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addClientDetails(String userName, String password, String email,
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

	public void addClientDetails(String clientName, String year,String comments,
			String quarter, String odds, Integer staffNumber,
			Integer nonInterlockNumber, Integer interlockNumber,
			Integer resourceNumber, String contactInfo, String status,
			Integer serviceLine,Set<Skill>skills) {
		try {

			// 4. Starting Transaction
			Transaction transaction = session.beginTransaction();
			Client client = new Client();
			client.setClientName(clientName);
			client.setComments(comments);
			client.setYear(year);
			client.setQuarter(quarter);
			client.setOdds(odds);
			client.setStaffNumber(staffNumber);
			client.setNonInterlockNumber(nonInterlockNumber);
			client.setInterlockNumber(interlockNumber);
			client.setResourceNumber(resourceNumber);
			client.setContactInfo(status);
			client.setStatus(status);
			client.setSkills(skills);
			ServiceLine line=new ServiceLine();
			line.setId(serviceLine);
			client.setServiceLine(line);
			session.save(client);
			transaction.commit();
			System.out.println("\n\n Client Added \n");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("errhjghjgor");
		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Client> getClients() {
		Session session = sessionFactory.openSession();
		return session.createQuery("from Client").list();
	}

}
