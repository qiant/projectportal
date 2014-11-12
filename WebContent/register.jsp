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
				<!-- <td>User Name :</td> -->
				<td><input type="text" name="userName" size="30" value="User Name" onkeypress="if (this.value=='User Name') this.value = ''"/></td>
			</tr>
			<tr>
				<!-- <td>Password :</td> -->
				<td><input type="text" name="password1" size="30" value="Password" onkeypress="if (this.value=='Password') this.value = '';this.type='password'"/></td>
			</tr>

			<tr>
				<!-- <td>Confirm Password :</td>
				<td><input type="password" name="password2" size="30" /></td> -->
				<td><input type="text" name="password2" size="30" value="Confirm Password" onkeypress="if (this.value=='Confirm Password') this.value = '';this.type='password'"/></td>
			</tr>
			<tr>
				<!-- <td>email :</td>
				<td><input type="email" name="email" size="30" /></td> -->
				<td><input type="text" name="email" size="30" value="E-Mail Address" onkeypress="if (this.value=='E-Mail Address') this.value = ''"/></td>
			</tr>
			<tr>
				<!-- <td>Phone :</td>
				<td><input type="text" name="phone" size="30" /></td> -->
				<td><input type="text" name="phone" size="30" value="Phone Number" onkeypress="if (this.value=='Phone Number') this.value = ''"/></td>
			</tr>
			<tr>
				<!-- <td>City :</td>
				<td><input type="text" name="city" size="30" /></td> -->
				<td><input type="text" name="city" size="30" value="City" onkeypress="if (this.value=='City') this.value = ''"/></td>
			</tr>
		</table>
		<p />
		<input type="submit" style="color:white; background-color:#44749D" value="Register Me!" />
		<p>
		<a href="${pageContext.request.contextPath}/login.jsp">Already a member? Sign in here.</a><br/>
	</form>
	</div>
	<!-- <h1>Registration Form</h1> -->
</body>
</html>