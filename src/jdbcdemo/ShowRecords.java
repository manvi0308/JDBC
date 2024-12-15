package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ShowRecords {
	static void showAllBooks() throws Exception{
		String url = "jdbc:mysql://localhost:3306/manvi?allowPublicKeyRetrieval=true&useSSL=false"; // db name - manvi
		String username = "root";
		String password = "Shiva@12"; 
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		Connection con = DriverManager.getConnection(url, username, password);
		String query = "select * from bookrecord"; // query to be run
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
        System.out.printf("%-10s %-30s %-50s %-10s\n", "ID", "Author Name", "Book Name", "Quantity");

		while(rs.next()) {
			// id, author_name, book_name, quantity_available
			int id = rs.getInt("id");
			String author_name = rs.getString("author_name");
			String book_name = rs.getString("book_name");
			int quantity_available = rs.getInt("quantity_available");
			
            System.out.printf("%-10d %-30s %-50s %-10d\n", id, author_name, book_name, quantity_available);

		}
	}
}
