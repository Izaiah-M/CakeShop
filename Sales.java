package CakeShop;

import java.io.Serializable;

public class Sales implements Serializable {

    private String nameOfCustomer;
    private String itemsPurchased;
    private String dateOfPurchased;
    private int cost;
    private static final long serialVersionUID = 1L; // Helps the JVM know which class its serializing or deserializing,
                                                     // its like an ID

}
