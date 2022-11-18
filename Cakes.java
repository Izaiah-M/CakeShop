package CakeShop;

public class Cakes {
	private String cakeType;
	private String flavour;
	private String message;
	private String dateMade;
	private String icing;
	private int cost;
	private int id;

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
	
	//overridden constructor to take in a cake object without a message written on it
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

}
