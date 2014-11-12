<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

if (session != null && session.getAttribute("username")!=null)
{
	request.getRequestDispatcher("/WEB-INF/client/editClient.jsp").forward( request, response) ;
}else{
	
	%><jsp:forward page="login.jsp" /><%
	
}
%>
</body>
</html>