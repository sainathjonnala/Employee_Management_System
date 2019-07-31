package comakeit.assessment1.employee._management.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comakeit.assessment1.employee._management.Bean.EmployeeBean;
import comakeit.assessment1.employee._management.DAO.EmployeeDetails_DAO;
import comakeit.assessment1.employee._management.DAO.IOperations;

@WebServlet("/Redirect")
public class Redirect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Redirect() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<EmployeeBean> employeeArrayList = null;
		HttpSession session = request.getSession();
		EmployeeBean employee = null;

		EmployeeDetails_DAO employeeDAO = new EmployeeDetails_DAO();
		RequestDispatcher requestDispatcher = null;

		String operation = request.getParameter("action");
		if (operation != null)
			switch (operation) {
			case "create":
				employee = new EmployeeBean();
				employee.setLast_name((String) request.getParameter("lastname"));
				employee.setFirst_name((String) request.getParameter("firstname"));
				employee.setEmployee_id((String) request.getParameter("employeeID"));
				employee.setEmail((String) request.getParameter("email"));
				employee.setAddress((String) request.getParameter("address"));
				employee.setReporting_manager((String) request.getParameter("reportingManager"));
				employee.setSalary(Double.parseDouble(request.getParameter("salary")));
				employee.setDepartment_id((String) request.getParameter("departmentID"));
				try {

					if (employeeDAO.addEmployee(employee) == true) {
						session.setAttribute("employee", employee);
						requestDispatcher = request.getRequestDispatcher("ResultPage.jsp?result=create");
						requestDispatcher.forward(request, response);
					}
					else{
						requestDispatcher = request.getRequestDispatcher("ErrorPage.jsp?error=create");
						requestDispatcher.forward(request, response);
					}
				} catch (Exception sqlException) {
					sqlException.printStackTrace();
//					requestDispatcher = request.getRequestDispatcher("ErrorPage.jsp?error=create");
//					requestDispatcher.forward(request, response);
				}
				break;

			case "delete":
				employee = new EmployeeBean();
				employee.setEmployee_id((String) request.getParameter("employeeID"));
				try {

					if (employeeDAO.deleteEmployee(employee)) {

						session.setAttribute("employee", employee);
						requestDispatcher = request.getRequestDispatcher("ResultPage.jsp?result=delete");
						requestDispatcher.forward(request, response);
					} else {
						requestDispatcher = request.getRequestDispatcher("ErrorPage.jsp?error=delete");
						requestDispatcher.forward(request, response);
					}
				} catch (Exception sqlException) {
					sqlException.printStackTrace();
				}
				break;
			case "viewEmployees":
				try {
					employeeArrayList = employeeDAO.listEmployees();
					session.setAttribute("employeeArrayList", employeeArrayList);
					if (!employeeArrayList.isEmpty()) {
						requestDispatcher = request.getRequestDispatcher("ResultPage.jsp?result=viewEmployees");
						requestDispatcher.forward(request, response);
					}
				} catch (Exception sqlException) {
					sqlException.printStackTrace();
				}
				break;
			case "viewDepartments":
				try {

					employeeArrayList = employeeDAO.listDepartments();
					session.setAttribute("employeeArrayList", employeeArrayList);
					requestDispatcher = request.getRequestDispatcher("ResultPage.jsp?result=viewDepartments");
					requestDispatcher.forward(request, response);
				} catch (Exception sqlException) {
					sqlException.printStackTrace();
				}
				break;
			case "viewEmployeesofSpecificManager":
				try {
					employee = new EmployeeBean();
					employee.setReporting_manager((String) request.getParameter("managerName"));
					
					employeeArrayList = employeeDAO.listEmployeesByManager(employee);
					
					session.setAttribute("employeeArrayList", employeeArrayList);
					session.setAttribute("employee", employee);
				
					if(!employeeArrayList.isEmpty()) {
						requestDispatcher = request.getRequestDispatcher("ResultPage.jsp?result=viewEmployeesofSpecificManager");
						requestDispatcher.forward(request, response);

					}
					
					else {
						requestDispatcher = request.getRequestDispatcher("ErrorPage.jsp?error=viewEmployeesofSpecificManager");
						requestDispatcher.forward(request, response);
					}
						
				} catch (Exception sqlException) {
					sqlException.printStackTrace();
				}
				break;
			case "viewEmployeeDetails":
				try {
					employee = new EmployeeBean();
					employee.setEmployee_id((String) request.getParameter("employeeID"));
					employee = employeeDAO.viewEmployeeDetails(employee);
					session.setAttribute("employee", employee);
					if(employee != null) {
					requestDispatcher = request.getRequestDispatcher("ResultPage.jsp?result=viewEmployeeDetails");
					requestDispatcher.forward(request, response);
					}
					else
					{
						requestDispatcher = request.getRequestDispatcher("ErrorPage.jsp?error=viewEmployeeDetails");
						requestDispatcher.forward(request, response);
					}
				} catch (Exception sqlException) {
					sqlException.printStackTrace();
				}
				break;
			case "listEmployeesBySalary":
				try {
					employeeArrayList = employeeDAO.listEmployeesBySalary();
					session.setAttribute("employeeArrayList", employeeArrayList);
					requestDispatcher = request.getRequestDispatcher("ResultPage.jsp?result=listEmployeesBySalary");
					requestDispatcher.forward(request, response);
				} catch (Exception sqlException) {
					sqlException.printStackTrace();
				}
				break;

			}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
