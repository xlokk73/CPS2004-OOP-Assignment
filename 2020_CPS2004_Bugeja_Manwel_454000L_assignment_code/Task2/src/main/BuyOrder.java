import java.util.ArrayList;

public class BuyOrder extends Order {
    private static ArrayList<BuyOrder> instances = new ArrayList<>();

    /**
     *
     * @param trader name of a trader
     * @param securityName description of an existing security
     * @param price price of the order
     * @param quantity quantity of the order
     * @return true of the order was successfully booked
     */
    public static boolean book(String trader, String securityName, double price, int quantity){
        //check that trader exists and has sufficient balance
        try{
            double wallet = Trader.getWallet(trader);
            if(wallet < quantity * price){
                return false;
            }
        }
        catch (NonExistingException e){
            return false;
        }

        BuyOrder instance = new BuyOrder();
        instance.trader = trader;
        instance.securityName = securityName;
        instance.price = price;
        instance.quantity = quantity;
        instance.timestamp = System.currentTimeMillis();
        instances.add(instance);
        return true;
    }

    /**
     *
     * @param securityName description of a security
     * @param price price of the order
     * @param quantity quantity of the order
     * @return true if the order exists
     */
    public static boolean exists(String securityName, double price, int quantity){
        for (BuyOrder instance : instances) {
            if (instance.securityName.equals(securityName)
                    && instance.quantity == quantity
                    && instance.price == price) {
                return true;
            }
        }

        return false;
    }

    static ArrayList<BuyOrder> getList(){
        return instances;
    }

    /**
     *
     * @param trader name of the order owner
     * @param securityName name of the security the order is of
     * @return true if the order was successfully canceled
     */
    static boolean cancel(String trader, String securityName){
        for(int i = 0; i < instances.size(); ++i){
            if(instances.get(i).securityName.equals(securityName)
                && instances.get(i).trader.equals(trader)){
                instances.remove(i);
                return true;
            }
        }

        return false;
    }

}
