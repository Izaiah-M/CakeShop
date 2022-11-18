package CakeShop;

public class Customer {
	
	private String name;
	private String email;
	private int contact;
	private String address;

	public Customer(String name, String email, int contact, String address) {
		this.setName(name);
		this.setEmail(email);
		this.setContact(contact);
		this.setAddress(address);
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

	public String getAddress() {
		return address;
	}

}
