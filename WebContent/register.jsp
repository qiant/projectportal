<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Form</title>
</head>
<body>
	<div align="center">
	<img src="${pageContext.request.contextPath}/images/PP-Logo-1.png" height="300px" width="400px" /><br>
	<img src="${pageContext.request.contextPath}/images/register-icon.png" align="middle" height="35px" width="35px" />
	REGISTER NOW!
	<p>
	<form action="register" method="post">
		<table cellpadding="3pt">
			<tr>
				<td style="text-align:right">User Name :</td>
				<td style="text-align:right"><input type="text" name="userName" size="30" /></td>
			</tr>
			<tr>
				<td style="text-align:right">Password :</td>
				<td style="text-align:left"><input type="password" name="password1" size="30" /></td>
			</tr>

			<tr>
				<td style="text-align:right">Confirm Password :</td>
				<td style="text-align:left"><input type="password" name="password2" size="30" /></td>
			</tr>
			<tr>
				<td style="text-align:right">email :</td>
				<td style="text-align:right"><input type="email" name="email" size="30" /></td>
			</tr>
			<tr>
				<td style="text-align:right">Phone :</td>
				<td style="text-align:right"><input type="text" name="phone" size="30" /></td>
				
				</tr>
			<tr>
				<td style="text-align:right">City :</td>
				<td style="text-align:right"><input type="text" name="city" size="30" /></td>
				
			</tr>
		</table>
		<p />
		<input type="submit" style="color:white; background-color:#44749D" value="Register Me!" />
		<p>
		<a href="${pageContext.request.contextPath}/login.jsp">Already a member? Sign in here.</a><br/>
	</form>
	</div>
</body>
</html>