import java.util.ArrayList;

class ExchangePlatform{
    public static void exchange(){
        ArrayList<Order> orderInstances = Order.returnList();
        ArrayList<Security> securityInstances = Security.returnList();

        // comparing buy orders with sell orders
        for(int i = 0; i < orderInstances.size(); ++i){
            if(orderInstances.get(i).returnType().equals("sell")){
                
                // find wich buy orders qualify
                for (Order orderInstance : orderInstances) {
                    if (orderInstance.returnType().equals("buy")) {

                        if (orderInstances.get(i).returnProduct().equals(orderInstance.returnProduct())) {

                            // check sell quantity >= buy quantity
                            // check buyer has enough money

                            if (orderInstances.get(i).returnQuantity() >= orderInstance.returnQuantity()
                                    && User.returnWallet(orderInstance.returnBooker()) >= orderInstance.returnQuantity() * orderInstance.returnPrice()) {

                                // readjust sell order
                                orderInstances.get(i).subtractQuantity(orderInstance.returnQuantity());

                                // readjust buyer's wallet
                                User.subtractWallet(orderInstance.returnBooker(), orderInstance.returnQuantity() * orderInstance.returnPrice());

                                // readjust seller's wallet
                                User.addWallet(orderInstances.get(i).returnBooker(), orderInstance.returnQuantity() * orderInstance.returnPrice());

                                // readjust buyer's owned product
                                User.addOwnedProduct(orderInstances.get(i).returnBooker(), orderInstance.returnProduct(), orderInstance.returnQuantity());

                                // readjust seller's owned product
                                User.subtractOwnedProduct(orderInstances.get(i).returnBooker(), orderInstance.returnProduct(), orderInstance.returnQuantity());

                                // remove buy order
                                Order.delete(orderInstance);
                            }
                        }
                    }
                }
            }
        }


    }
}
