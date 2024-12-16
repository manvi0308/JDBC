package jdbcdemo;
import java.sql.*;

public class GetBookDetails {

	static int getBookID(String bookName) throws Exception {
		Connection con = GetDBConnection.getDBConnection();
		String query = "SELECT book_id from bookrecord where book_name=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, bookName);
		ResultSet rs = pstmt.executeQuery();
		int bookID = 0;
		while (rs.next()) {
			bookID = rs.getInt("book_id");
		}
		con.close();

		return bookID;
	}
	
	static int getBookQuantity(String bookName) throws Exception {
		Connection con = GetDBConnection.getDBConnection();
		String query = "SELECT quantity_available from bookrecord where book_name=?";
		
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, bookName);
		ResultSet rs = pstmt.executeQuery();
		int bookQuantity = 0;
		while (rs.next()) {
			bookQuantity = rs.getInt("quantity_available");
		}
		con.close();

		return bookQuantity;
	}
	
	static void updateBookQuantity(String bookName, boolean flag) throws Exception {
		// flag = true for increase
		// flag = false for decrease
		Connection con = GetDBConnection.getDBConnection();
		int qtyAvailable = getBookQuantity(bookName);
		int bookId = getBookID(bookName);
		String updateBookQtyQuery = "UPDATE bookrecord SET quantity_available=? where book_id=?";
		PreparedStatement pstmt = con.prepareStatement(updateBookQtyQuery);
		if (flag == true)
			pstmt.setLong(1, qtyAvailable + 1);
		else {
			pstmt.setLong(1, qtyAvailable - 1);
		}
		pstmt.setLong(2, bookId);
		int m = pstmt.executeUpdate();
		if(m == 0) {
			System.out.println("Book quantity updated");
		}
		con.close();
	}
}
