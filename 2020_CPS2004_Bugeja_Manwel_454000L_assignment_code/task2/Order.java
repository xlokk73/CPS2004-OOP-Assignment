import java.util.ArrayList;

class Order{
    private static ArrayList<Order> instances = new ArrayList<Order>();

    private String booker;
    private String product;
    private String type;
    private int quantity;
    private double price;
    private long timestamp;

    public static void book(String booker, String product, String type, int quantity, double price, long timestamp){


        ArrayList<User> shallowCopy = new ArrayList<User>(User.returnList());
        
        if(shallowCopy.size() == 0){
            System.out.println("Error: user does not exist");
            return;
        }


        for(int i = 0; i < shallowCopy.size(); ++i){
            if(shallowCopy.get(i).returnUserName().equals(booker)){
                if(shallowCopy.get(i).returnUserType().equals("lister")){
                    System.out.println("Error: user is not a trader");
                    return;
                }

                break;
            }
            
            else if(i == User.returnList().size() - 1){
                System.out.println("Error: user does not exist");
                return;
            }
        }



        Order instance = new Order();

        instance.booker = booker;
        instance.product = product;
        instance.type = type;
        instance.quantity = quantity;
        instance.price = price;
        instance.timestamp = timestamp;

        instances.add(instance);
    }

    public static void delete(String booker, String product, String type, int quantity, double price){
        for(int i = 0; i < instances.size(); ++i){
            if(instances.get(i).booker.equals(booker)
            && instances.get(i).product.equals(product)
            && instances.get(i).type.equals(type)
            && instances.get(i).quantity == quantity
            && instances.get(i).price == price){
                instances.remove(i);
                System.out.println("Order removed");
            }

            else if(i == instances.size() - 1){
                System.out.println("Error: order does not exist");
            }
        }
    }

    public static void showInstances(){
        for(int i = 0; i < instances.size(); ++i){
            System.out.println("Booker: " + instances.get(i).booker);
            System.out.println("Product: " + instances.get(i).product);
            System.out.println("Type: " + instances.get(i).type);
            System.out.println("Quantity: " + instances.get(i).quantity);
            System.out.println("Price: " + instances.get(i).price);
            System.out.println("Timestamp: " + instances.get(i).timestamp);
            System.out.println();
        }
    }

    public static ArrayList returnList(){
        ArrayList<Order> listCopy = new ArrayList<Order>(instances);
        return listCopy;
    }
}
