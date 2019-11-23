import java.util.ArrayList;

class Order{
    private static ArrayList<Order> instances = new ArrayList<Order>();

    private String type;
    private int quantity;
    private double price;
    private double timestamp;

    public static void book(String type, int quantity, double price, long timestamp){
        Order instance = new Order();

        instance.type = type;
        instance.quantity = quantity;
        instance.price = price;
        instance.timestamp = timestamp;
    }
}
