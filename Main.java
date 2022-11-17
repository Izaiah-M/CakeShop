package CakeShop;

import java.sql.SQLException;
import java.util.*;

public class Main {
<<<<<<< HEAD
<<<<<<< HEAD

    public static void main(String[] args) {
        System.out.println("I know you love cakes");

        // Login password = new Login();
        // Scanner scanner = new Scanner(System.in);
        // String userName = "Izaiah";
        // String password = "1234";

        // System.out.print("Enter User Name: ");
        // String name=scanner.next();

        // System.out.print("Enter Password: ");
        // String pass = scanner.next();

        // if(userName.equals(name)) {
        // if(password.equals(pass)) {
        // System.out.println("Welcome!!");
        // }else {
        // System.out.println("Please Check Password");
        // }
        // }else {
        // System.out.println("Please Check user Name");
        // }

    }

=======
	
=======
	static final Scanner scanner = new Scanner(System.in);
	//create one single static scanner object to be used throughout the whole program
	//this is done to prevent the input streams from closing and bringing errors.
	//the scanner object is then passed as an argument to the method calls where it is going to be used

>>>>>>> d67dc143f802ca921f56ebecb6dc2e1e944fd103
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


	
	
	
	
	
	
	
	
	
	
	
	
	
>>>>>>> 191405e13453e7a86bfd4b264c3c0ed4022eaf76
}
