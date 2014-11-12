<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Please Enter Username & Password</h1>
	<form action="login" method="post">
	<c:out value="${requestScope['javax.servlet.error.message']}"/>
	 <div style="color: #FF0000;">${errorMessage}</div>
		<table cellpadding="3pt">
			<tr>
				<td>User Name :</td>
				<td><input type="text" name="username" size="30" required/></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password" size="30" required/></td>
			</tr>

			
		</table>
		<p />
		<input type="submit" value="Login" />
		<a href="${pageContext.request.contextPath}/register.jsp">Register!</a><br/>
		
	</form>
</body>
</html>