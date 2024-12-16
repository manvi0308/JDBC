package jdbcdemo;
import java.sql.*;
public class GetDBConnection {
	static Connection getDBConnection() throws Exception {
		String url = "jdbc:mysql://localhost:3306/manvi?allowPublicKeyRetrieval=true&useSSL=false"; // db name - manvi
		String username = "root";
		String password = "Shiva@12"; 
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		Connection con = DriverManager.getConnection(url, username, password);
		return con;
	}
}
