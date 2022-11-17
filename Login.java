package CakeShop;

import java.util.HashMap;

public class Login {
	private String name;
	private String password;

	HashMap<String, String> login = new HashMap<String, String>();

	public Login(Admin admin) {
		// pass in the admin object that has been created from the information from the
		// database
		// then get the username and password from that object and add them to the
		// hashmap
		// this is more secure since we dont have to input the username and password in
		// the code to be copied

		login.put(admin.getUsername(), admin.getPassword());
		login.put("Izaiah", "password");
		login.put("Kratos", "Chaos");
		login.put("Soul", "unhackable");
	}

	protected HashMap<String, String> getLoginInfo() {
		return login;
	}

}
