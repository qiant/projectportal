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

public class SkillDAO {

	// 1. configuring hibernate
	private Configuration configuration = new Configuration().configure();

	// 2. create sessionfactory
	private SessionFactory sessionFactory = configuration.buildSessionFactory();
	// 3. Get Session object
	Session session = sessionFactory.openSession();

	

	

	
	@SuppressWarnings("unchecked")
	public List<Skill> getSkillList() {
		Session session = sessionFactory.openSession();
		return session.createQuery("from Skill").list();
	}

}
