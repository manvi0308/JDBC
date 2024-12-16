package jdbcdemo;
import java.sql.*;

public class StudentBorrowedBooksUpdates {
	static void modifyBorrowedBooksTable(int studentId, String bookName, boolean flag) throws Exception {
		// flag == true for borrow
		// flag == false for return
		int bookId = GetBookDetails.getBookID(bookName);
		Connection con = GetDBConnection.getDBConnection();
		if(flag == true) {
			// borrow
			String updateBookRecordTableQuery 
			= "Insert into borrowed_books(student_id, book_id) values(?, ?)";
			PreparedStatement ps = con.prepareStatement(updateBookRecordTableQuery);
			ps.setLong(1, studentId);
			ps.setLong(2, bookId);
			ps.execute();
		}
		else {
			// return
			String updateBookRecordTableQuery 
			= "DELETE from borrowed_books where (book_id=? and student_id=?)";
			PreparedStatement ps = con.prepareStatement(updateBookRecordTableQuery);
			ps.setInt(1, bookId);
			ps.setInt(2, studentId);
			ps.executeUpdate();
		}
	}
	static void studentBorrowedABook(int studentID, String bookName) throws Exception{
		// Add record to borrowed_books table
		modifyBorrowedBooksTable(studentID, bookName, true);
		// Decrease the book quantity
		GetBookDetails.updateBookQuantity(bookName, false);
	}

	static void studentReturnedBook(int studentID, String bookName) throws Exception {
		// Delete record to borrowed_books table
		// java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax;
		// check the manual that cor
		//responds to your MySQL server version for the right syntax to use near '? 
		// and student_id=?' at line 1
		modifyBorrowedBooksTable(studentID, bookName, false);
		// Increase the book quantity
		GetBookDetails.updateBookQuantity(bookName, true);
	}
}
