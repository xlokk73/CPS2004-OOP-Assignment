import java.util.ArrayList;

class User{

    public class Tuple{
        private int quantity;
        private String productName;

        public int returnQuantity(){
            return quantity;
        }

        public String returnProductName(){
            return productName;
        }
    }

    private static ArrayList<User> instances = new ArrayList<>();

    private String userName;
    private String userType;
    private double wallet;
    private ArrayList<Tuple> ownedProducts = new ArrayList<>();

    public static void create(String name, String type, double wallet){
        User instance = new User();

        for (User user : instances) {
            if (user.userName.equals(name)) {
                System.out.println("Error: User already exists");
                return;
            }
        }


        if(type.equals("trader") || type.equals("lister")){
            instance.userName = name;
            instance.userType = type;
            instance.wallet = wallet;

            instances.add(instance);

            System.out.println("Registered " + type);
        }

        else{
            System.out.println("Error: type does not exist");
        }
    }

    public static void showInstances(){
        for (User instance : instances) {
            System.out.println("Name: " + instance.userName);
            System.out.println("Type: " + instance.userType);
            System.out.println("Wallet: " + instance.wallet);
            System.out.println();
        }
    }

    public static ArrayList returnList(){
        return instances;
    }

    public static double returnWallet(String userName){
        if(instances.size() == 0){
            return 0;
        }

        for (User instance : instances) {
            if (instance.userName.equals(userName)) {
                return instance.wallet;
            }
        }

        return 0;
    }

    public static void subtractWallet(String userName, double howMuch){
        for (User instance : instances) {
            if (instance.userName.equals(userName)) {
                instance.wallet -= howMuch;
            }
        }
    }

    public static void addWallet(String userName, double howMuch){
        for (User instance : instances) {
            if (instance.userName.equals(userName)) {
                instance.wallet += howMuch;
            }
        }
    }

    public static void addOwnedProduct(String userName, String productName, int howMuch){
        for (User instance : instances) {
            if (instance.userName.equals(userName)) {
                instance.addOwnedProduct(productName, howMuch);
            }
        }
    }

    public static void subtractOwnedProduct(String userName, String productName, int howMuch){
        for (User instance : instances) {
            if (instance.userName.equals(userName)) {
                instance.subtractOwnedProduct(productName, howMuch);
            }
        }
    }

    public String returnUserName(){
        return userName;
   }
    
    public String returnUserType(){
        return userType;
    }

    public double returnWallet(){
        return wallet;
    }

    public void subtractWallet(double howMuch){
        if(howMuch >= 0) {
            wallet = wallet - howMuch;
        }
    }

    public void addWallet(double howMuch){
        if(howMuch >= 0) {
            wallet = wallet + howMuch;
        }
    }

    public ArrayList returnOwnedProducts(){
        return ownedProducts;
    }
    

    public void addOwnedProduct(String productName, int howMuch){
        // check if user already owns product
        for (Tuple ownedProduct : ownedProducts) {
            if (ownedProduct.productName.equals(productName)) {
                ownedProduct.quantity += howMuch;
                break;
            }
        }

        Tuple product = new Tuple();
        product.quantity = howMuch;
        product.productName = productName;

        ownedProducts.add(product);
    }

    public void subtractOwnedProduct(String productName, int howMuch){
        for(int i = 0; i < ownedProducts.size(); ++i){
            if(ownedProducts.get(i).productName.equals(productName)){
                if(howMuch > ownedProducts.get(i).quantity){
                    System.out.println("Error: insufficient ammount");
                    return;
                }

                else if(howMuch == ownedProducts.get(i).quantity){
                    ownedProducts.remove(i);
                }

                else{
                    ownedProducts.get(i).quantity -= howMuch;
                }
            }
        }
    }
}
