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

                        if(orderInstances.get(i).returnProduct.equals(orderInstances.get(j).returnProduct)){

                            // readjust sell order

                            // readjust buyer's wallet

                            // readjust seller's wallet 

                            // readjust buyer's owned product

                            // readjust seller's owned product
                        }
                    }
                }
            }
        }


    }
}
