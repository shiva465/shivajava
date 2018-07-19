package com.hibernatedao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.ui.Model;

import com.daos.interfaces.IUserDao;
import com.hiberutils.HibernateUtils;
import com.pojos.RegisterUser;

public class UserHibernateDao implements IUserDao {
	public String saveUser(RegisterUser reg) {
		System.out.println("user entered into saveUser::UserDao");
		/*Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();
		org.hibernate.Session session = sessionFactory.openSession();*/
		Session session = HibernateUtils.getSession();
		session.save(reg);
		session.beginTransaction().commit();
		Query query = session.createQuery("from RegisterUser");
		List<RegisterUser> list = query.list();
		for (RegisterUser registerUser : list) {
			System.out.println(registerUser.getName() + "," + registerUser.getUname() + "," + registerUser.getPwd()
					+ "," + registerUser.getEmail());

		}
		System.out.println("user exciting from saveUser::UserDao");

		return "login";
	}

	public List<RegisterUser> loginUser(RegisterUser reg) {
		System.out.println("entered into loginUser::UserDao");
		/*
		 * Configuration config = new Configuration().configure("hibernate.cfg.xml");
		 * SessionFactory sessionFactory = config.buildSessionFactory();
		 * org.hibernate.Session session = sessionFactory.openSession();
		 */
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery("from RegisterUser where email=? AND pwd=?");
		query.setParameter(0, reg.getEmail());
		query.setParameter(1, reg.getPwd());
		List<RegisterUser> list = query.list();
		System.out.println("exit from  loginUser::UserDao");
		return list;

	}

	public List<RegisterUser> getAllUsers() {
		// TODO Auto-generated method stub
		System.out.println("entered into getAllUsers::UserDao");
		/*Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();
		org.hibernate.Session session = sessionFactory.openSession();*/
		Session session = HibernateUtils.getSession();
		Query query2 = session.createQuery("from RegisterUser");
		List<RegisterUser> list = query2.list();
		System.out.println("exit from getAllUsers::UserDao");
		return list;
	}

	public Integer deleteUserService(String email, Model model) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("User Entered into deleteUserService::UserHibernateDao");
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery("delete from RegisterUser where email=:mail");
		query.setParameter("mail", email);

		int result = query.executeUpdate();
		session.beginTransaction().commit();
		System.out.println("------" + result);
		System.out.println("User exit from deleteUserService::UserHibernateDao");
		return result;
	}

	public RegisterUser getEditUser(RegisterUser reg, String email) {
		// TODO Auto-generated method stub
		System.out.println("entered into getEditUser::UserHibernateDao");
		Session session = HibernateUtils.getSession();
		RegisterUser reg1 = (RegisterUser) session.get(RegisterUser.class, email);
		System.out.println("entered into getEditUser::UserHibernateDao");
		return reg1;
	}

	public void updateUser(RegisterUser reg, Model model) {
		// TODO Auto-generated method stub
		System.out.println("user intered into updateUser::UserHibernateDao");
		Session session = HibernateUtils.getSession();
		session.saveOrUpdate(reg);
		session.beginTransaction().commit();
		System.out.println("user exit from updateUser::UserHibernateDao");
	}

	public void deleteSelectedUsers(List<String> checked) {
		// TODO Auto-generated method stub
		System.out.println("user enter into deleteSelectedUsers::UserHibernateDao");
		System.out.println(checked);
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery("delete from RegisterUser where email in(:emails)");
		query.setParameterList("emails", checked);
		int result = query.executeUpdate();
		session.beginTransaction().commit();
		System.out.println("user exit from deleteSelectedUsers::UserHibernateDao");
		
	}
}
