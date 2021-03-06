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
	<div align="center">
	<img src="${pageContext.request.contextPath}/images/PP-Logo-1.png" height="300px" width="400px" /><br>
	<img src="${pageContext.request.contextPath}/images/generic_avatar.jpg" height="100px" width="100px" /><p>
	<c:out value="Welcome Back, Visitor"></c:out> 
	<p>
	<form action="login" method="post">
	<c:out value="${requestScope['javax.servlet.error.message']}"/>
	 <div style="color: #FF0000;">${errorMessage}</div>
		<table cellpadding="3pt">
			<tr>
				<td><input type="text" name="username" size="30" value="User Name" onfocus="if (this.value=='User Name') this.value = ''" required/></td>
			</tr>
			<tr>
				<td><input type="text" name="password" size="30" value="Password" onfocus="if (this.value=='Password') this.value = '';this.type='password'" required/></td>
			</tr>
		</table>
		<input type="submit" style="color:white; background-color:#44749D" value="Log-In" /><p>
		<a href="${pageContext.request.contextPath}/register.jsp">Not a member? Register here!</a><br/>
		
	</form>
	</div>
</body>
</html>