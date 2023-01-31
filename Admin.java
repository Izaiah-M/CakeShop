package CakeShop;

//this is a sample change
//this class is used to store admin information when it is retrieved from the database
//the information in a given admin object is compared to the values input by the user
//and if the values match,the user is signed in as an admin
public class Admin {
	private String username;
	private String password;
	
	//an empty constructor so that the values can be set usng the setters
	public Admin() {

	}
	
	//returns the name attribute of a given admin object
	public String getUsername() {
		return username;
	}

	//sets the name of a given admin object
	public void setUsername(String username) {
		this.username = username;
	}

	//returns the password of a given admin object
	public String getPassword() {
		return password;
	}

	//used to set the password of a given admin object
	public void setPassword(String password) {
		this.password = password;
	}

}
