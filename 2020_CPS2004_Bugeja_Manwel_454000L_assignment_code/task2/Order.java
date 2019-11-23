import java.util.ArrayList;

class Order{
    private static ArrayList<Order> instances = new ArrayList<Order>();

    private String type;
    private int quantity;
    private double price;
    private long timestamp;

    public static void book(String type, int quantity, double price, long timestamp){
        Order instance = new Order();

        instance.type = type;
        instance.quantity = quantity;
        instance.price = price;
        instance.timestamp = timestamp;

        instances.add(instance);
    }

    public static void showInstances(){
        for(int i = 0; i < instances.size(); ++i){
            System.out.println("Type: " + instances.get(i).type);
            System.out.println("Quantity: " + instances.get(i).quantity);
            System.out.println("Price: " + instances.get(i).price);
            System.out.println("Timestamp: " + instances.get(i).timestamp);
            System.out.println();
        }
    }


}
