package CakeShop;

//TODO make sales take in a cake object and set its attributes from there
public class Sales {

	private int Sales_database_Id;
	private int Cake_Id;
    private String CakeDescription;
    private String dateOfPurchased;
    private int cost;

	public Sales() {
		
	}
	
	public Sales(Cakes cake) {
		this.setCake_Id(cake.getId());
		this.setCakeDescription(cake.toString());
		this.setDateOfPurchased(cake.getDateMade()); //this is not the correct date, find a way to get the correct current date of when the sale is made
		this.setCost(cake.getCost());
	}

	public int getCake_Id() {
		return Cake_Id;
	}

	public void setCake_Id(int cake_Id) {
		Cake_Id = cake_Id;
	}

	public int getSales_database_Id() {
		return Sales_database_Id;
	}

	public void setSales_database_Id(int salesId) {
		Sales_database_Id = salesId;
	}

	public String getCakeDescription() {
		return CakeDescription;
	}

	public void setCakeDescription(String cakeDescription) {
		CakeDescription = cakeDescription;
	}

	public String getDateOfPurchased() {
		return dateOfPurchased;
	}

	public void setDateOfPurchased(String dateOfPurchased) {
		this.dateOfPurchased = dateOfPurchased;
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
		sb.append("Sales ID: " + getSales_database_Id());
		sb.append("Cake Description: "+ getCakeDescription());
		sb.append("Cake Cost: " + getCost());
		sb.append("***********************************\n");

		return CakeDescription;
		
		
	}

    
    
    
    

}
