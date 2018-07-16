package com.quinhai.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;

public class DBUtil {
	
	private static Configuration config;
	private static SessionFactory sessionFactory;

	static {
		config = new Configuration().configure();
		sessionFactory = config.buildSessionFactory();
	}

	public static Session getConnection() {		
		return sessionFactory.openSession();
	}

}
