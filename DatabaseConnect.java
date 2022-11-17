package CakeShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import org.sqlite.*;

public class DatabaseConnect {
public static Connection conn;
	
	public static void AddCustomer(Customer cstm) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:sqlite:./CakeShop.db");
		
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO Customers(Name,Contact,Email,Address) VALUES(?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, cstm.getName());
		stmt.setLong(2, cstm.getContact());
		stmt.setString(3, cstm.getEmail());
		stmt.setString(4, cstm.getAddress());
		
		stmt.executeUpdate();
	}
	
	public static void LoginAdmin() throws SQLException{
		Admin admin = new Admin();
		Connection conn = DriverManager.getConnection("jdbc:sqlite:./CakeShop.db");
		
		Statement stmt = conn.createStatement();
		
		String query = "SELECT * FROM Admin;";
		ResultSet rs = stmt.executeQuery(query);
		
		while (rs.next()) {
			
			admin.setUsername(rs.getString("Username"));
			admin.setPassword(rs.getString("Password"));
			
		}
		
		System.out.println(admin);
		
	}
	
}
