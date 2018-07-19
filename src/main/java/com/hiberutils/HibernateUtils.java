package com.hiberutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private HibernateUtils() {
		
	}
	public static Session getSession() {
		 Configuration configure = new Configuration().configure("hibernate.cfg.xml");
		 Session session = configure.buildSessionFactory().openSession();
		return session;
		
	}
	/*public static Connection getJdbcConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sys", "root", "admin");
		return con;	
	}*/
}
