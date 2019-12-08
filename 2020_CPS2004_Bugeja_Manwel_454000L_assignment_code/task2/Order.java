import java.util.ArrayList;

class Order{
    private static ArrayList<Order> instances = new ArrayList<Order>();

    private String booker;
    private String product;
    private String type;
    private int quantity;
    private double price;
    private long timestamp;
    private boolean booked;

    public static void book(String booker, String product, String type, int quantity, double price){

        
        ArrayList<User.Tuple> ownedProducts = new ArrayList<User.Tuple>();
        boolean isSeller = false;

        // check if user exists
        ArrayList<User> userInstances = new ArrayList<User>(User.returnList());
        
        if(userInstances.size() == 0){
            System.out.println("Error: user does not exist");
            return;
        }

        for(int i = 0; i < userInstances.size(); ++i){
            if(userInstances.get(i).returnUserName().equals(booker)){
                if(userInstances.get(i).returnUserType().equals("seller")){
                    isSeller = true;
                    ownedProducts = new ArrayList<User.Tuple>(userInstances.get(i).returnOwnedProducts());
                }
                    
                break;
            }

            else if(i == userInstances.size() - 1){
                System.out.println("Error: user does not exist");
                return;
            }
        }

        // check if user owns product in sell orders
        if(isSeller){
            if(ownedProducts.size() == 0){
                System.out.println("Error: user doesn't own product");
                return;
            }

            for(int i = 0; i < ownedProducts.size(); ++i){
                if(ownedProducts.get(i).returnProductName().equals(product) && ownedProducts.get(i).returnQuantity() > quantity){
                    break;
                }

                else if(i == ownedProducts.size() - 1){
                    System.out.println("Error: user doesn't own enough of this product to sell it");
                    return;
                }
            }
        }    

        Order instance = new Order();

        instance.booker = booker;
        instance.product = product;
        instance.type = type;
        instance.quantity = quantity;
        instance.price = price;
        instance.timestamp = System.currentTimeMillis();
        instance.booked = false;

        instances.add(instance);
    }

    public static void delete(Order o){
        for(int i = 0; i < instances.size(); ++i){
            if(instances.get(i).product.equals(o.product)){
                instances.remove(i);
                return;
            }
        }

        System.out.println("Error: order does not exist");
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


    public String returnProduct(){
        return product;
    }

    public String returnType(){
        return type;
    }

    public int returnQuantity(){
        return quantity;
    }

    public boolean isBooked(){
        return booked;
    }

    public void completeBooking(){
        booked = true;
    }
}
