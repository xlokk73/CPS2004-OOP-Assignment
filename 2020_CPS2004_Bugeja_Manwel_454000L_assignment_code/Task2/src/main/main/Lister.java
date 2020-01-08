import java.util.ArrayList;

public class Lister extends User {
    private static ArrayList<Lister> instances = new ArrayList<>();

    /**
     *
     * @return true if the booking was successful
     */
    Boolean Book(){
        return false;
    }

    /**
     *
     * @param name the name of the new Lister
     * @param wallet the amount of money the new Lister has
     * @return true if the Lister was successfully created
     */
    public static Boolean register(String name, double wallet){

        //check if user exists
        ArrayList<Lister> ListerInstances = new ArrayList<>(Lister.getList());

        for (User ListerInstance : ListerInstances) {
            if (ListerInstance.getName().equals(name)) {
                return false;
            }
        }

        //add as a trader
        if(!Trader.register(name, wallet)){
            return false;
        }

        //check that wallet is greater or equal to 0
        if(wallet < 0){
            return false;
        }


        Lister instance = new Lister();
        instance.name = name;
        instance.wallet = wallet;
        instances.add(instance);
        return true;
    }

    private static Lister getLister(String name) throws NonExistingException{
        for (Lister instance : instances) {
            if (instance.name.equals(name)) {
                return instance;
            }
        }

        throw new NonExistingException("Lister");
    }

    static public double getWallet(String name) throws NonExistingException{
        return getLister(name).wallet;
    }

    /**
     *
     * @param name name of the user whose wallet is to be increased
     * @param amount amount by which the wallet is to be increased
     * @return true if wallet successfully increased, false otherwise
     */
    public static boolean increaseWallet(String name, double amount){
        Lister user;

        try {
            user = getLister(name);
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
        Lister user;

        try {
            user = getLister(name);
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

    static ArrayList<Lister> getList(){
        return instances;
    }

    static boolean exists(String name){
        for (Lister instance : instances) {
            if (instance.name.equals(name)) {
                return true;
            }
        }

        return false;
    }
}
