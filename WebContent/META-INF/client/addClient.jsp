<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="./resources/dualList.js"></script>

<title>Client</title>

  <style type="text/css"> 
    .btn {width:90px;} 
  </style> 
</head>
<body>
	<h1>Add New Record</h1>
	<form action="addClient" method="post" name="form1" id="form1" onsubmit="selectAllOptions(selectedItems)">
		<table cellpadding="3pt">
			<tr>
				<td>User Name :</td>
				<td><input type="text" name="clientName" size="30" /></td>
			</tr>
			<tr>
				<td>Comments :</td>
				<td><input type="text" name="comments" size="30" /></td>
			</tr>

			<tr>
				<td>Contact Info :</td>
				<td><input type="text" name="contactInfo" size="30" /></td>
			</tr>
			<tr>
				<td>skills :</td>
				<td><!-- <SELECT id="skills" name="skills" size="10" multiple>
	<OPTION value="1">Java</OPTION>
	<OPTION value="2">C++</OPTION> -->
	<div style="width:130px;float:left;"> 
<select size="10" multiple name="availableItems" id="availableItems" style="width:120px;"> 
<c:forEach items="${skillList}" var="skill">
    <option value="<c:out value='${skill.name}'/>">
      <c:out value="${skill.name}"/>
    </option>
  </c:forEach>
	
<%-- <% for i = 0 to ubound(initialItems) %> 
  <option value="<%=i%>"i><%=initialItems(i) %></option> 
<% next %>  --%>
</select> 
</div> 
<div style="width:100px;float:left;"> 
<input type="button" class="btn" value="Add" onclick="addItems();" /> 
<input type="button" class="btn" value="Add All" onclick="addAll();" /> 
<input type="button" class="btn" value="Remove" onclick="removeItems();" /> 
<input type="button" class="btn" value="Remove All" onclick="removeAll();" /> 

</div> 
<div style="width:130px;float:left"> 
<select size="10" multiple="multiple" name="skills" id="selectedItems" style="width:120px;"> 
</select> 
</div> 
</SELECT>
</td>
			</tr>
			<tr>
				<td>staffNumber :</td>
				<td><input type="number" name="staffNumber" min="0" max="100" step="1" /></td>
			</tr>
			<tr>
				<td>year :</td>
				<td><input type="year" name="year" size="30" /></td>
			</tr>
			<tr>
				<td>quarter :</td>
				<td><input type="number" name="quarter" min="0" max="4" /></td>
			</tr>
			<tr>
				<td>odds :</td>
				<td><SELECT id="odds" name="odds">
						<OPTION value="high">High</OPTION>
						<OPTION value="medium">Medium</OPTION>
						<OPTION value="low">Low</OPTION>
						
			</td>
			</tr>
			<tr>
				<td>interlockNumber :</td>
				<td><!-- <input type="text" name="interlockNumber" size="30" /> -->
				<input type="number" name="interlockNumber" min="0" max="100" step="1">
				</td>
			</tr><tr>
				<td>nonInterlockNumber :</td>
				<td><input type="number" name="nonInterlockNumber" min="0" max="100" step="1" /></td>
			</tr><tr>
				<td>resourceNumber :</td>
				<td><input type="number" name="resourceNumber" min="0" max="100" step="1" /></td>
			</tr><tr>
				<td>status :</td>
				<td><SELECT id="odds" name="odds">
						<OPTION value="open">Open</OPTION>
						<OPTION value="closed">Close</OPTION></td>
			</tr><tr>
				<td>serviceLine :</td>
				<td>
        <c:out value="${session.serviceLineList}"/>
        
        <select name="serviceLine" id="serviceLine" class="span3">
  <c:forEach items="${serviceLineList}" var="servline">
    <option value="<c:out value='${servline.id}'/>">
      <c:out value="${servline.name}"/>
    </option>
  </c:forEach>
</select>
        
        </td>
			</tr>
		</table>
		<p />
		<input type="submit" value="Submit" />
	</form>
</body>
</html>