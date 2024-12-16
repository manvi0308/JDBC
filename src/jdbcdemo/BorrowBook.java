package jdbcdemo;

import java.util.*;
public class BorrowBook {
	static void borrowBook() throws Exception {
		Scanner sc = new Scanner(System.in);
		// java.sql.SQLSyntaxErrorException: Unknown column 'student_id' in 'field list'
		
		System.out.println("Enter id of student");
		int studentId = sc.nextInt();
		sc.nextLine();
		
		// Valid student id
		if (studentId >= 1 && studentId <= 30) {
			System.out.println("Enter the book name");
			String bookName = sc.nextLine().trim();

			StudentBorrowedBooksUpdates.studentBorrowedABook(studentId, bookName);

		}
		sc.close();
	}
}
