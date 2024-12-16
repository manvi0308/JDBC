package jdbcdemo;
import java.sql.*;
public class GetDBConnection {
	static Connection getDBConnection() throws Exception {
		String url = "jdbc:mysql://localhost:3306/manvi?allowPublicKeyRetrieval=true&useSSL=false"; // db name - manvi
		String username = ""; // Your DB Username
		String password = "";  // Your DB Password
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		Connection con = DriverManager.getConnection(url, username, password);
		return con;
	}
}
