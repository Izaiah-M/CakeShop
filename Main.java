package CakeShop;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws SQLException {
        System.out.println("I know you love cakes");
        
//        Login password = new Login();
//        Scanner scanner = new Scanner(System.in);
//        String userName = "Izaiah";
////        String password = "1234";
//        
//        System.out.print("Enter User Name: ");
//        String name=scanner.next();
//        
//        System.out.print("Enter Password: ");
//        String pass = scanner.next();
//        
//        if(userName.equals(name)) {
//        	if(password.equals(pass)) {
//        		System.out.println("Welcome!!");
//        	}else {
//        		System.out.println("Please Check Password");
//        	}
//        }else {
//        	System.out.println("Please Check user Name");
//        }
//        scanner.close();
        
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
