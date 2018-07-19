<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function deleteuser(mail) {
		alert("delete button pressed" + mail);
		document.forms[0].action = "${pageContext.request.contextPath}/deleteUser?email="+ mail;
		document.forms[0].method = "post";
		document.forms[0].submit();
	} 
	function editUser(mail,name,username,password) {
		/*  var editData = prompt("what do want edit in record", "");
		name=editData;  */
		
		document.forms[0].action = "${pageContext.request.contextPath}/editUser?email="+ mail+"&name="+name+"&uname="+username+"&pwd="+password;
		document.forms[0].method = "post";
		document.forms[0].submit();
	}
	function deleteUsers() {
		document.forms[0].action = "${pageContext.request.contextPath}/deleteMany";
		document.forms[0].method = "post";
		document.forms[0].submit();
	}
	
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<form action="">
		<table border="2">
			<tr style="color: red">
				<th>Name</th>
				<th>UserName</th>
				<th>password</th>
				<th>email</th>
			</tr>

			<core:forEach var="employee" items="${userlist}">
				<tr>
					<td><core:out value="${employee.name}" /></td>
					<td><core:out value="${employee.uname}" /></td>
					<td><core:out value="${employee.pwd}" /></td>
					<td><core:out value="${employee.email}" /></td>
					<td><input type="button" value="EDIT"
						onclick="editUser('${employee.email}','${employee.name}','${employee.uname}','${employee.pwd}')" />
					<td><input type="button" value="DELETE"
						onclick="deleteuser('${employee.email}')" /></td>
						<td> <input type="checkbox"  name="checked" value="${employee.email}" /></td>
					
				</tr>
				
			</core:forEach>
			<tr><td><input type="button" value="deleteselected" onclick="deleteUsers()"/></td></tr>
		</table>
	</form>
	
	</body>
</html>