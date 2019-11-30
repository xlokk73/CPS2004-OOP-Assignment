import java.util.ArrayList;

class ExchangePlatform{
    public static void exchange(){
        ArrayList<Order> orderInstances = Order.returnList();
        ArrayList<Security> securityInstances = Security.returnList();

        // comparing buy orders with sell orders
        for(int i = 0; i < orderInstances.size(); ++i){
            if(orderInstances.get(i).returnType().equals("sell")){
                
                ArrayList<Order> potentialBuys = new ArrayList<Order>; 

                // find wich buy orders qualify
                for(int j = 0; j < orderInstances.size(); ++j){
                    if(orderInstances.get(j).returnType().equals("buy")){
                        if(orderInstances.get(i).returnPrice() < orderInstances.get(j).returnPrice()){
                            potentialBuys.add(orderInstances.get(j));
                        }
                    }
                }


                // find highest bidder
                double buyingPrice = 0;
                for(int j = 0; j < potentialBuys.size(); ++j){
                    if(potentialBuys.get(j).returnPrice() > buyingPrice){
                        buyingPrice = potentialBuys.get(j).returnPrice();
                    }
                }

                // complete the trade
            }
        }


    }
}
