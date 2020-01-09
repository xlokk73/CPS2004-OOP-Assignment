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
        return true;
    }
}
