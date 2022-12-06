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

    //used the inbuilt binarySearch method of the Collections class to search for the id enterd by the user
    public int Cakeindex(int num){
        int index = Collections.binarySearch(CakeIds, num);
        return index;
    }

    
}
