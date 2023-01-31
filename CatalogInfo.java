package CakeShop;

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

    //added a method to return a given cake from the cake  list, which first checks if the customer has passed 
    //the correct cake id, then finds the index of that id and then returns the item at that index in the Cakes list
    //since the ids are stored in the cakeIds at the same time as the cakes in the cake list so the ids correspond to the cakes
    public Cakes getCake(int id) {
        int C_index;
        Cakes cake;
        if(CakeIds.contains(id)){
            C_index = CakeIds.indexOf(id);
            cake = CakeList.get(C_index);
            return cake;
        }
        return null;
    }

    //a method that returns json data of the cakes passed into the vectors
    
}
