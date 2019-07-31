<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="comakeit.assessment1.employee._management.Bean.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results Page</title>
<style>
table {
    display: table;
    border-collapse: separate;
    border-spacing: 2px;
    border-color: grey;
}

th {
    /*color: #bfc83e;*/
    /* better */
    color: #E4F1F6;
    text-align: left;
    padding: 8px;
    background-color: #034F85;
}

td {
    text-align: left;
    padding: 8px;
    background-color: #1A3E4C;
    color: white;
}


tr {
    color: black;
}
</style>

<script>
function goBack() {
  window.history.back();
}
</script>

</head>
<body>
	<%String result = request.getParameter("result");
EmployeeBean employee = (EmployeeBean)session.getAttribute("employee"); 
ArrayList<EmployeeBean> employeeArrayList = (ArrayList<EmployeeBean>)session.getAttribute("employeeArrayList"); %>
<table style="width:100%">
	<%if(result.equals("create")){ %>
	<%="Employee Created " +  employee.getEmployee_id() %>
	<a href="AdminOperations.jsp">Goto HomePage</a>
	<%}else if(result.equals("delete")){ %>
	<%="Employee Deleted " +  employee.getEmployee_id() %>
		<a href="AdminOperations.jsp">Goto HomePage</a>
	<% }
else if(result.equals("viewEmployees")){	
	out.println("<th>Employee ID </th><th>Employee Name</th>");
	for(EmployeeBean itr : employeeArrayList){	
		 out.println("<tr><td>"+ itr.getEmployee_id()+" </td>");
	 out.println("<td>"+ itr.getFullname()+"</td></tr>");
	
	} %>
	<a href="javascript:goBack()">go back</a>
<%  }
else if(result.equals("viewDepartments")){
	out.println("<th>Department ID</th><th>Department Name</th>");
	for(EmployeeBean itr : employeeArrayList){
		out.println("<tr><td>"+ itr.getDepartment_id() +"</td><td>"+ itr.getDepartment_name()+"</td></tr>");
	}
	
}
	else if(result.equals("viewEmployeesofSpecificManager")){
		out.println("<h3>Reporting Manager: "+ employee.getReporting_manager()+"</h3>");
		out.println("<th>Employee ID </th><th>Employee Name</th>");
		for(EmployeeBean itr : employeeArrayList){
			out.println("<tr><td>"+ itr.getEmployee_id()+"</td><td> "+itr.getFullname()+
					"</td></tr>");
		}
	}
	else if(result.equals("viewEmployeeDetails")){ %>
	<%="<th>Employee ID</th><th>Employee Name</th><th>Employee Department</th><th>Employee Salary</th><th>PF</th>" %>	
	<%="<tr><td>"+employee.getEmployee_id()+"</td><td>"+employee.getFullname()+"</td><td>"+employee.getDepartment_id()
	+"</td><td>"+employee.getSalary()+"</td><td>"+employee.getPF()+"</td></tr>" %>

			
		
	<% }
	else if(result.equals("listEmployeesBySalary")){
		out.println("<h3>Employees List Whose Salary between 10000 and 20000</h3>");
		out.println("<th>Employee ID </th><th>Employee Name</th><th>Employee Salary</th>");
		for(EmployeeBean itr : employeeArrayList){
			out.println("<tr><td>"+ itr.getEmployee_id()+"</td><td> "+itr.getFullname()+"</td><td>"+itr.getSalary()+"</td></tr>");
		}
	}
	
	%>
	</table>
</body>
</html>