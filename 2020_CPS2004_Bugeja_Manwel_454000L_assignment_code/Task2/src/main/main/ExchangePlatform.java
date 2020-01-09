import java.util.ArrayList;

public class ExchangePlatform {
    static void match(){

        //go through sell orders
        ArrayList<SellOrder> sellOrderInstances = SellOrder.getList();
        ArrayList<BuyOrder> buyOrderInstances = BuyOrder.getList();
        String buyer;
        String seller;
        String security;
        double price;
        int quantity;

        for(int i = 0; i < sellOrderInstances.size(); ++i){

            for(int j = 0; j < buyOrderInstances.size(); ++j) {
                //if it matches a buy order
                if (sellOrderInstances.get(i).securityName.equals(buyOrderInstances.get(j).securityName)
                        && sellOrderInstances.get(i).quantity == buyOrderInstances.get(j).quantity
                        && sellOrderInstances.get(i).price == buyOrderInstances.get(j).price) {

                    seller = sellOrderInstances.get(i).trader;
                    buyer = buyOrderInstances.get(j).trader;
                    security = sellOrderInstances.get(i).securityName;
                    price = sellOrderInstances.get(i).price;
                    quantity = sellOrderInstances.get(i).quantity;

                    //remove money from buyer
                    Trader.decreaseWallet(buyer, price * quantity);

                    //add money to seller
                    Trader.increaseWallet(seller, price * quantity);

                    //remove owned product from seller
                    Trader.removeOwnedProduct(seller, security, quantity);

                    //add owned product to buyer
                    Trader.addOwnedProduct(buyer, security, quantity);

                    //remove sell order
                    SellOrder.cancel(seller, security);

                    //remove buy order
                    BuyOrder.cancel(buyer, security);
                }
            }
        }
    }
}
