package Jdbc.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcMysqlConnection {

	private Connection Connect;
	
	public JdbcMysqlConnection(String dbURL, String username, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		this.Connect = DriverManager.getConnection(dbURL, username, password);
	}
	public Connection getConnection() {
		return this.Connect;
	}
	public void closeConnection() throws SQLException {
		this.Connect.close();
	}
}
//type "localhost:8088/Jdbc1/init"