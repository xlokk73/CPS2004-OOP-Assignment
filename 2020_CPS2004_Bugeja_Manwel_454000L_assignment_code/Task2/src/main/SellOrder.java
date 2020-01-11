import java.util.ArrayList;

public class SellOrder extends Order{
    private static ArrayList<SellOrder> instances = new ArrayList<>();

    /**
     *
     * @param trader name of a trader
     * @param securityName description of an existing security
     * @param price price of the order
     * @param quantity quantity of the order
     * @return true if the order was successfully booked
     */
    public static boolean book(String trader, String securityName, double price, int quantity){
        //check that trader exists and owns product
        try{
            if(!Trader.owns(trader, securityName, quantity)){
                return false;
            }
        }
        catch (NonExistingException e){
            return false;
        }

        SellOrder instance = new SellOrder();
        instance.trader = trader;
        instance.securityName = securityName;
        instance.price = price;
        instance.quantity = quantity;
        instance.timestamp = System.currentTimeMillis();
        instances.add(instance);
        return true;
    }

    static ArrayList<SellOrder> getList(){
        return instances;
    }

    /**
     *
     * @param trader name of a trader
     * @param securityName description of a security
     * @return true if the order was successfully cancelled
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
