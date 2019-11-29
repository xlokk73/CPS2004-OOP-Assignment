import java.util.ArrayList;

class ExchangePlatform{
    public static void exchange(){
        ArrayList<Order> OrderInstances = Order.returnList();

        // comparing buy orders with sell orders
        for(int i = 0; i < OrderInstances.size(); ++i){
            if(OrderInstances.get(i).returnType().equals("buy")){
                for(int j = 0; j < OrderInstances.size(); ++j){
                    if(Order.Instances.get(j).returnType().equals("sell")){
                        
                    }
                }
            }
        }


    }
}
