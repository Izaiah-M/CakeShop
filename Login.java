package cakeShop;

import java.util.HashMap;

public class Login {
	private String name;
	private String password;
	
	HashMap<String, String> login = new HashMap<String, String>();
	
	public Login(){
		
		login.put("Izaiah", "password");
		login.put("Kratos", "Chaos");
		login.put("Soul", "unhackable");
	}
	
	protected HashMap<String, String>getLoginInfo() {
		return login;
	}

}
