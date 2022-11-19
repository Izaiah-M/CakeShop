package CakeShop;

// import java.applet.*;
// import java.awt.*;
// import java.net.*;
import java.util.*;

// This class is a simple container of shopping cart cakes.
// It is observable, which means that it notifies any interested
// classes whenever it changes.

public class ShoppingCart {

    // Our vector is like an array and things being added to it are the cakes the
    // customer has bought
    Vector<Object> cakes;
    protected int totalCost = 0;

    public ShoppingCart() {
        cakes = new Vector<Object>();
    }

    // Adding a new cake and updating the totalCost
    // Takes in an object of the cake

    public void addItem(ShoppingCartItem newCake) {

        // See if there's already an item like this in the cart
        int currIndex = cakes.indexOf(newCake);

        // Our event listener to help with the adding and removing from the cart
        ShoppingCartEvent event = new ShoppingCartEvent();

        if (currIndex == -1) {
            // If the item is new, add it to the cart
            cakes.add(newCake);
            event.item = newCake;
            event.eventType = ShoppingCartEvent.ADDED_ITEM;
        } else {

            // If there is a similar item, just add the quantities
            ShoppingCartItem currItem = (ShoppingCartItem) cakes.elementAt(currIndex);

            currItem.add(newCake);
            event.item = currItem;
            event.eventType = ShoppingCartEvent.CHANGED_ITEM;
        }

        totalCost += newCake.cakeCost * newCake.quantity;

        // Tell the observers what just happened
        // setChanged();
        // notifyObservers(event);
    }

    // Remove item removes an item from the cart. Since it removes
    // n cakes from the cart at a time, if there are more than n cakes
    // in the cart, it just subtracts n from the quantity.

    public void removeItem(ShoppingCartItem oldItem) {
        // Find this object in the cart
        int currIndex = cakes.indexOf(oldItem);
        ShoppingCartEvent event = new ShoppingCartEvent();

        if (currIndex == -1) {
            // If it wasn't there, just return, assume everything's okay
            return;
        } else {
            ShoppingCartItem currItem = (ShoppingCartItem) cakes.elementAt(currIndex);

            // If you are trying to subtract more cakes than are in the cart,
            // adjust the amount you want to subtract so it is equal to the
            // number of cakes in the cart.

            if (oldItem.quantity > currItem.quantity) {
                oldItem.quantity = currItem.quantity;
            }

            // Adjust the totalCost
            totalCost -= oldItem.cakeCost * oldItem.quantity;

            currItem.subtract(oldItem);

            event.item = currItem;
            event.eventType = ShoppingCartEvent.CHANGED_ITEM;

            // If the quantity drops to 0, remove the item entirely

            if (currItem.quantity == 0) {
                cakes.removeElementAt(currIndex);
                event.eventType = ShoppingCartEvent.REMOVED_ITEM;
            }

        }

        // Tell everyone what happened

        // setChanged();
        // notifyObservers(event);
    }

    // getItems returns a copy of all the cakes in the cart

    // public Vector<Object> getItems() {
    // return cakes;
    // }

    public void getItems() {

        Object[] cakeArr = cakes.toArray();

        for (Object cake : cakeArr) {
            System.out.println(cake);
        }

    }

    // Vector method to help us return Our cakes
    public Vector<Object> cakesBought() {
        return cakes;
    }

    // To hep us return a nice array of our things
    public String toString() {
        return this.cakesBought().toString();
    }
}