package CakeShop;

public class Login {
	private String email;
	private String password;

	public Login() {

	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Email: " + email + "\n");
		sb.append("Password: " + password + "\n");

		return sb.toString();
	}

}
