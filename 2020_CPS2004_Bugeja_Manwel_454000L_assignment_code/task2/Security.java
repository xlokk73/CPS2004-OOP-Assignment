import java.util.ArrayList;

class Security{
    private static ArrayList<Security> instances = new ArrayList<Security>();

    private String description;
    private double price;
    private int supply;

    public static void createSecurity(String description, double price, int supply){
        Security instance = new Security();

        instance.description = description;
        instance.price = price;
        instance.supply = supply;

        instances.add(instance);
    }

    public static void showInstances(){
        for(int i = 0; i < instances.size(); ++i){
            System.out.println("Description: " + instances.get(i).description);
            System.out.println("Price: " + instances.get(i).price);
            System.out.println("Supply: " + instances.get(i).supply);
            System.out.println();
        }
    }

    public static ArrayList getInstances(){
        return instances;
    }
}
