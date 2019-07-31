<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Operations</title>
<script type="text/javascript">
//var email= document.getElementById("email");
	function myfunction(email) {
	
			var mailformat = /^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/
			if (email.value.match(mailformat)) {
				return true
			}	
			else {
				document.getElementById("demo").innerHTML = " Enter email in correct format "
				return false
			}
		}
</script>


</head>
<body>

<%String action = request.getParameter("action");
if(action.equals("create")){ %>

<form action = "Redirect?action=create" method="post" onsubmit="return myfunction(email)">
<p>Employee Details:</p><br/> 
<p id="demo"></p>
Enter Last Name:
<input type = "text" name="lastname"/><br/> 
Enter Fist Name:
<input type="text" name="firstname"/><br/> 
Enter Employee ID:
<input type="text"  name="employeeID"/><br/> 
Enter Email:
<input type="text"  name="email"/><br/> 
Enter Department ID:
<input type="text" name="departmentID"/><br/>
Enter address:
<input type="text" name="address" /><br/>
Enter salary:
<input type="text" name="salary" /><br/>
Enter Reporting Manager:
<input type="text" name="reportingManager" /><br/>
<br/>
<input type ="submit" name="submit" value="create">
</form>


<% } else if(action.equals("delete")) {%>
<form action="Redirect?action=delete" method="post">
<p>Enter the Employee to delete from records: </p>
<input type="text" name="employeeID"/><br>
<br>
<input type="submit" name="action" value="delete"/>
</form>


<% } else if(action.equals("viewEmployeesofSpecificManager")) {%>
<form action="Redirect?action=viewEmployeesofSpecificManager" method="post">
<p>Enter the Reporting Manager:</p> 
<input type="text" name="managerName"/><br>
<br>
<input type="submit" name="action" value="viewEmployeesofSpecificManager"/>
</form>


<% } else if(action.equals("viewEmployeeDetails")) {%>
<form action="Redirect?action=viewEmployeeDetails" method="post">
<p>Enter the EmployeeID : </p> 
<input type="text" name="employeeID"/><br>
<br>
<input type="submit" name="action" value="viewEmployeeDetails"/>
</form>


<% }  %>

</body>
</html>