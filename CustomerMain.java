package CakeShop;

import java.util.Scanner;
import java.sql.SQLException;

public class CustomerMain {
    final static Scanner scanner = new Scanner(System.in);
    protected static Customer customer;
    protected static Sales sale;

    public static void main(String[] args) throws SQLException {

        CustomerDashboard();

        // When a customer is created
        // They should be instantiated with a shopping cart object DONE
        // The shopping cart object should take in a cake object DONE
        // Cakes are our items and are added into the cart DONE
        // When the info of the customer is passed in they see the cake data base items,
        // DONE
        // they pick items they need
        // items are added or removed from the cart
        // Check out receipt is generated.

    }

    private static boolean SignIn() throws SQLException {
        // login with a password to be implemented but needs the customer table in the
        // database to include a password column DONE

        Login login = new Login();

        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        login.setEmail(email);
        login.setPassword(password);

        // the DatabaseConnect.CustomerSignIn() method returns a customer object
        // we will access the shopping cart of this customer object later on when the
        // customer is ordering
        customer = DatabaseConnect.CustomerSignIn(login);

        if (customer != null) {
            return true;
        }
        return false;
    }

    public static Customer AddCustomerInfo() throws SQLException {

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

        System.out.println("Enter your new password:");
        String customerpassword = scanner.nextLine();

        Customer cs = new Customer(customername, customeremail, customercontact, customeraddress, customerpassword);
        DatabaseConnect.AddCustomer(cs);

        return cs;
    }

    public static void CustomerDashboard() throws SQLException {
        System.out.println("Welcome to our Cake shop");
        System.out.println("1.Sign Up");
        System.out.println("2.Sign In");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                // this is used to add a customers, information to the database
                customer = AddCustomerInfo();
                CustomerMenu();
                break;

            case 2:
                // this is used to check for a customers information from the database
                // we keep on
                boolean signIn;
                do {
                    signIn = SignIn();
                    if (signIn == true) {
                        CustomerMenu();
                    } else {
                        System.out.println("Please sign in with the correct credentials or Sign up");
                    }
                } while (signIn == false);

                break;

        }

    }

    public static void CustomerMenu() throws SQLException {
        System.out.println("Catalog and Custom Order");
        System.out.println("Do you want to See the catalog or make a custom order");
        System.out.println("1. See Catalog");
        System.out.println("2. Make a custom Order");
        System.out.println("3. Check Your Cart\n");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                // TODO work on adding items to cart from the catalog
                CatalogInfo catalog = DatabaseConnect.GenerateCatalog();
                System.out.println("-----------------------Catalog-----------------------");
                System.out.println(catalog.getCakeList());
                // TODO implementing a function where customers can see the catalog and choose
                // an item from it and on choosing to buy that item, the item is removed from
                // the database
                // when a customer enters the id of the cake, we run the getCake method of the
                // catalog class and return that cake from the list
                // we then add that item to the shopping cart.
                System.out.println("Which Cake would you like to purchase from the catalog?(Enter the cake's Id)");
                int CakeChoice = scanner.nextInt();
                scanner.nextLine();
                Cakes answer = catalog.getCake(CakeChoice);
                if (answer == null) {
                    System.out.println("Cake not found");
                } else {
                    ShoppingCartItem cake = new ShoppingCartItem(answer);
                    customer.cart.addItem(cake);
                    System.out.println(customer.getCart());
                    // make a new sales object and then pass it to the database
                    // this is just a test to see if the cakes go to the sales database when the
                    // sale is made
                    sale = new Sales(answer);
                    DatabaseConnect.AddNewSale(sale);
                }
                break;

            case 2:
                // here the customer creates their own cake object and it is then returned from
                // the CustomerOrdering method
                Cakes CustomerOrder = CustomerOrdering();
                System.out.println(CustomerOrder);
                break;

            case 3:
                System.out.println(customer.getCart());
                break;

            default:
                break;
        }
    }

    public static Cakes CustomerOrdering() throws SQLException {
        String Ctype = null, Cflavour = null, Cdate = null, Cicing = null, Cmessage = null;
        int Cprice = 0;
        System.out.println("Enter the type of the cake i.e fruit cake, forest cake, sponge cake, basic vanilla cake");
        Ctype = scanner.nextLine();

        System.out.println("Enter the flavour of the cake e.g orange, marble , chocolate ,vanilla");
        Cflavour = scanner.nextLine();

        System.out.println("Enter the icing type of the cake i.e fondant , whipped cream , butter cream");
        Cicing = scanner.nextLine();

        System.out.println("Enter the message you want on the cake.");
        Cmessage = scanner.nextLine();

        System.out.println("Enter the price of the cake ");
        Cprice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the date when you want the cake.");
        Cdate = scanner.nextLine();

        // So here the custom order is made
        Cakes customOrder = new Cakes(Ctype, Cflavour, Cmessage, Cdate, Cicing, Cprice);

        // Then here the custom order is passed as our shopping cart Item cause remember
        // our shopping Cart Item can also take in a Cake Object
        ShoppingCartItem cake = new ShoppingCartItem(customOrder);

        // Then here, that item, is passed into the cart, our ShoppingCart takes in
        // objects of ShopppingcartItem

        customer.cart.addItem(cake);

        // i think we can return the cake that the customer ordered for
        return customOrder;
    }

    // Removing from cart
    // If customer choses cake to remove
    // we pick the cake he wants to remove by id
    // then delete it/remove it from cart

}
