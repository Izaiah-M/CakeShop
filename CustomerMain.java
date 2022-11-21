package CakeShop;

import java.util.Scanner;
import java.sql.SQLException;

public class CustomerMain {
    final static Scanner scanner = new Scanner(System.in);
    protected static Customer customer;


    public static void main(String[] args) throws SQLException {

        CustomerDashboard();

        // When a customer is created
        // They should be instantiated with a shopping cart object DONE
        // The shopping cart object should take in a cake object DONE
        // Cakes are our items and are added into the cart DONE
        // When the info of the customer is passed in they see the cake data base items, DONE
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

        //the DatabaseConnect.CustomerSignIn() method returns a customer object
        //we will access the shopping cart of this customer object later on when the customer is ordering
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
                //we keep on 
                boolean signIn;
                do{
                    signIn = SignIn();
                    if (signIn == true) {
                        CustomerMenu();
                    } else{
                        System.out.println("Please sign in with the correct credentials or Sign up");
                    }
                } while(signIn == false);
                
                break;

        }

    }

    public static void CustomerMenu() throws SQLException {
        System.out.println("Catalog and Custom Order");
        System.out.println("Do you want to See the catalog or make a custom order");
        System.out.println("1. See Catalog");
        System.out.println("2. Make a custom Order");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // TODO work on adding items to cart from the catalog
                DatabaseConnect.GenerateCatalog();
                break;

            case 2:
                // here the customer creates their own cake object and it is then returned form
                // the CustomerOrdering
                // method, so the only issue remaining is how to add that custom order to the
                // customers' cart
                Cakes CustomerOrder = CustomerOrdering();
                System.out.println(CustomerOrder);
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

        System.out.println("Enter the date when you want the cake.");
        Cdate = scanner.nextLine();

        // I hope this is Kawa
        // So what is happening(What I have understood from the above code, the fields
        // of the cake are passed into the cake object)
        // I have changed the name of cake to customorder
        // Then passed that custom Order as our Shopping cart Item with the name cake
        // Then added that cake to the shopping cart using the addItem method which
        // takes in a ShoppingCartItem Object
        // Is this kawa?
        // You can revert to the old code if its not kawa

        // So here the custom order is made
        Cakes customOrder = new Cakes(Ctype, Cflavour, Cmessage, Cdate, Cicing, Cprice);

        // Then here the custom order is passed as our shopping cart Item cause remember
        // our shopping Cart Item can also take in a Cake Object
        ShoppingCartItem cake = new ShoppingCartItem(customOrder);

        // Then here, that item, is passed into the cart, our SoppingCart takes in
        // objects of ShopppingcartItem
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(cake);

        /*
         * Maybe the other thing, here should we return the item(cake)...oba the cart
         * itself(with the cake in the cart)?
         * Oh and another thing, I am going to go to the Shopping Cart Item and make it
         * take
         * in/inherit/use the toString() method of the Cakes class which has the string
         * builder.
         * Oh also, in your string builder for the Cakes class, can we add one more
         * thing to show, which is quantity?
         * Check cakes, line 27...s
         */

         //i think we can return the cake that the customer ordered for
        return customOrder;
    }

}
