import java.util.ArrayList;

class User{
    private static ArrayList<User> instances = new ArrayList<User>();

    private String userName;
    private String userType;

    public static void create(String name, String type){
        User instance = new User();

        if(type == "trader" || type == "lister"){
            instance.userName = name;
            instance.userType = type;

            System.out.println("Registered " + type);
        }

        else{
            System.out.println("Error: type does not exist");
        }
    }

    public void listSecurity(String description, double price, int supply){
        if(this.userType == "trader"){
            System.out.println("Error: trader can not list securities");
            return;
        }

        Security.list(description, price, supply);
    }

    public void bookOrder(String type, int quantity, double supply){
        if(this.userType == "lister"){
            System.out.println("Error: lister can not book orders");
            return;
        }

        long timestamp = System.currentTimeMillis();
        Order.book(type, quantity, supply, timestamp);
    }
}
