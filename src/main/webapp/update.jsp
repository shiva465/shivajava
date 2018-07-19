<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateuser">
Name <input type="text" name="name" value='${registeruser.name}'/><br><br>
UserName <input type="text" name="uname" value='${registeruser.uname}'/><br> <br>
Password <input type="text" name="pwd" value='${registeruser.pwd}'/><br><br>
Email <input type="text" name="email" readonly="readonly" value='${registeruser.email}'/><br><br>
<input type="submit" value="Update"/>
</form>

</body>
</html>