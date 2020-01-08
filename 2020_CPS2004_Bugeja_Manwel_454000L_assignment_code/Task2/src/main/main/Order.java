import java.util.ArrayList;

public class Order {
    private String securityName;
    private String trader;
    private int quantity;
    private double price;
    private String timestamp;

    private static ArrayList<Order> instances = new ArrayList<>();

    /**
     *
     * @param securityName
     * @param trader
     * @param quantity
     * @param price
     * @return
     */
    public static boolean book(String securityName, String trader, int quantity, double price){
        return true;
    }
}
