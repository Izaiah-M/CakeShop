package CakeShop;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws SQLException {
        System.out.println("I know you love cakes");
        
        
        
        DatabaseConnect.LoginAdmin();
        AddCustomerInfo();
    }
	
	public static void AddCustomerInfo() throws SQLException {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to our Cake Shop");
		
		System.out.println("Enter your name:");
		String name = input.nextLine();
		
		System.out.println("Enter your email:");
		String email = input.nextLine();
		
		System.out.println("Enter your contact:");
		int contact = input.nextInt();
		input.nextLine();
		
		System.out.println("Enter your address:");
		String address = input.nextLine();
		
		Customer cs = new Customer(name,email,contact,address);
		DatabaseConnect.AddCustomer(cs);
		
		input.close();
		
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
}
