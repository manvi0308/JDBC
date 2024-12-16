package jdbcdemo;

import java.sql.*;

public class ShowRecords {
	static void showAllBooks() throws Exception{
		Connection con = GetDBConnection.getDBConnection();

		String query = "select * from bookrecord"; // query to be run
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
        System.out.printf("%-10s %-30s %-50s %-10s\n", "ID", "Author Name", "Book Name", "Quantity");

		while(rs.next()) {
			// id, author_name, book_name, quantity_available
			int id = rs.getInt("book_id");
			String author_name = rs.getString("author_name");
			String book_name = rs.getString("book_name");
			int quantity_available = rs.getInt("quantity_available");
			
            System.out.printf("%-10d %-30s %-50s %-10d\n", id, author_name, book_name, quantity_available);

		}
	}
}
