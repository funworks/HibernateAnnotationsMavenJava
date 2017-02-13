package com.relationships.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable t) {
			System.err.println("Initial SessionFactory creation failed." + t);
            throw new ExceptionInInitializerError(t);
		}
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	
	public static void shutdown() {
		getSessionfactory().close();
	}

}
