package CakeShop;

import java.sql.SQLException;
import java.util.*;

public class AdminMain {
	static final Scanner scanner = new Scanner(System.in);
	// create one single static scanner object to be used throughout the whole
	// program
	// this is done to prevent the input streams from closing and bringing errors.
	// the scanner object is then passed as an argument to the method calls where it
	// is going to be used

	// Made this main class to handle administration operations

	public static void main(String[] args) throws SQLException {
		System.out.println("Welcome Administrator, Login!!");

		AdminDashboard();

	}

	public static void AdminDashboard() throws SQLException {

		System.out.println("Admin login");
		// this is the method used to log admins into the system by validating the user
		// name and password input
		// it also takes in a scanner object as a parameter so that we can read input
		// from the user in the console
		
		boolean loginValid;
		do {
		loginValid = DatabaseConnect.LoginAdmin(scanner);

		if (loginValid == true) {
			System.out.println("Admin menu");

			System.out.println("What would you like to do?");
			System.out.println("1. Add Cake to database");
			System.out.println("2. Remove Cake from database");
			System.out.println("3. Product Report");
			System.out.println("4. Sales report");
			System.out.println("5. Logout of database");
			int answer = scanner.nextInt();
			scanner.nextLine();

			switch (answer) {
				case 1:
					DatabaseConnect.AddCake(scanner);
					break;

				case 2:
					DatabaseConnect.RemoveCake(scanner);
					break;

				case 3:
					DatabaseConnect.ProductReport();
					break;

				case 4:
					DatabaseConnect.SalesReport();
					break;

				case 5:
					break;
			}

		} else {
			System.out.println("Please enter the correct credentials.");

		}
		
		}while(loginValid == false);

	}


}
