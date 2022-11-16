package cakeShop;

public class Cakes {
	private String cakeType;
	private String flavour;
	private String message;
	private String dateMade;
	private String icing;
	private int cost;
	
	
	public Cakes(String cakeType, String flavour, String message, String dateMade, String icing, int cost) {
		this.cakeType = cakeType;
		this.flavour = flavour;
		this.message = message;
		this.dateMade = dateMade;
		this.icing = icing;
		this.cost = cost;
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
