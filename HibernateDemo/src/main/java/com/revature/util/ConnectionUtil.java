package com.revature.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			// if no SessionFatory has been created, make one
			Configuration c = new Configuration();
			// read in connection details from a system environment
			// can also use a properties file like we have before
			// or hardcode (don't but it's possible)
			c.setProperty("hibernate.connection.username", System.getenv("DB_USERNAME"));
			c.setProperty("hibernate.connection.password", System.getenv("DB_PASSWORD"));
			c.setProperty("hibernate.connection.url", System.getenv("DB_URL"));
			// by default, looks for src/main/resources/hibernate.cfg.xml for other properties
			c.configure();
			sessionFactory = c.buildSessionFactory();
		}
		return sessionFactory;
	}

}
