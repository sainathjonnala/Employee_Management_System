package comakeit.assessment1.employee._management.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import comakeit.assessment1.employee._management.Bean.EmployeeBean;

public class EmployeeDetails_DAO implements IOperations {

	PreparedStatement prepared_statement = null;
	ResultSet resultSet = null;
	Connection connection = null;
	ArrayList<EmployeeBean> employeeArrayList = null;
	int employees_row, departments_row;

	@Override
	public boolean addEmployee(EmployeeBean employee) throws SQLException {
		connection = (Connection) Connector.createConnection();
		prepared_statement = connection.prepareStatement(
				"insert into employees(employee_id,first_name,last_name,address,department_id,email,salary,reporting_manager) values(?,?,?,?,?,?,?,?)");
		prepared_statement.setString(1, employee.getEmployee_id());
		prepared_statement.setString(2, employee.getFirst_name());
		prepared_statement.setString(3, employee.getLast_name());
		prepared_statement.setString(4, employee.getAddress());
		prepared_statement.setString(5, employee.getDepartment_id());
		prepared_statement.setString(6, employee.getEmail());
		prepared_statement.setDouble(7, employee.getSalary());
		prepared_statement.setString(8, employee.getReporting_manager());
				employees_row = prepared_statement.executeUpdate();
		if (employees_row >= 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(EmployeeBean employee) throws SQLException {
		connection = (Connection) Connector.createConnection();
		prepared_statement = connection.prepareStatement("DELETE from employees where employee_id=?");
		prepared_statement.setString(1, employee.getEmployee_id());
		employees_row = prepared_statement.executeUpdate();
		if (employees_row >= 1) {
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<EmployeeBean> listEmployees() throws SQLException {
		connection = (Connection) Connector.createConnection();
		prepared_statement = connection.prepareStatement(" SELECT employee_id,concat(last_name,' ',first_name) as name from employees order by employee_id");
		resultSet = prepared_statement.executeQuery();
		EmployeeBean employeeDetails = null;
		employeeArrayList = new ArrayList<EmployeeBean>();
		while(resultSet.next())
		{
			employeeDetails = new EmployeeBean();
			employeeDetails.setEmployee_id(resultSet.getString(1));
			employeeDetails.setFullname(resultSet.getString(2));
			employeeArrayList.add(employeeDetails);
			
		}
		
		return employeeArrayList;
	}

	@Override
	public ArrayList<EmployeeBean> listDepartments() throws SQLException {

		connection = (Connection) Connector.createConnection();
		prepared_statement = connection.prepareStatement("select department_id,department_name from departments "
				+ "order by department_name;");
		resultSet = prepared_statement.executeQuery();
		employeeArrayList = new ArrayList<EmployeeBean>();
		EmployeeBean employeeDetails = null;
		while(resultSet.next())
		{
			employeeDetails = new EmployeeBean();
			employeeDetails.setDepartment_id(resultSet. getString(1));
			employeeDetails.setDepartment_name(resultSet. getString(2));
			employeeArrayList.add(employeeDetails);	
		}
		
		return employeeArrayList;
	}

	@Override
	public ArrayList<EmployeeBean> listEmployeesByManager(EmployeeBean employee) throws SQLException {
		connection = (Connection) Connector.createConnection();
		prepared_statement = connection.prepareStatement("SELECT employee_id,concat(last_name,' ',first_name) "
				+ "as name from employees where reporting_manager=? order by email");
		prepared_statement.setString(1, employee.getReporting_manager());
		resultSet = prepared_statement.executeQuery();
		employeeArrayList = new ArrayList<EmployeeBean>();
		EmployeeBean employeeDetails = null;
		while(resultSet.next())
		{
			employeeDetails = new EmployeeBean();
			employeeDetails.setEmployee_id( resultSet. getString(1));
			employeeDetails.setFullname( resultSet.getString(2));
			employeeArrayList.add(employeeDetails);
			
		}
		
		
		return employeeArrayList;
	}

	@Override
	public EmployeeBean viewEmployeeDetails(EmployeeBean employee) throws SQLException {
		connection = (Connection) Connector.createConnection();
		prepared_statement = connection.prepareStatement("select concat(last_name,' ',first_name) as name,"
				+ "department_id,address,email,reporting_manager,"
				+ "salary,"
				+ "salary*(5/100) as PF "
				+ "from employees "
				+ "where employee_id=?");
		prepared_statement.setString(1, employee.getEmployee_id());
		resultSet = prepared_statement.executeQuery();
		if(resultSet.next())
		{
			employee.setFullname(resultSet.getString(1));
			employee.setDepartment_id(resultSet.getString(2));
			employee.setAddress(resultSet.getString(3));
			employee.setEmail(resultSet.getString(4));
			employee.setReporting_manager(resultSet.getString(5));	
			employee.setSalary(resultSet.getDouble(6));
			employee.setPF(resultSet.getDouble(7));	
		}else return null;
		return employee;
		
	}

	@Override
	public ArrayList<EmployeeBean> listEmployeesBySalary()throws SQLException {
		
		connection = (Connection) Connector.createConnection();
		prepared_statement = connection.prepareStatement("SELECT concat(last_name,' ',first_name) as name,employee_id,salary from employees where salary between 10000 and 20000;");
		resultSet = prepared_statement.executeQuery();
		employeeArrayList = new ArrayList<EmployeeBean>();
		EmployeeBean employeeDetails = null;
		while(resultSet.next())
		{
			
			employeeDetails = new EmployeeBean();
			employeeDetails.setFullname( resultSet.getString(1));
			employeeDetails.setEmployee_id( resultSet. getString(2));
			employeeDetails.setSalary(resultSet.getDouble(3));
			employeeArrayList.add(employeeDetails);
			
		}
			
		return employeeArrayList;
	}

}
