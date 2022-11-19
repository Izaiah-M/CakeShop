package CakeShop;

public class Customer {
	private int id;
	private String name;
	private String email;
	private int contact;
	private String address;
	public ShoppingCart cart;

	public Customer(String name, String email, int contact, String address) {
		this.setName(name);
		this.setEmail(email);
		this.setContact(contact);
		this.setAddress(address);
	}

	// Constructor that takes in a shopping cart object
	public Customer(String name, ShoppingCart cart) {
		this.setName(name);
		this.cart = cart;
	}

	// Second constructor that takes in an ID.
	public Customer(int id, int contact, String name, String email, String address) {
		this.setName(name);
		this.setEmail(email);
		this.setContact(contact);
		this.setAddress(address);
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public int getContact() {
		return contact;
	}

	public int getCustId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	// Should return for us, customer name and shopping cart
	public String toString() {
		return name + " purchasing: " + cart;
	}

}
