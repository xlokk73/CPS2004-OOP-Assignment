import java.util.ArrayList;

class ExchangePlatform{
    public static void exchange(){
        ArrayList<Order> orderInstances = Order.returnList();
        ArrayList<Security> securityInstances = Security.returnList();

        // remove orders that don't match with securities
        for(int i = 0; i < orderInstances.size(); ++i){
            for(int j = 0; j < securityInstances.size(); ++j){
                if(orderInstances.get(i).returnProduct().equals(securityInstances.get(j).returnProduct())){
                    break;
                }

                else if(j == securityInstances.size() - 1){
                    Order.delete(orderInstances.get(i));
                }
            }
        }
       

        // comparing buy orders with sell orders
        for(int i = 0; i < orderInstances.size(); ++i){
            if(orderInstances.get(i).returnType().equals("buy")){
                for(int j = 0; j < orderInstances.size(); ++j){
                    if(orderInstances.get(j).returnType().equals("sell")){
                        
                    }
                }
            }
        }


    }
}
