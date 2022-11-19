package CakeShop;

import java.util.*;
import java.sql.SQLException;

public class CustomerMain {
	final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
    	
    	CustomerDashboard();

        // When a customer is created
        // They should be instantiated with a shopping cart object
        // The shopping cart object should take in a cake object
        // Cakes are our items and are added into the cart
        // When the info of the customer is passed in they see the cake data base items,
        // they pick items they need
        // items are added or removed from the cart
        // Check out receipt is generated.
        
        // ShoppingCart cart = new ShoppingCart();
        // ShoppingCartItem cake1 = new ShoppingCartItem("Chocolate Cake", 80000, 1);
        // ShoppingCartItem cake3 = new ShoppingCartItem("Sponge Cake", 100000, 1);
        // ShoppingCartItem cake2 = new ShoppingCartItem("Fruit Cake", 100000, 1);

        // // Adding Items to the newly made cart
        // cart.addItem(cake1);
        // cart.addItem(cake2);
        // cart.addItem(cake3);
        // cart.getItems();

        // // Adding the cart to the customer.
        // Customer me = new Customer("Izaiah", cart);

        // System.out.println(me);
        // System.out.println(cart);
        
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Welcome to our Cake Shop, where its all about flavour!!");

        System.out.println("1. Sign In");
        System.out.println("2. Sign out");

        switch (choice) {
            case 1:
                SignIn();
                break;

            case 2:
                try {
                    AddCustomerInfo();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
        }

    }

    private static void SignIn() {
        // TODO Auto-generated method stub
        // System.out.println("Enter your email: ");
        // String email = scanner.nextLine();

        // login with a password to be implemented but needs the customer table in the
        // database to include a password column
        // or add a login table that links to the customer table to store a customer's
        // email and password
        // System.out.println("Enter your password: ");
        // String password = scanner.nextLine();

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

		Customer cs = new Customer(customername, customeremail, customercontact, customeraddress);
		DatabaseConnect.AddCustomer(cs);

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

}
