package jdbcdemo;
import java.sql.*;

import java.io.*;
public class First {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url
        = "jdbc:mysql://localhost:3306/manvi?useSSL=false"; // db name - manvi
    String username = "root"; // MySQL user name
    String password = "Shiva@12"; // password
    String query
        = "describe student"; // query to be run
    Class.forName(
        "com.mysql.cj.jdbc.Driver"); // Driver name
    Connection con = DriverManager.getConnection(
        url, username, password);
    System.out.println(
        "Connection Established successfully");
    Statement st = con.createStatement();
    ResultSet rs
        = st.executeQuery(query); // Execute query
    rs.next();
    
    st.close(); // close statement
    con.close(); // close connection
    System.out.println("Connection Closed....");
	}

}
