import java.util.ArrayList;

public class SellOrder extends Order{
    private static ArrayList<SellOrder> instances = new ArrayList<>();

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
        instances.add(instance);
        return true;
    }

    static ArrayList<SellOrder> getList(){
        return instances;
    }
}
