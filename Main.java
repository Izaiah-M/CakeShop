package cakeShop;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
        System.out.println("I know you love cakes");
        
        Login password = new Login();
        Scanner scanner = new Scanner(System.in);
        String userName = "Izaiah";
        String password = "1234";
        
        System.out.print("Enter User Name: ");
        String name=scanner.next();
        
        System.out.print("Enter Password: ");
        String pass = scanner.next();
        
        if(userName.equals(name)) {
        	if(password.equals(pass)) {
        		System.out.println("Welcome!!");
        	}else {
        		System.out.println("Please Check Password");
        	}
        }else {
        	System.out.println("Please Check user Name");
        }
        
    
        
    }
	
}
