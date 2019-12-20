import java.util.ArrayList;

class ExchangePlatform{
    public static void exchange(){
        ArrayList<Order> orderInstances = Order.returnList();
        ArrayList<Security> securityInstances = Security.returnList();

        // comparing buy orders with sell orders
        for(int i = 0; i < orderInstances.size(); ++i){
            if(orderInstances.get(i).returnType().equals("sell")){
                
                // find wich buy orders qualify
                for(int j = 0; j < orderInstances.size(); ++j){
                    if(orderInstances.get(j).returnType().equals("buy")){

                        if(orderInstances.get(i).returnProduct().equals(orderInstances.get(j).returnProduct())){
                            
                            // check sell quantity >= buy quantity
                            // check buyer has enough money

                            if(orderInstances.get(i).returnQuantity() >= orderInstances.get(j).returnQuantity()
                            && User.returnWallet(orderInstances.get(j).returnBooker()) >= orderInstances.get(j).returnQuantity() * orderInstances.get(j).returnPrice()){

                                // readjust sell order
                                orderInstances.get(i).subtractQuantity(orderInstances.get(j).returnQuantity());

                                // readjust buyer's wallet
                                User.subtractWallet(orderInstances.get(j).returnBooker(), orderInstances.get(j).returnQuantity() * orderInstances.get(j).returnPrice());

                                // readjust seller's wallet 
                                User.addWallet(orderInstances.get(i).returnBooker(), orderInstances.get(j).returnQuantity() * orderInstances.get(j).returnPrice());

                                // readjust buyer's owned product
                                User.addOwnedProduct(orderInstances.get(i).returnBooker(), orderInstances.get(j).returnProduct(), orderInstances.get(j).returnQuantity());

                                // readjust seller's owned product
                                User.subtractOwnedProduct(orderInstances.get(i).returnBooker(), orderInstances.get(j).returnProduct(), orderInstances.get(j).returnQuantity());

                                // remove buy order
                                Order.delete(orderInstances.get(j));
                            }
                        }
                    }
                }
            }
        }


    }
}
