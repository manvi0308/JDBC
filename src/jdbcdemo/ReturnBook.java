package jdbcdemo;

import java.util.*;

public class ReturnBook {
	static void returnBook() throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter student id ");
		int studentId = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter book name ");
		String bookName = sc.nextLine().trim();

		// Increase the quantity
		GetBookDetails.updateBookQuantity(bookName, true);
		
		
		// Delete the record from students table
		StudentBorrowedBooksUpdates.studentReturnedBook(studentId, bookName);
		sc.close();
	}
	
}
