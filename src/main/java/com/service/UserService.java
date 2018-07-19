package com.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.daos.interfaces.IUserDao;
import com.hibernatedao.UserHibernateDao;
import com.hiberutils.HibernateUtils;
import com.jdbcdao.UserJdbcDao;
import com.pojos.RegisterUser;
import com.services.IUserService;
import com.validation.Validate;

public class UserService implements IUserService {
 @Autowired
 private IUserDao dao;
	public String saveUserService(RegisterUser reg) throws ClassNotFoundException, SQLException  {
		System.out.println("entered into saveUserService::UserService");
		Validate valid = new Validate();
		if (valid.nullCheck(reg.getEmail())) {
			return "register";
		}
	
		String result = dao.saveUser(reg);
		System.out.println("exiting from  saveUserService::UserService");
		return result;

	}
	public String loginUserService(RegisterUser reg, Model model) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("entered into loginUserService::UserService");
		//fetching data from db for login
		List<RegisterUser> list = dao.loginUser(reg);
		if (list.isEmpty()) {
			model.addAttribute("message", "please enter valid credentials! try again");
			return "login";
		}
		List<RegisterUser> allList=dao.getAllUsers();
		model.addAttribute("userlist", allList);
		for (RegisterUser registerUser : allList) {
			System.out.println(registerUser.getName() + " " + registerUser.getUname() + "" + registerUser.getPwd() + ""
					+ registerUser.getEmail());
		}
		System.out.println("exited from loginService::UserService");
		
		return "profile";
	}
	
	public String deleteUserService(String email, Model model) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("user entered into deleteUserService::UserService");
		int result =  dao.deleteUserService(email, model);
		List<RegisterUser> allUsers = dao.getAllUsers();
		model.addAttribute("userlist", allUsers);
		System.out.println("user exit from deleteUserService::UserService");
		return "profile";
	}
	public String editUserService(String email, RegisterUser reg, Model model) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("entered into editUserService::UserService");
		
		//calling a method for getting particular user 
		RegisterUser editUser = dao.getEditUser(reg, email);
		//RegisterUser reg1 = (RegisterUser) session.get(RegisterUser.class, email);
		model.addAttribute("registeruser", editUser);
		System.out.println("exit from editUserService::UserService");
		return "update";
	}
	public String updateUserService(RegisterUser reg, Model model) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("entered into updateUserService::UserService");
		dao.updateUser(reg, model);
		List<RegisterUser> allUsers = dao.getAllUsers();
		model.addAttribute("userlist", allUsers);
		System.out.println("exit from updateUserService::UserService");
		return "profile";
	}
	public String deleteSelectedService(List<String> checked, Model model) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("user entered into deleteSelectedService::USerService");
		dao.deleteSelectedUsers(checked);
		List<RegisterUser> allUsers = dao.getAllUsers();
		model.addAttribute("userlist", allUsers);
		System.out.println("user entered into deleteSelectedService::USerService");
		return "profile";
	}

	/*public String loginService(Model model, RegisterUser reg) throws ClassNotFoundException, SQLException {
		System.out.println("entered into loginService::UserService");
		//fetching the data for login user
		//UserDao dao = new UserDao();
		//UserJdbcDao dao= new UserJdbcDao();
		//List<RegisterUser> list = dao.loginUser(reg);
		//List<RegisterUser> list = dao.loginUser(reg);
		//validating user with list
		if (list.isEmpty()) {
			model.addAttribute("message", "please enter valid credentials! try again");
			return "login";
		}
		//getting all users from db
		//List<RegisterUser> allList = dao.getAllUsers();
	//	List<RegisterUser> allList=dao.getAllUsers();
		//model.addAttribute("userlist", allList);
		for (RegisterUser registerUser : allList) {
			System.out.println(registerUser.getName() + " " + registerUser.getUname() + "" + registerUser.getPwd() + ""
					+ registerUser.getEmail());
		}
		System.out.println("exited from loginService::UserService");
		return "profile";
	}
*/
	}
