import javafx.beans.binding.BooleanExpression;

import java.util.ArrayList;

class OwnedProduct {
    private String securityName;
    private int amount;

    public String getSecurityName(){
        return securityName;
    }

    public int getAmount(){
        return amount;
    }

    OwnedProduct(String securityName, int amount){
        this.securityName = securityName;
        this.amount = amount;
    }
}

public class Trader extends User{

    private static ArrayList<Trader> instances = new ArrayList<>();
    private ArrayList<OwnedProduct> OwnedProducts = new ArrayList<>();

    /**
     *
     * @return true if the booking was successful
     */
    Boolean Book(){
        return false;
    }

    /**
     *
     * @param name the name of the new trader
     * @param wallet the amount of money the new trader has
     * @return true if the trader was successfully created
     */
    public static Boolean register(String name, double wallet){

        //check if user exists
        ArrayList<Trader> traderInstances = new ArrayList<>(Trader.getList());

        for (User traderInstance : traderInstances) {
            if (traderInstance.getName().equals(name)) {
                return false;
            }
        }

        //check that wallet is greater or equal to 0
        if(wallet < 0){
            return false;
        }


        Trader instance = new Trader();
        instance.name = name;
        instance.wallet = wallet;
        instances.add(instance);
        return true;
    }

    private static Trader getTrader(String name) throws NonExistingException{
        for (Trader instance : instances) {
            if (instance.name.equals(name)) {
                return instance;
            }
        }

        throw new NonExistingException("trader");
    }

    static public double getWallet(String name) throws NonExistingException{
        return getTrader(name).wallet;
    }

    /**
     *
     * @param name name of the user whose wallet is to be increased
     * @param amount amount by which the wallet is to be increased
     * @return true if wallet successfully increased, false otherwise
     */
    public static boolean increaseWallet(String name, double amount){
        Trader user;

        try {
            user = getTrader(name);
        }
        catch(NonExistingException e){
            return false;
        }

        if(amount < 0){
            return false;
        }

        else{
            user.wallet += amount;
            return true;
        }
    }

    /**
     *
     * @param name name of the user whose wallet is to be decreased
     * @param amount amount by which the wallet is to be decreased
     * @return true if wallet successfully decreased, false otherwise
     */
    public static boolean decreaseWallet(String name, double amount){
        Trader user;

        try {
            user = getTrader(name);
        }
        catch(NonExistingException e){
            return false;
        }

        if(amount < 0){
            return false;
        }

        else if (amount > user.getWallet()){
            return false;
        }

        else{
            user.wallet -= amount;
            return true;
        }
    }

    static ArrayList<Trader> getList(){
        return instances;
    }

    static boolean exists(String name){
        for (Trader instance : instances) {
            if (instance.name.equals(name)) {
                return true;
            }
        }

        return false;
    }

    public static ArrayList<OwnedProduct> getOwnedProducts(String name) throws NonExistingException{
        for (Trader instance : instances) {
            if (instance.getName().equals(name)) {
                return instance.OwnedProducts;
            }
        }

        throw new NonExistingException("trader");
    }

    public static boolean owns(String name, String securityName, int amount) throws NonExistingException {
        ArrayList<OwnedProduct> OwnedProducts = Trader.getOwnedProducts(name);

        //check that user exists and has the right amount
        for (OwnedProduct ownedProduct : OwnedProducts) {
            if (ownedProduct.getSecurityName().equals(securityName)
                    && ownedProduct.getAmount() >= amount) {
                return true;
            }
        }

        return false;
    }

    public static boolean addOwnedProduct(String name, String securityName, int amount){
        if(!Trader.exists(name)){
            return false;
        }
        try{
            if(Security.getSupply(securityName) < amount){
                return false;
            }
        }
        catch(NonExistingException e){
            return false;
        }

        OwnedProduct instance = new OwnedProduct(securityName, amount);
        for (Trader trader : instances) {
            if (trader.getName().equals(name)) {
                trader.OwnedProducts.add(instance);
            }
        }

        return true;
    }

    public static boolean removeOwnedProduct(String trader, String securityName, int amount){
        return true;
    }
}
