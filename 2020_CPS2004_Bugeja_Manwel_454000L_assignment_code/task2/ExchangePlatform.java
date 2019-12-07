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
                            //complete trade
                            
                    }
                }
            }
        }


    }
}
