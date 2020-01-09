import java.util.ArrayList;

public class Security {
    private static ArrayList<Security> instances = new ArrayList<>();
    private String lister;
    private String description;
    private double price;
    private int supply;

    /**
     *
     * @param lister lister of the security
     * @param description description of the security
     * @param price price of the security
     * @param supply supply of the security
     * @return true if security is successfully added, false otherwise
     */
    public static boolean list(String lister, String description, double price, int supply){
        if(!Lister.exists(lister)){
            return false;
        }
        else if(price < 0){
            return false;
        }
        else if(supply <= 0){
            return false;
        }


        //add security to security list
        Security instance = new Security();
        instance.lister = lister;
        instance.description = description;
        instance.price = price;
        instance.supply = supply;

        instances.add(instance);

        //add sell order
        //SellOrder.Book(lister, description, price, supply);

        return true;
    }

    static boolean exists(String description){
        for (Security instance : instances) {
            if (instance.description.equals(description)) {
                return true;
            }
        }

        return false;
    }

    static int getSupply(String description) throws NonExistingException{
        for (Security instance : instances) {
            if (instance.description.equals(description)) {
                return instance.supply;
            }
        }

        throw new NonExistingException("security");
    }
}
