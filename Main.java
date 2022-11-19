package CakeShop;

import java.sql.SQLException;
import java.util.*;

public class Main {
	static final Scanner scanner = new Scanner(System.in);
	//create one single static scanner object to be used throughout the whole program
	//this is done to prevent the input streams from closing and bringing errors.
	//the scanner object is then passed as an argument to the method calls where it is going to be used

	public static void main(String[] args) throws SQLException {
        System.out.println("I know you love cakes");
        System.out.println("For admins,enter 1");
        System.out.println("For customers,enter 2");
        int choice = 0;
        choice = scanner.nextInt();
        scanner.nextLine();
        
        switch(choice) {
        case 1:
        	AdminDashboard();
        	break;
        	
        case 2:
        	CustomerDashboard();
        	break;
   
        	
        }
 
    }
	
	public static void AddCustomerInfo() throws SQLException {
		
		System.out.println("Welcome to our Cake Shop");
		
		System.out.println("Enter your name:");
		String customername = scanner.nextLine();
		
		System.out.println("Enter your email:");
		String customeremail = scanner.nextLine();
		
		System.out.println("Enter your contact:");
		int customercontact = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter your address:");
		String customeraddress = scanner.nextLine();
		
		Customer cs = new Customer(customername,customeremail,customercontact,customeraddress);
		DatabaseConnect.AddCustomer(cs);
		
		
	}
	
	public static void AdminDashboard() throws SQLException {
	       System.out.println("Admin login");
	        //this is the method used to log admins into the system by validating the user name and password input 
	        //it also takes in a scanner object as a parameter so that we can read input from the user in the console
	        boolean loginValid = DatabaseConnect.LoginAdmin(scanner);
	        
	        
	        if(loginValid == true) {
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

	        }else {
	        	System.out.println("Please enter the correct credentials.");
	        
	        }
	        
	        
	}
	
	public static void CustomerDashboard() throws SQLException {
		System.out.println("Welcome to our Cake shop");
		System.out.println("1.Sign Up");
		System.out.println("2.Sign In");
		int choice = scanner.nextInt();
		scanner.nextLine();
		
		switch (choice) {
		case 1:
	        AddCustomerInfo();
	        break;
	        
		case 2:
			SignIn();
			
			
			
			
			
			
			
			break;
		
		

		
		
		
		}
		
		
	}

	private static void SignIn() {
		// TODO Auto-generated method stub
//		System.out.println("Enter your email: ");
//		String email = scanner.nextLine();
		
		//login with a password to be implemented but needs the customer table in the database to include a password column
		//or add a login table that links to the customer table to store a customer's email and password
//		System.out.println("Enter your password: ");
//		String password = scanner.nextLine();
		
		
		
	}
}


