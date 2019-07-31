package comakeit.assessment1.employee._management.DAO;

import java.sql.*;

public class Connector {
	public static Connection createConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management?autoReconnect=true&useSSL=false"
					, "root", "root");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
