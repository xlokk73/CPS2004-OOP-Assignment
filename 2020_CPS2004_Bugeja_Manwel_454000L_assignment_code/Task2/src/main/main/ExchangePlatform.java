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

        for (SellOrder sellOrderInstance : sellOrderInstances) {

            for (BuyOrder buyOrderInstance : buyOrderInstances) {
                //if it matches a buy order
                if (sellOrderInstance.securityName.equals(buyOrderInstance.securityName)
                        && sellOrderInstance.quantity == buyOrderInstance.quantity
                        && sellOrderInstance.price == buyOrderInstance.price) {

                    seller = sellOrderInstance.trader;
                    buyer = buyOrderInstance.trader;
                    security = sellOrderInstance.securityName;
                    price = sellOrderInstance.price;
                    quantity = sellOrderInstance.quantity;

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
