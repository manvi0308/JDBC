package jdbcdemo;

import java.sql.*;

public class InsertNewBookToDB {
	static void insertBook(int id, String bookName, String authorName, int quantity) throws Exception {
	
		Connection con = GetDBConnection.getDBConnection();
		String query = "insert into bookrecord values(?, ?,?, ?)"; // query to be run
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setLong(1, id);
		pstmt.setString(2, bookName);
		pstmt.setString(3, authorName);
		pstmt.setLong(4, quantity);
		pstmt.executeUpdate();
	}
}
