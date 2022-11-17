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
        System.out.println("Admin login");
        
        //this is the method used to log admins into the system by validating the user name and password input 
        //it also takes in a scanner object as a parameter so that we can read input from the user in the console
        boolean loginValid = DatabaseConnect.LoginAdmin(scanner);
        
        if(loginValid == true) {
            AddCustomerInfo();
        }else {
        	System.exit(0);
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
		
		scanner.close();
		
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
}
