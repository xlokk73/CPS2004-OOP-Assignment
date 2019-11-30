import java.util.ArrayList;

class User{
    private static ArrayList<User> instances = new ArrayList<User>();

    private String userName;
    private String userType;

    public static void create(String name, String type){
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
            System.out.println();
        }
    }

    public static ArrayList returnList(){
        ArrayList<User> listCopy = new ArrayList<User>(instances);
        return listCopy;
    }

    public String returnUserName(){
        String nameCopy = new String(userName);
        return nameCopy;
    }
    
    public String returnUserType(){
        String typeCopy = new String(userType);
        return typeCopy;
    }

    public void listSecurity(String description, String product, double price, int supply){
        if(this.userType == "trader"){
            System.out.println("Error: trader can not list securities");
            return;
        }

        Security.list(this.userName, product, description, price, supply);
    }

    public void bookOrder(String product, String type, int quantity, double price){
        if(this.userType == "lister"){
            System.out.println("Error: lister can not book orders");
            return;
        }

        Order.book(this.userName, product, type, quantity, price);
    }
}
