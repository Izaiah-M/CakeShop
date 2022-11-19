package CakeShop;

public class CustomerMain {

    public static void main(String[] args) {

        // When a customer is created
        // They should be instantiated with a shopping cart object
        // The shopping cart object should take in a cake object
        // Cakes are our items and are added into the carst
        // When the info of the customer is passed in they see the cake data base items,
        // they pick items they need
        // items are added or removed from the cart
        // Check out receipt is generated.

        ShoppingCart cart = new ShoppingCart();
        ShoppingCartItem cake1 = new ShoppingCartItem("Chocolate Cake", 80000, 1);
        ShoppingCartItem cake3 = new ShoppingCartItem("Sponge Cake", 100000, 1);
        ShoppingCartItem cake2 = new ShoppingCartItem("Fruit Cake", 100000, 1);

        // Adding Items to the newly made cart
        cart.addItem(cake1);
        cart.addItem(cake2);
        cart.addItem(cake3);
        cart.getItems();

        // Adding the cart to the customer.
        Customer me = new Customer("Izaiah", cart);

        System.out.println(me);
        System.out.println(cart);
    }

}
