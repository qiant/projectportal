<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<jsp:include page="/listClient" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Client</title>

 
</head>
<body>
	<h1>List all Clients</h1>
	 <form action="listClient" method="post" > 


<table border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<th width="15%">client Name</th><th width="10%">serviceLine</th><th width="10%">year</th><th width="10%">quarter</th><th width="10%">contactInfo</th><th width="10%">odds</th><th width="10%">status</th><th width="10%">action</th>
</tr>
</thead>
<tbody>
<c:forEach var="client" items="${clients}">
<tr>
	
	<td>${client.clientName}</td>
	<td>${client.serviceLine.name}</td>
	<td>${client.year}</td>
	<td>${client.quarter}</td>
	<td>${client.contactInfo}</td>
	<td>${client.odds}</td>
	<td>${client.status}</td>
	<td>
	<a href="${pageContext.request.contextPath}/editClient.jsp?${client.id}" >Edit</a><br/>
	<a href="${pageContext.request.contextPath}/${client.id}.html" onclick="return confirm('Are you sure you want to delete this?') ? true : false;">Delete</a><br/>
	</td>
</tr>
</c:forEach>
</tbody>
</table>
<p><a href="${pageContext.request.contextPath}/addClient.jsp">Add new record</a></p>
	 </form> 
</body>
</html>