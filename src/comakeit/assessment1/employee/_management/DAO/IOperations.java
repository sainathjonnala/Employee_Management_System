package comakeit.assessment1.employee._management.DAO;
import java.sql.SQLException;
import java.util.ArrayList;

import comakeit.assessment1.employee._management.Bean.EmployeeBean;

public interface IOperations {

	public boolean addEmployee(EmployeeBean employee)throws SQLException;
	public boolean deleteEmployee(EmployeeBean employee)throws SQLException;
	public ArrayList<EmployeeBean> listEmployees()throws SQLException;
	public ArrayList<EmployeeBean> listDepartments()throws SQLException;
	public ArrayList<EmployeeBean> listEmployeesByManager(EmployeeBean employee)throws SQLException;
	public EmployeeBean viewEmployeeDetails(EmployeeBean employee)throws SQLException;
	public ArrayList<EmployeeBean> listEmployeesBySalary()throws SQLException;
}
