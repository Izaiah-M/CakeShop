package CakeShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;

public class DatabaseConnect {
	public static Connection conn;

	public static void AddCustomer(Customer cstm) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:sqlite:./CakeShop.db");

		PreparedStatement stmt = conn.prepareStatement(
				"INSERT INTO Customers(Name,Contact,Email,Address,Password) VALUES(?,?,?,?,?);",
				Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, cstm.getName());
		stmt.setLong(2, cstm.getContact());
		stmt.setString(3, cstm.getEmail());
		stmt.setString(4, cstm.getAddress());
		stmt.setString(5, cstm.getPassword());

		stmt.executeUpdate();

		System.out.println("Welcome " + cstm.getName());
	}

	public static boolean LoginAdmin(Scanner scanner) throws SQLException {
		// create an empty admin object
		Admin admin = new Admin();

		// Initialize a connection object to connect to the sqlite database
		Connection conn = DriverManager.getConnection("jdbc:sqlite:./CakeShop.db");

		// this initializes the statement object which is used to execute a sql
		// string/query and return the values that it gives
		Statement stmt = conn.createStatement();

		String query = "SELECT * FROM Admin;";
		// the Resultset object stores the values returned from running a query as a
		// iterable object
		ResultSet rs = stmt.executeQuery(query);

		// rs.next returns a boolean value. true if there is more information to be read
		// from the resultset object
		// and false if there is no more information to be read
		while (rs.next()) {
			admin.setUsername(rs.getString("Username"));
			admin.setPassword(rs.getString("Password"));
		}

		System.out.println(admin);

		System.out.print("Enter User Name: ");
		String name = scanner.nextLine();

		System.out.print("Enter Password: ");
		String pass = scanner.nextLine();

		// this block of if statements carries out validation on the values of name and
		// pass that the user inputs
		// and it compares them with the values in the admin object and if they match,
		// logs the user in
		if (name.equals(admin.getUsername()) && pass.equals(admin.getPassword())) {
			System.out.println("Logging in!!");
			return true;
		} else {
			return false;
		}
	}

	// this method is accessible only to the admin and it is used to add cakes to
	// the database
	public static void AddCake(Scanner scanner) throws SQLException {
		String Ctype = null, Cflavour = null, Cdate = null, Cicing = null;
		int Cprice = 0;
		System.out.println("Enter the type of the cake i.e fruit cake, forest cake, sponge cake, basic vanilla cake");
		Ctype = scanner.nextLine();

		System.out.println("Enter the flavour of the cake e.g orange, marble , chocolate ,vanilla");
		Cflavour = scanner.nextLine();

		System.out.println("Enter the date the cake was made.");
		Cdate = scanner.nextLine();

		System.out.println("Enter the icing type of the cake i.e fondant , whipped cream , butter cream");
		Cicing = scanner.nextLine();

		System.out.println("Enter the price of the cake ");
		Cprice = scanner.nextInt();

		Cakes cake = new Cakes(Ctype, Cflavour, Cdate, Cicing, Cprice);

		Connection conn = DriverManager.getConnection("jdbc:sqlite:./CakeShop.db");
		PreparedStatement stmt = conn.prepareStatement(
				"INSERT INTO Cakes(Type,Flavour,DateMade,Icing,Cost) VALUES(?,?,?,?,?)",
				Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, cake.getCakeType());
		stmt.setString(2, cake.getFlavour());
		stmt.setString(3, cake.getDateMade());
		stmt.setString(4, cake.getIcing());
		stmt.setLong(5, cake.getCost());

		stmt.executeUpdate();
	}

	public static void RemoveCake(Scanner scanner) throws SQLException {
		ProductReport();
		System.out.println("Enter the id of the cake that you want to remove: ");
		int delId = scanner.nextInt();
		scanner.nextLine();

		Connection conn = DriverManager.getConnection("jdbc:sqlite:./CakeShop.db");

		PreparedStatement stmt = conn.prepareStatement("DELETE FROM Cakes WHERE ID = ?",
				Statement.RETURN_GENERATED_KEYS);
		stmt.setLong(1, delId);
		stmt.executeUpdate();
		ProductReport();
	}

	public static void ProductReport() throws SQLException {

		Connection conn = DriverManager.getConnection("jdbc:sqlite:./CakeShop.db");
		Statement stmt = conn.createStatement();

		String query = "SELECT * FROM Cakes;";

		ResultSet rs = stmt.executeQuery(query);

		Cakes cake = new Cakes();

		while (rs.next()) {
			// recreate cake objects with ids to be displayed to the admin
			cake.setId(rs.getInt("ID"));
			cake.setCakeType(rs.getString("Type"));
			cake.setFlavour(rs.getString("Flavour"));
			cake.setDateMade(rs.getString("DateMade"));
			cake.setIcing(rs.getString("Icing"));
			cake.setCost(rs.getInt("Cost"));
			System.out.println(cake);

		}

	}

	public static void SalesReport() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:sqlite:./CakeShop.db");
		Statement stmt = conn.createStatement();

		String query = "SELECT * FROM Sales;";

		ResultSet rs = stmt.executeQuery(query);

		Sales sales = new Sales();
		int TotalSales = 0;

		while (rs.next()) {
			// recreate cake objects with ids to be displayed to the admin
			sales.setSalesId(rs.getInt("ID"));
			sales.setCakeDescription(rs.getString("Cake Description"));
			sales.setDateOfPurchased(rs.getString("Date"));
			sales.setCost(rs.getInt("Price"));
			System.out.println(sales);

			TotalSales += rs.getInt("Price");

		}

		System.out.println("Total Sales = " + TotalSales);

	}

	public void GenerateCatalog() throws SQLException {

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

	public static boolean CustomerSignIn(Login login) throws SQLException {
		Customer customer = new Customer();
		Connection conn = DriverManager.getConnection("jdbc:sqlite:./CakeShop.db");

		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Customers WHERE Email = ? AND Password = ?",Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, login.getEmail());
		stmt.setString(2, login.getPassword());
		System.out.println(login);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			customer.setName(rs.getString("Name"));
			customer.setEmail(rs.getString("Email"));
			customer.setContact(rs.getInt("Contact"));
			customer.setAddress(rs.getString("Address"));

		}

		if (login.getPassword() == customer.getPassword() && login.getEmail() == customer.getEmail()) {
			return true;
		} else {
			return false;
		}
	}
}
