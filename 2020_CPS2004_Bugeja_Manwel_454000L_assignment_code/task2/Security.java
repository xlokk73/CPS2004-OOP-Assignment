import java.util.ArrayList;

class Security {
    private static ArrayList instances = new ArrayList();

    private String description;
    private double price;
    private int supply;

    public static void createSecurity(String description, double price, int supply) {
        Security instance = new Security();

        instance.description = description;
        instance.price = price;
        instance.supply = supply;

        instances.add(new java.lang.ref.WeakReference(instance));
    }

    public static void showInstances(){
    }

    public static ArrayList getInstances() {
        return instances;
    }
}

