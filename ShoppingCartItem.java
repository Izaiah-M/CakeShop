package CakeShop;

// This class contains data for an individual item in a

// shopping cart.

public class ShoppingCartItem extends Cakes implements Cloneable {
	protected String cakeType;
	protected int cakeCost;
	protected int quantity;
	protected Cakes cake;

	public ShoppingCartItem() {

	}

	public ShoppingCartItem(Cakes cake) {
		this.cake = cake;
	}

	// Is ths what you meant by adding the super to the ShoppingCartItem from Cakes
	public ShoppingCartItem(int id, String cakeType, String flavour, String message, String dateMade, String icing,
			int cakeCost) {
		super(id, cakeType, flavour, message, dateMade, icing, cakeCost);
		this.cakeType = cakeType;
		this.cakeCost = cakeCost;
		// this.quantity = quantity;
	}

	public ShoppingCartItem(String cakeType, int cakeCost, int quantity) {
		this.cakeType = cakeType;
		this.cakeCost = cakeCost;
		this.quantity = quantity;
	}

	// The add method is a quick method for combining two similar
	// items. It doesn't perform any checks to insure that they are
	// similar, however. You use this method when adding items to a
	// cart, rather than storing two instances of the same item, you
	// add the quantities together.

	public void add(ShoppingCartItem otherItem) {
		this.quantity = this.quantity + otherItem.quantity;
	}

	// The subtract method is similar to the add method, but it
	// removes a certain quantity of items.

	public void subtract(ShoppingCartItem otherItem) {
		this.quantity = this.quantity - otherItem.quantity;
	}

	// You can store items in a hash table if you implement hashCode. It's
	// always a good idea to do this.

	public int hashCode() {
		return cakeType.hashCode() + cakeCost;
	}

	// The equals method does something a little dirty here, it only
	// compares the item names and item costs. Technically, this is
	// not the way that equals was intended to work.

	public boolean equals(Object other) {
		if (this == other)
			return true;

		if (!(other instanceof ShoppingCartItem))
			return false;

		ShoppingCartItem otherItem = (ShoppingCartItem) other;

		return (cakeType.equals(otherItem.cakeType)) &&
				(cakeCost == otherItem.cakeCost);
	}

	// Create a copy of this object

	public ShoppingCartItem copy() {
		return new ShoppingCartItem(cakeType, cakeCost, quantity);
	}

	// Create a printable version of this object

	public String toString() {
		return super.toString();
	}
}