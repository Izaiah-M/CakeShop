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
        
        switch(choice) {
        case 1:
        	AdminDashboard();
        	
        case 2:
        	AddCustomerInfo();
   
        	
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
		        
		        switch (answer) {
		        	case 1:
		        		DatabaseConnect.AddCake(scanner);
		        	
		        	case 2:
//		        		DatabaseConnect.RemoveCake(scanner);
		        		
		        	case 3:
//		        		DatabaseConnect.ProductReport();
		        		
		        	case 4:
//		        		DatabaseConnect.SalesReport();
		        		
		        	case 5:
		        		break;
		        }

	        }else {
	        	System.out.println("Please enter the correct credentials.");
	        
	        }
	        
	        
	}
	
	public static void CustomerDashboard() throws SQLException {
        AddCustomerInfo();

	}
}


