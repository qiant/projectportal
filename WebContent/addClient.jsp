<html lang=''>
<head>
   <meta charset='utf-8'>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="resources/style.css">
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   <script src="resources/script.js"></script>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <script type="text/javascript" src="./resources/dualList.js"></script>
   <style type="text/css">
       .btn {width:90px;}
   </style> 
   <title>Project Portal Menu</title>
</head>

<body>
<div id='topBar'>

</div>

<div id='logo'>
	<div class='container'>
		<img src="images/PP-Logo-2.png" alt="IBM Project Portal">
	</div>
</div>

<div id='cssmenu'>
<ul>
   <li><a href='#'>Home</a></li>
   <li class='active has-sub'><a href='#'>Create</a>
      <ul>
         <li class='has-sub'><a href='#'>Client Information</a>
            <ul>
               <li><a href='addClient.jsp'>Add</a></li>
               <li><a href='#'>Edit</a></li>
			   <li><a href='#'>List</a></li>
            </ul>
         </li>
      </ul>
   </li>
   <li><a href='#'>Report</a></li>
   <li><a href='#'>Exit</a></li>
</ul>
</div>

    <div id='section'>
    <h2>Add a Client</h2>
	<form action="addClient" method="post" name="form1" id="form1" onsubmit="selectAllOptions(selectedItems)">
		<table cellpadding="3pt">
			<tr>
				<td>User Name <input type="text" name="clientName" size="30" /></td>
				<td style="height: 38px; width: 143px">Service Line 
			        <c:out value="${session.serviceLineList}"/>
			        <select name="serviceLine" id="serviceLine" class="span3">
 			 			<c:forEach items="${serviceLineList}" var="servline">
    <option value="<c:out value='${servline.id}'/>">
      <c:out value="${servline.name}"/>
    </option>
  </c:forEach>
					</select>
        		</td>
        		<td style="width: 74px; ">Top 10<input type="checkbox" name="top10" value="Top10"> </td>
        		<td style="width: 172px; "> Status
						<select id="status" name="status">
						   <option value="open">Open</option>
						   <option value="closed">Closed</option>
			            </select> 
	    		</td>
	    		<td>     </td>
	    		<td style="width: 121px; ">Odds <select id="odds" name="odds">
						<option value="high">High</option>
						<option value="medium">Medium</option>
						<option value="low">Low</option>
			          </select>
			    </td>
        	</tr>
        	<tr>
            	
			    <td>Staffing Plan Roles <input type="number" name="staffNumber" min="0" max="100" step="1" style="width: 41px; "/></td>
				<td style="width: 200px; ">Interlock Seats <!-- <input type="text" name="interlockNumber" size="30" /> -->
				<input type="number" name="interlockNumber" min="0" max="100" step="1" style="width: 41px; ">
				</td>
			    <td style="width: 186px; ">NonInterlock Seats<input type="number" name="nonInterlockNumber" min="0" max="100" step="1"  style="width: 41px; "/></td>
			    <td>Resources <input type="number" name="resourceNumber" min="0" max="100" step="1" style="width: 41px; "/></td>
        		<td>     </td>
        		<td style="width: 292px; ">Estimate Start: <input type="number" name="year" size="4" value="2014" style="width: 45px; "><select id="quarter" name="quarter" style="height: 29px; width: 52px">
						        <option value="Q1">Q1</option>
						        <option value="Q2">Q2</option>
						        <option value="Q3">Q3</option>
						        <option value="Q4">Q4</option>
			                </select>
				</td>

	
			</tr>
			<tr>
				<tr><td>Skills</td></tr>
				<td align="right"> <!-- <SELECT id="skills" name="skills" size="10" multiple>
						  			<option value="1">.Net</option>
  			<option value="2">C#</option>
  			<option value="3">C++</option>
  			<option value="4">Cognos</option>
  			<option value="5">Datastage</option>
  			<option value="6">Dojo</option>
  			<option value="7">FileNet</option>
  			<option value="8">Hyperion</option>
  			<option value="9">Informatica</option>
  			<option value="10">J2EE</option>
  			<option value="11">Java</option>
  			<option value="12">Javascript</option>
  			<option value="13">Mobile App - Android</option>
  			<option value="14">Mobile App - iOS</option>
  			<option value="15">Oracle eBiz</option>
  			<option value="16">Oracle Finance</option>
  			<option value="17">Oracle Forms</option>
  			<option value="18">Oracle ReTek</option>
  			<option value="19">Peoplesoft Financials</option>
  			<option value="20">Peoplesoft HR</option>
  			<option value="21">PHP</option>
  			<option value="22">Remedy</option>
  			<option value="23">SAP ABAP</option>
  			<option value="24">SAP Basis</option>
  			<option value="25">SAP Business Objects</option>
  			<option value="26">SAP BW</option>
  			<option value="27">SAP CO</option>
  			<option value="28">SAP FI</option>
  			<option value="29">SAP MM</option>
  			<option value="30">SAP SD</option>
  			<option value="31">Sharepoint</option>
  			<option value="32">Sterling Integrator EDI</option>
  			<option value="33">Sterling OMS</option>
  			<option value="34">Sterling Other </option>
  			<option value="35">Tririga</option>
  			<option value="36">Websphere Commerce</option>
  			<option value="37">Websphere Other</option>
  			<option value="38">Websphere Portal</option>
  			<option value="39">Worklight</option>
  			<option value="40">XML</option> -->
						<div float="right" style="width: 127px; "> 
						 
						</div><select size="10" multiple name="availableItems" id="availableItems" style="width:120px;"> 
  			<option value="1">.Net</option>
  			<option value="2">C#</option>
  			<option value="3">C++</option>
  			<option value="4">Cognos</option>
  			<option value="5">Datastage</option>
  			<option value="6">Dojo</option>
  			<option value="7">FileNet</option>
  			<option value="8">Hyperion</option>
  			<option value="9">Informatica</option>
  			<option value="10">J2EE</option>
  			<option value="11">Java</option>
  			<option value="12">Javascript</option>
  			<option value="13">Mobile App - Android</option>
  			<option value="14">Mobile App - iOS</option>
  			<option value="15">Oracle eBiz</option>
  			<option value="16">Oracle Finance</option>
  			<option value="17">Oracle Forms</option>
  			<option value="18">Oracle ReTek</option>
  			<option value="19">Peoplesoft Financials</option>
  			<option value="20">Peoplesoft HR</option>
  			<option value="21">PHP</option>
  			<option value="22">Remedy</option>
  			<option value="23">SAP ABAP</option>
  			<option value="24">SAP Basis</option>
  			<option value="25">SAP Business Objects</option>
  			<option value="26">SAP BW</option>
  			<option value="27">SAP CO</option>
  			<option value="28">SAP FI</option>
  			<option value="29">SAP MM</option>
  			<option value="30">SAP SD</option>
  			<option value="31">Sharepoint</option>
  			<option value="32">Sterling Integrator EDI</option>
  			<option value="33">Sterling OMS</option>
  			<option value="34">Sterling Other </option>
  			<option value="35">Tririga</option>
  			<option value="36">Websphere Commerce</option>
  			<option value="37">Websphere Other</option>
  			<option value="38">Websphere Portal</option>
  			<option value="39">Worklight</option>
  			<option value="40">XML</option>
 
	
						<%-- <% for i = 0 to ubound(initialItems) %> 
  						<option value="<%=i%>"i><%=initialItems(i) %></option> 
						<% next %>  --%>
							</select> 

				</td>		
				<td align="">		<div id='skill'> 
							<input type="button" class="btn" value="Add       " onclick="addItems();" style="width: 79px; "/> 
							<input type="button" class="btn" value="Add All    " onclick="addAll();" style="width: 79px; "/> 
							<input type="button" class="btn" value="Remove     " onclick="removeItems();" style="width: 79px; "/> 
							<input type="button" class="btn" value="Remove All " onclick="removeAll();" style="width: 79px; "/> 
						</div> 
				</td>
				<td align="">
						<div id='skill'> 
							 <select size="10" multiple="multiple" name="skills" id="selectedItems" style="width:120px;"> 
							</select> 
						</div>
				</td>

				
			</tr>
<tr>				<td valign="top" align="left" colspan="3">Contact Info :
				<br><textarea name="contacts"  style="height: 177px; width: 660px">Enter contacts here...</textarea></td>				
</tr>
<tr>				<td valign="top" align="left" colspan="3"  >Comments :
				<br><textarea name="comment"  style="height: 177px; width: 660px">Enter comments here...</textarea></td>
</tr>
	        

			
			
		</table>
		<p />
		<input type="submit" value="Submit" />
	</form>	    
		

		</div>
</body>
</html>