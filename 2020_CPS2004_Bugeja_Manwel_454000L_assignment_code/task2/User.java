import java.util.ArrayList;

class User{

    private class Tuple{
        public int quantity;
        public String productName;
    }

    private static ArrayList<User> instances = new ArrayList<User>();

    private String userName;
    private String userType;
    private double wallet;
    private ArrayList<Tuple> ownedProducts = new ArrayList<Tuple>();

    public static void create(String name, String type, double wallet){
        User instance = new User();

        for(int i = 0; i < instances.size(); ++i){
            if(instances.get(i).userName.equals(name)){
                System.out.println("Error: User already exists");
                return;
            }
        }


        if(type == "trader" || type == "lister"){
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
        for(int i = 0; i < instances.size(); ++i){
            System.out.println("Name: " + instances.get(i).userName);
            System.out.println("Type: " + instances.get(i).userType);
            System.out.println("Wallet: " + instances.get(i).wallet);
            System.out.println();
        }
    }

    public static ArrayList returnList(){
        ArrayList<User> listCopy = new ArrayList<User>(instances);
        return listCopy;
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
        wallet = wallet - howMuch;
    }

    public void addWallet(double howMuch){
        wallet = wallet + howMuch;
    }

    

    public void addOwnedProduct(String productName, int howMuch){
        // check if user already owns product

        Tuple product = new Tuple();
        product.quantity = howMuch;
        product.productName = productName;

        ownedProducts.add(product);
    }

    public void removeOwnedProduct(String productName, int howMuch){
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
