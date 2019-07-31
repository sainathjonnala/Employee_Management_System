package comakeit.assessment1.employee._management.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import comakeit.assessment1.employee._management.Bean.AdminBean;

public class AdminValidation_DAO {
	PreparedStatement prepared_statement = null;
	ResultSet resultSet = null;
	Connection connection = null;
	
	
	public boolean isValidAdmin(AdminBean adminBean) throws SQLException
	{
		connection = Connector.createConnection();
		prepared_statement = connection.prepareStatement("select username from admin where username=? and password=?");
		prepared_statement.setString(1, adminBean.getUsername());
		prepared_statement.setString(2, adminBean.getPassword());
		resultSet = prepared_statement.executeQuery();

		if(resultSet.next()) {
			return true;
		}
		return false;
	}
}
