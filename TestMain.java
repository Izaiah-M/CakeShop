package CakeShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class TestMain {

	public static void main(String[] args) throws SQLException {

		GenerateCatalog();

	}

	public static void GenerateCatalog() throws SQLException {

		Vector<Cakes> catalog = new Vector<Cakes>();

		Connection conn = DriverManager.getConnection("jdbc:sqlite:./CakeShop.db");
		Statement stmt = conn.createStatement();

		String query = "SELECT * FROM Cakes;";

		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {

			Cakes cake = new Cakes();

			// recreate cake objects with ids to be displayed to the admin
			cake.setId(rs.getInt("ID"));
			cake.setCakeType(rs.getString("Type"));
			cake.setFlavour(rs.getString("Flavour"));
			cake.setDateMade(rs.getString("DateMade"));
			cake.setIcing(rs.getString("Icing"));
			cake.setCost(rs.getInt("Cost"));
			// System.out.println(cake);
			catalog.add(cake);

		}

		System.out.println(catalog);

		// TODO implement a vector or any suitable data structure to store all the cake
		// objects returned from the database
		// that data structure will then be returned from this function call and it will
		// act as our catalog

	}

}
