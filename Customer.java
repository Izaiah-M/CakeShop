package CakeShop;

public class Customer {
	private int id;
	private String name;
	private String email;
	private int contact;
	private String address;
	private int totalCost = 0;

	public Customer(String name, String email, int contact, String address) {
		this.setName(name);
		this.setEmail(email);
		this.setContact(contact);
		this.setAddress(address);
	}

	// Second constructor that takes in an ID.
	public Customer(int id, int contact, String name, String email, String address) {
		this.setName(name);
		this.setEmail(email);
		this.setContact(contact);
		this.setAddress(address);
		this.id = id;
	}

	// for adding up items in our cart and giving total summ of all the items
	public int addItemToCart(String itemName, int itemPrice) {
		totalCost += itemPrice;
		return totalCost;
	}

	// Method to subract the price of the removed Item
	public int removeFromCart(String itemName, int itemPrice) {
		totalCost -= itemPrice;
		return totalCost;
	}

	// Method to return Total amount of money spent
	public void checkOutBalance() {
		System.out.println(this.getName());
		System.out.println(this.getEmail());
		System.out.println(this.getContact());
		System.out.println(this.getAddress());
		System.out.println(this.getTotalCost());
		System.out.println("Do you wish to continue with your purchase");
	}

	// Function to get total expenditure
	public int getTotalCost() {
		return totalCost;
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

}
