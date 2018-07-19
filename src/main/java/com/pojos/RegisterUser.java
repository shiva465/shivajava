package com.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="registeruser")
public class RegisterUser {
	@Column(name="name")
private String name;
	@Column(name="uname")
private String uname;
	@Id
	@Column(name="email")
private String email;
	@Column(name="pwd")
private String pwd;
	
	
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}


}
