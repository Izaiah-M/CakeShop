package CakeShop;

import java.sql.SQLException;
import java.util.*;

public class Main {
	static final Scanner scanner = new Scanner(System.in);

	
	public static void main(String[] args) throws SQLException {
        System.out.println("I know you love cakes");
        System.out.println("Admin login");
        
        //this is the method used to log admins into the system by validating the username and password input 
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
