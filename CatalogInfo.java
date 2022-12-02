package CakeShop;

import java.util.Collections;
import java.util.Vector;

//This is a class that will help to store the information from the database in a way that is aeasy to use and access
public class CatalogInfo {
    Vector<Cakes> CakeList;
    Vector<Integer> CakeIds;

    public CatalogInfo(){

    }

    public void setCakeList(Vector<Cakes> cakeList) {
        CakeList = cakeList;
    }

    public void setCakeIds(Vector<Integer> cakeIds) {
        CakeIds = cakeIds;
    }

    public Vector<Cakes> getCakeList() {
        return CakeList;
    }

    public Vector<Integer> getCakeIds() {
        //a method to sort the ids in the CakeIds to make them easier to search through when the customer makes a choice
        Collections.sort(CakeIds);
        return CakeIds;

    }

    
}
