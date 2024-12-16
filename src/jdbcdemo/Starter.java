package jdbcdemo;
import java.util.*;
public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Library Management System");

		System.out.println("Please choose what you want to do");
		System.out.println("1. Display all the books");
		System.out.println("2. Borrow a Book");
		System.out.println("3. Return a Book");
		System.out.println("4. Insert a Book");
		System.out.println("5. Show all the books issued to a Student");
		Scanner sc = new Scanner(System.in);

		int option = sc.nextInt();
		sc.nextLine();
		switch (option) {
		case 1:
			try {
				ShowRecords.showAllBooks(); // WORKING FINE
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 2:
			try {
				BorrowBook.borrowBook(); // WORKS FINE
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			
			try {
				ReturnBook.returnBook(); // WORKING FINE
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 4:
			System.out.println("Enter the following details");
			System.out.println("Enter the id");

			int id = sc.nextInt();
			System.out.println("Enter the author name");

			String authorName = sc.nextLine().trim();
			System.out.println("Enter the book name");

			String bookName = sc.nextLine().trim();
			int quantity = sc.nextInt();
			try {
				InsertNewBookToDB.insertBook(id, bookName, authorName, quantity);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		default:
			System.out.println("Case default");
			break;

		}

		sc.close();

	}

}
