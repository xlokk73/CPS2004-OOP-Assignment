import java.util.ArrayList;

public class BuyOrder extends Order {
    private static ArrayList<BuyOrder> instances = new ArrayList<>();

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
        instances.add(instance);
        return true;
    }

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
