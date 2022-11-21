package CakeShop;

public class Customer {
	private int id;
	private String name;
	private String email;
	private int contact;
	private String address;
	private String password;
	public ShoppingCart cart;

	public Customer() {
		
	}

	public Customer(String name, String email, int contact, String address, String password) {
		this.setName(name);
		this.setEmail(email);
		this.setContact(contact);
		this.setAddress(address);
		this.setPassword(password);
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
	public void setPassword(String Password) {
		this.password = Password;
	}
	
	//TODO adding shopping cart
	//would this make more sense as in the part of adding and attaching a cart object to the Customer?
	public void AddCart() {
		this.cart = new ShoppingCart();
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
	public String getPassword() {
		return this.password;
	}

	public ShoppingCart getCart() {
		return this.cart;
	}

	// Should return for us, customer name and shopping cart
	public String toString() {
		return this.name + " purchasing: " + this.cart;
	}

}
