package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Topic;
import com.revature.util.ConnectionUtil;

public class TopicDAOImpl implements TopicDAO {

	private SessionFactory sf = ConnectionUtil.getSessionFactory();

	@Override
	public boolean addTopic(Topic topic) {
		boolean isAdded = false;
		// try with resources on an AutoCloseable resource, closes at thend of control
		try (Session s = sf.openSession()) {
			// autocommit is OFF in Hibernate
			Transaction tx = s.beginTransaction();
			s.persist(topic);
			System.out.println(s.getStatistics());
			tx.commit();
			isAdded = true;
		}
		return isAdded;
	}

}
