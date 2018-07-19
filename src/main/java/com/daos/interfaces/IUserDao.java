package com.daos.interfaces;

import java.sql.SQLException;
import java.util.List;

import org.springframework.ui.Model;

import com.pojos.RegisterUser;

public interface IUserDao {

	String saveUser(RegisterUser reg) throws ClassNotFoundException, SQLException;

	List<RegisterUser> loginUser(RegisterUser reg) throws SQLException, ClassNotFoundException;

	List<RegisterUser> getAllUsers() throws ClassNotFoundException, SQLException;

	Integer deleteUserService(String email, Model model) throws ClassNotFoundException, SQLException;

	RegisterUser getEditUser(RegisterUser reg, String email) throws ClassNotFoundException, SQLException;

	
	void updateUser(RegisterUser reg, Model model) throws Exception;

	void deleteSelectedUsers(List<String> checked) throws Exception;

	
}
