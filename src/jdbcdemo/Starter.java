package jdbcdemo;
import java.util.*;
public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Library Management System");
	
		System.out.println("Please choose what you want to do");
		System.out.println("1. Show all the books");
		System.out.println("2. Borrow a book");
		System.out.println("3. Return a book");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		sc.nextLine();
		switch (option) {
		case 1:
			try {
				ShowRecords.showAllBooks();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 2:
			System.out.println("Give me the book name to borrow");
			String borrowBookName = sc.nextLine().trim();
			if (!borrowBookName.isEmpty()) {
				try {
					BorrowBook.borrowBook(borrowBookName);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			break;
		case 3:
			System.out.println("Give me the book name to return ");
			String returnBookName = sc.nextLine().trim();
			try {
				ReturnBook.returnBook(returnBookName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			System.out.println("Case default");
			break;

		}

		sc.close();
		
	}

}
