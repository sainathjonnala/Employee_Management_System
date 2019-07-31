<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body>
<%String error = request.getParameter("error");
if(error.equals("create")){ %>
<%= "error in creation" %>
<% }else if(error.equals("login")){ %>
<%="Invalid Credentials" %>
<a href="login.jsp">Try Again</a>
<% }else if(error.equals("delete")) { 
	out.println("<h4>Enter valid Employee_ID</h4>");
	out.println("<a href=\"EmployeeOperations.jsp?action=delete\">Go Back</a> ");
}else if(error.equals("viewEmployeesofSpecificManager"))
		{
	out.println("<h4>Enter valid Manager name</h4>");
	out.println("<a href=\"EmployeeOperations.jsp?action=viewEmployeesofSpecificManager\">Go Back</a> ");
		}
else if(error.equals("viewEmployeeDetails"))
{
out.println("<h4>No Employee Found!! Try Again!! </h4>");
out.println("<a href=\"EmployeeOperations.jsp?action=viewEmployeeDetails\">Go Back</a> ");
}


%>
</body>
</html>