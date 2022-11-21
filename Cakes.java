package CakeShop;

public class Cakes {
	protected String cakeType;
	protected String flavour;
	protected String message;
	protected String dateMade;
	protected String icing;
	protected int quantity;
	protected int cost;
	protected int id;

	public Cakes() {

	}

	public Cakes(String cakeType, String flavour, String message, String dateMade, String icing, int cost) {
		this.cakeType = cakeType;
		this.flavour = flavour;
		this.message = message;
		this.dateMade = dateMade;
		this.icing = icing;
		this.cost = cost;
	}

	// overridden constructor to take in a cake object without a message written on
	// it
	public Cakes(String cakeType, String flavour, String dateMade, String icing, int cost) {
		this.cakeType = cakeType;
		this.flavour = flavour;
		this.dateMade = dateMade;
		this.icing = icing;
		this.cost = cost;
	}

	// Added an Id to the cake for Identification
	public Cakes(int id, String cakeType, String flavour, String message, String dateMade, String icing, int cost) {
		this.cakeType = cakeType;
		this.flavour = flavour;
		this.message = message;
		this.dateMade = dateMade;
		this.icing = icing;
		this.cost = cost;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCakeType() {
		return cakeType;
	}

	public void setCakeType(String cakeType) {
		this.cakeType = cakeType;
	}

	public String getFlavour() {
		return flavour;
	}

	public void setFlavour(String flavour) {
		this.flavour = flavour;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDateMade() {
		return dateMade;
	}

	public void setDateMade(String dateMade) {
		this.dateMade = dateMade;
	}

	public String getIcing() {
		return icing;
	}

	public void setIcing(String icing) {
		this.icing = icing;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("***********************************\n");
		sb.append("Cake's Details\n");
		sb.append("ID: " + getId() + "\n");
		sb.append("Type: " + getCakeType() + "\n");
		sb.append("Flavour: " + getFlavour() + "\n");
		sb.append("Message: " + getMessage() + "\n");
		sb.append("Date Made: " + getDateMade() + "\n");
		sb.append("Icing Type: " + getIcing() + "\n");
		sb.append("Cost: " + getCost() + "\n");
		sb.append("***********************************\n");

		return sb.toString();

	}

}
