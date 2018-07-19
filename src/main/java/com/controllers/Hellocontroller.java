package com.controllers;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.daos.interfaces.IUserDao;
import com.hibernatedao.UserHibernateDao;
import com.hiberutils.HibernateUtils;
import com.jdbcdao.UserJdbcDao;
import com.pojos.RegisterUser;
import com.service.UserService;
import com.services.IUserService;
import com.test.pojo.TestPojo;
import com.validation.Validate;

@Controller
public class Hellocontroller {
	/*
	 * @Autowired private IUserDao dao;
	 */ /*
		 * @Autowired private TestPojo test1;
		 * 
		 * @Autowired private TestPojo test2;
		 */
	@Autowired
	private IUserService user;

	@RequestMapping(value = "/registeruser")
	public String SaveUser(RegisterUser reg) throws Exception {
		System.out.println("entered into SaveUSer::Hellocontroller");
		// testing code for singlton and factory design patterns
		/*
		 * System.out.println("////////////////////////////////////");
		 * test1.setFisrtName("shiva"); test1.setLastName("krishna");
		 * test1.setCity("karimnagar"); test2.setFisrtName("ramu");
		 * test2.setLastName("galipelli"); test2.setCity("hyderabad");
		 * System.out.println(test2.getFisrtName());
		 * System.out.println(test2.getLastName()); System.out.println(test2.getCity());
		 * System.out.println(test1.getFisrtName());
		 * System.out.println(test1.getLastName()); System.out.println(test1.getCity());
		 * 
		 * 
		 * System.out.println("////////////////////////////////////");
		 */ // calling service method
		String result = user.saveUserService(reg);
		System.out.println("exited from SaveUser::Hellocontroller");
		return result;
	}

	@RequestMapping(value = "/loginuser")
	public String loginuser(RegisterUser reg, Model model) throws ClassNotFoundException, SQLException {
		System.out.println("entered into loginuser::HelloController");
		System.out.println(reg.getEmail());
		System.out.println(reg.getPwd());
		// calling login method in service class
		String result = user.loginUserService(reg, model);
		/* UserService user= new UserService(); */
		// String result=user.loginService(model, reg);
		// System.out.println("came to login page");
		// model.addAttribute("username", reg.getEmail());
		// return result;

		// fetching the data for login user
		// UserDao dao = new UserDao();
		// UserJdbcDao dao= new UserJdbcDao();
		// List<RegisterUser> list = dao.loginUser(reg);
		// String result = user.loginUserService(reg, model);
		// validating user with list
		/*
		 * if (list.isEmpty()) { model.addAttribute("message",
		 * "please enter valid credentials! try again"); return "login"; }
		 */
		// getting all users from db
		// List<RegisterUser> allList = dao.getAllUsers();
		/*
		 * List<RegisterUser> allList=dao.getAllUsers(); model.addAttribute("userlist",
		 * allList); for (RegisterUser registerUser : allList) {
		 * System.out.println(registerUser.getName() + " " + registerUser.getUname() +
		 * "" + registerUser.getPwd() + "" + registerUser.getEmail()); }
		 */
		System.out.println("exited from loginuser::HelloController");

		return result;
	}

	@RequestMapping(value = "/deleteUser")
	public String deleteUser(@RequestParam("email") String email, Model model) throws Exception {
		System.out.println("user entered into deleteUser::Hellocontroller");
		String string = user.deleteUserService(email, model);
		// System.out.println("email is " + email);
		/*
		 * Configuration configuration = new
		 * Configuration().configure("hibernate.cfg.xml"); SessionFactory sessionFactory
		 * = configuration.buildSessionFactory(); Session session =
		 * sessionFactory.openSession();
		 * 
		 * Query query =
		 * session.createQuery("delete from RegisterUser where email=:mail");
		 * query.setParameter("mail", email);
		 * 
		 * int result = query.executeUpdate(); session.beginTransaction().commit();
		 * System.out.println("------" + result);
		 * 
		 * Query queryAll = session.createQuery("from RegisterUser"); List<RegisterUser>
		 * employeeList = queryAll.list(); model.addAttribute("userlist", employeeList);
		 */
		System.out.println("user exits from deleteUser::Hellocontroller");
		return string;

	}

	@RequestMapping(value = "/editUser")
	public String editUser(@RequestParam("email") String email, RegisterUser reg, Model model) throws ClassNotFoundException, SQLException {
		System.out.println("entered into editUser::Hellocontroller");
		System.out.println("email is " + email);
		/*
		 * Configuration configuration = new
		 * Configuration().configure("hibernate.cfg.xml"); SessionFactory sessionFactory
		 * = configuration.buildSessionFactory(); Session session =
		 * sessionFactory.openSession();
		 */
		String update = user.editUserService(email, reg, model);
		/*Session session = HibernateUtils.getSession();
		RegisterUser reg1 = (RegisterUser) session.get(RegisterUser.class, email);
		model.addAttribute("registeruser", reg1);*/
		System.out.println("exit from editUser::Hellocontroller");
		return update;

	}

	@RequestMapping(value = "/updateuser")
	public String updateUser(RegisterUser reg, Model model) throws Exception {
		System.out.println("entered into updateUser::Hellocontroller");
		System.out.println(reg.getEmail());
		/*System.out.println(reg.getEmail());
		System.out.println(reg.getName());
		System.out.println(reg.getUname());
		System.out.println(reg.getPwd());*/
		/*Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(reg);
		session.beginTransaction().commit();*/
		String string = user.updateUserService(reg, model);
		/*Query queryAll = session.createQuery("from RegisterUser");
		List<RegisterUser> employeeList = queryAll.list();*/
		/*model.addAttribute("userlist", employeeList);*/
		System.out.println("exit from updateUser::Hellocontroller");
		return string;

	}

	@RequestMapping(value = "/deleteMany")
	public String deleteSelected(@RequestParam("checked") List<String> checked, Model model) throws Exception {
		System.out.println("user entered into deleteSelected :: Hellocontroller");
		System.out.println(checked);
		for (String string : checked) {
			System.out.println(string);
		}
		String string = user.deleteSelectedService(checked, model);
		/*Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("delete from RegisterUser where email in(:emails)");
		query.setParameterList("emails", checked);

		int result = query.executeUpdate();
		session.beginTransaction().commit();
		System.out.println("------" + result);
*/
		/*Query queryAll = session.createQuery("from RegisterUser");
		List<RegisterUser> employeeList = queryAll.list();
		model.addAttribute("userlist", employeeList);*/
		System.out.println("user exit from deleteSelected :: Hellocontroller");
		return string;

	}

}