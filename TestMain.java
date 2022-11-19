package CakeShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestMain {

	public static void main(String[] args) throws SQLException {

		ProductReport();
		
	}
	
	public static void ProductReport() throws SQLException {
		
		Connection conn = DriverManager.getConnection("jdbc:sqlite:./CakeShop.db");
		Statement stmt = conn.createStatement();
		
		String query = "SELECT * FROM Cakes;";
		
		ResultSet rs = stmt.executeQuery(query);
		System.out.println(rs);
		

		while(rs.next()) {
			Cakes cake = new Cakes();

			//TODO recreate cake objects with ids to be displayed to the admin
			cake.setId(rs.getInt("ID"));
			cake.setCakeType(rs.getString("Type"));
			cake.setFlavour(rs.getString("Flavour"));
			cake.setDateMade(rs.getString("DateMade"));
			cake.setIcing(rs.getString("Icing"));
			cake.setCost(rs.getInt("Cost"));
			System.out.println(cake);
			
		}

		
	}

}
