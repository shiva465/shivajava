package com.jdbcdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;

import com.daos.interfaces.IUserDao;
import com.jdbcutils.JdbcUtils;
import com.pojos.RegisterUser;

public class UserJdbcDao implements IUserDao {
	public String saveUser(RegisterUser reg) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Entered into saveUser::UserJdbcDao");
		Connection con = JdbcUtils.getJdbcConnection();
		PreparedStatement ps = con.prepareStatement("insert into registeruser values(?,?,?,?)");
		ps.setString(1, reg.getName());
		ps.setString(2, reg.getUname());
		ps.setString(3, reg.getPwd());
		ps.setString(4, reg.getEmail());
		int executeUpdate = ps.executeUpdate();

		System.out.println("exit from saveUser::UserJdbcDao");
		return "login";
	}

	public List<RegisterUser> loginUser(RegisterUser reg) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Entered into loginUser :: UserJdbcDao");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/sys", "root", "admin");
		PreparedStatement ps = conn.prepareStatement("select *from RegisterUser where email = ? AND pwd = ?");
		ps.setString(1, reg.getEmail());
		ps.setString(2, reg.getPwd());

		ResultSet rs = ps.executeQuery();
		List<RegisterUser> empList = new ArrayList<RegisterUser>();
		while (rs.next()) {
			RegisterUser reg1 = new RegisterUser();
			reg1.setEmail(rs.getString("email"));
			reg1.setName((rs.getString("name")));
			reg1.setUname(rs.getString("uname"));
			reg1.setPwd(rs.getString("pwd"));
			empList.add(reg1);
		}
		System.out.println("Exit from loginUser :: UserJdbcDao");
		return empList;
	}

	public List<RegisterUser> getAllUsers() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("entered into  getAllUsers :: UserJdbcDao");

		Connection con = JdbcUtils.getJdbcConnection();
		PreparedStatement ps = con.prepareStatement("select *from RegisterUser");
		ResultSet rs = ps.executeQuery();
		List<RegisterUser> empList = new ArrayList<RegisterUser>();
		while (rs.next()) {
			RegisterUser reg1 = new RegisterUser();
			reg1.setEmail(rs.getString("email"));
			reg1.setName((rs.getString("name")));
			reg1.setUname(rs.getString("uname"));
			reg1.setPwd(rs.getString("pwd"));
			empList.add(reg1);
		}
		System.out.println("Exit from getAllUsers :: UserJdbcDao");
		return empList;
	}

	public Integer deleteUserService(String email, Model model) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("user entered  into deleteUserService::UserJdbcDao ");
		Connection jdbcConnection = JdbcUtils.getJdbcConnection();
		PreparedStatement prepareStatement = jdbcConnection.prepareStatement("delete from registeruser where email=?");
		prepareStatement.setString(1, email);
		Integer update = prepareStatement.executeUpdate();
		System.out.println("user exit from deleteUserService::UserJdbcDao ");
		return update;
	}

	public RegisterUser getEditUser(RegisterUser reg, String email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("entered into getEditUser::UserJdbcDao");
		Connection jdbcConnection = JdbcUtils.getJdbcConnection();
		PreparedStatement prepareStatement = jdbcConnection.prepareStatement("select * from registeruser where email=?");
		prepareStatement.setString(1, email);
		ResultSet rs = prepareStatement.executeQuery();
		RegisterUser user= new RegisterUser();
		while(rs.next()) {
			user.setEmail(rs.getString("email"));
			user.setName(rs.getString("name"));
			user.setPwd(rs.getString("pwd"));
			user.setUname(rs.getString("uname"));	
		}
		System.out.println("entered into getEditUser::UserJdbcDao");
		return user;
	}

	public void updateUser(RegisterUser reg, Model model) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("entered into updateUser::UserJdbcDao");
		Connection connection = JdbcUtils.getJdbcConnection();
		PreparedStatement prepareStatement = connection.prepareStatement("update registeruser set name=?,uname=?,pwd=? where email=?");
		prepareStatement.setString(1, reg.getName());
		prepareStatement.setString(2, reg.getUname());
		prepareStatement.setString(3, reg.getPwd());
		prepareStatement.setString(4, reg.getEmail());
		prepareStatement.executeUpdate();
		System.out.println("entered into updateUser::UserJdbcDao");
		
	}

	public void deleteSelectedUsers(List<String> checked) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("user enter into deleteSelectedUser::UserJdbcDao");
		for (String string : checked) {
			 Connection connection = JdbcUtils.getJdbcConnection();
				PreparedStatement prepareStatement = connection.prepareStatement("delete from registeruser where email in(?)");
				prepareStatement.setString(1, string);
				int update = prepareStatement.executeUpdate();
			
		}
		/*Object[] myArray = checked.toArray();
		for (Object emails : myArray) {
		   System.out.println(emails);
		   Connection connection = JdbcUtils.getJdbcConnection();
			PreparedStatement prepareStatement = connection.prepareStatement("delete from registeruser where email in(?)");
			prepareStatement.setObject(1, emails);
			int update = prepareStatement.executeUpdate();
		}
*/		/*StringBuilder sb = new StringBuilder();
		for (String n : checked) { 
		    if (sb.length() > 0) sb.append(',');
		    sb.append("'").append(n).append("'");
		}
		System.out.println(sb.toString());
		String emails= sb.toString();*/
		/*String emails = checked.toString().replace("[", "'").replace("]", "'")
	            .replace(", ", "','");
	         */
		/*Connection connection = JdbcUtils.getJdbcConnection();
		PreparedStatement prepareStatement = connection.prepareStatement("delete from registeruser where email in(?)");
		prepareStatement.setString(1, emails);
		int update = prepareStatement.executeUpdate();*/
		//System.out.println(update);
		System.out.println("user exit from deleteSelectedUser::UserJdbcDao");
		
	}

}
