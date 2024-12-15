package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReturnBook {
	static void returnBook(String bookName) throws Exception {

		String url = "jdbc:mysql://localhost:3306/manvi?allowPublicKeyRetrieval=true&useSSL=false"; // db name - manvi
		String username = "root";
		String password = "Shiva@12";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);

		System.out.println("Fetching details of book " + bookName);
		// ? represents that values will be inserted dynamically
		String query = "select quantity_available from bookrecord where book_name= ? "; // query to be run

		// difference comes here
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, bookName);
		ResultSet rs = pstmt.executeQuery();

		System.out.println("Search Results for Book Name: " + bookName);
		while (rs.next()) {
			int quantityAvailable = rs.getInt("quantity_available");

			String updateQuery = "UPDATE bookrecord SET quantity_available=? where book_name=?";
			PreparedStatement pstmt2 = con.prepareStatement(updateQuery);
			pstmt2.setLong(1, quantityAvailable + 1);
			pstmt2.setString(2, bookName);
			pstmt2.executeUpdate();
			System.out.println("1 copy of book returned");

		}

	}
}
