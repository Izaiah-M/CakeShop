package CakeShop;


public class Sales {

	private int SalesId;
    private String CakeDescription;
    private String dateOfPurchased;
    private int cost;
    
	public Sales(int salesId, String cakeDescription, String dateOfPurchased, int cost) {

		this.setSalesId(salesId);
		this.setCakeDescription(cakeDescription);
		this.setDateOfPurchased(dateOfPurchased);
		this.setCost(cost);
	}

	public Sales() {

	}

	public int getSalesId() {
		return SalesId;
	}

	public void setSalesId(int salesId) {
		SalesId = salesId;
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
		sb.append("Sales ID: " + getSalesId());
		sb.append("Cake Description: "+ getCakeDescription());
		sb.append("Cake Cost: " + getCost());
		sb.append("***********************************\n");

		return CakeDescription;
		
		
	}

    
    
    
    

}
