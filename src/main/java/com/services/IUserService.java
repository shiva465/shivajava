package com.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.pojos.RegisterUser;

public interface IUserService {

	String saveUserService(RegisterUser reg) throws Exception;

	String loginUserService(RegisterUser reg, Model model) throws ClassNotFoundException, SQLException;

	String deleteUserService(@RequestParam("email") String email, Model model) throws Exception;

	String editUserService(@RequestParam("email") String email, RegisterUser reg, Model model) throws ClassNotFoundException, SQLException;

	String updateUserService(RegisterUser reg, Model model) throws Exception;

	String deleteSelectedService(@RequestParam("checked") List<String> checked, Model model) throws ClassNotFoundException, SQLException, Exception;

}
