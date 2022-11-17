package CakeShop;

public class Customer {
	private String name;
	private String email;
	private int contact;
	private String address;
<<<<<<< HEAD

	public Customer() {

	}

=======
	
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

>>>>>>> 191405e13453e7a86bfd4b264c3c0ed4022eaf76
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
<<<<<<< HEAD

	public String getContact() {
=======
	
	public int getContact() {
>>>>>>> 191405e13453e7a86bfd4b264c3c0ed4022eaf76
		return contact;
	}

	public String getAddress() {
		return address;
	}

}
