import java.util.ArrayList;

class Security{
    private static ArrayList<Security> instances = new ArrayList<>();

    private String lister;
    private String product;
    private String description;
    private double price;
    private int supply;

    public static void list(String lister, String product, String description, double price, int supply){

        
        // check if lister is registered
        ArrayList<User> userInstances = new ArrayList<User>(User.returnList());

        if(userInstances.size() == 0){
            System.out.println("Error: user does not exist");
            return;
        }

        for(int i = 0; i < userInstances.size(); ++i){
            if(userInstances.get(i).returnUserName().equals(lister)){
                if(userInstances.get(i).returnUserType().equals("trader")){
                    System.out.println("Error: user is not a lister");
                    return;
                }

                break;
            }
            
            else if(i == User.returnList().size() - 1){
                System.out.println("Error: user does not exist");
                return;
            }
        }

        
        // check if security is already listed
        ArrayList<Security> securitiesCopy = new ArrayList<Security>(Security.returnList());


        for (Security security : securitiesCopy) {
            if (security.product.equals(product)) {
                System.out.println("Error: security already exists");
                return;
            }
        }


        // create security
        Security instance = new Security();

        instance.lister = lister;
        instance.product = product;
        instance.description = description;
        instance.price = price;
        instance.supply = supply;

        instances.add(instance);

        //book initial sell order for security
        Order.book(lister, product, "sell", supply, price);

    }

    public static void showInstances(){
        for (Security instance : instances) {
            System.out.println("Lister: " + instance.lister);
            System.out.println("Product: " + instance.product);
            System.out.println("Description: " + instance.description);
            System.out.println("Price: " + instance.price);
            System.out.println("Supply: " + instance.supply);
            System.out.println();
        }
    }

    public static ArrayList getInstances(){
        return instances;
    }

    public static ArrayList returnList(){
        return instances;
    }

    public String returnProduct(){
        return product;
    }

}
