package CakeShop;

import java.sql.SQLException;
import java.util.*;

//this class contains the admin user flow, from signing in to adding and removing
//items from the database
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
			
			//this is the admin menu which shows the admin the different activities that they can perform
			System.out.println("What would you like to do?");
			System.out.println("1. Add Cake to database");
			System.out.println("2. Remove Cake from database");
			System.out.println("3. Product Report");
			System.out.println("4. Sales report");
			System.out.println("5. Logout");
			int answer = scanner.nextInt();
			scanner.nextLine();

			switch (answer) {
				case 1:
					//used to add a cake to the database
					DatabaseConnect.AddCake(scanner);
					break;

				case 2:
					//used to remove a cake from the database 
					DatabaseConnect.RemoveCake(scanner);
					break;

				case 3:
					//used to show the items currently in the database
					DatabaseConnect.ProductReport();
					break;

				case 4:
					//used to show the sales that have been made in the cake shop
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
