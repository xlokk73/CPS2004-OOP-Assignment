import java.util.ArrayList;

public class SellOrder extends Order{
    private static ArrayList<SellOrder> instances = new ArrayList<>();

    public static boolean book(){
        return true;
    }
}
