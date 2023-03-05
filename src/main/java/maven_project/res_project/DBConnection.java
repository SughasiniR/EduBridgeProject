package maven_project.res_project;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	static Connection connection;
	public static Connection dbConnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/resproject","root","root");
		return connection;
	}
}
