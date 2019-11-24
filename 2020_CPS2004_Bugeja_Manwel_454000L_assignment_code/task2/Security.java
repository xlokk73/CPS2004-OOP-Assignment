import java.util.ArrayList;

class Security{
    private static ArrayList<Security> instances = new ArrayList<Security>();

    private String lister;
    private String description;
    private double price;
    private int supply;

    public static void list(String lister, String description, double price, int supply){

        ArrayList<User> shallowCopy = new ArrayList<User>(User.returnList());
        
        if(shallowCopy.size() == 0){
            System.out.println("Error: user does not exist");
            return;
        }


        for(int i = 0; i < shallowCopy.size(); ++i){
            if(shallowCopy.get(i).returnUserName().equals(lister)){
                if(shallowCopy.get(i).returnUserType().equals("trader")){
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


        Security instance = new Security();

        instance.lister = lister;
        instance.description = description;
        instance.price = price;
        instance.supply = supply;

        instances.add(instance);
    }

    public static void showInstances(){
        for(int i = 0; i < instances.size(); ++i){
            System.out.println("Lister: " + instances.get(i).lister);
            System.out.println("Description: " + instances.get(i).description);
            System.out.println("Price: " + instances.get(i).price);
            System.out.println("Supply: " + instances.get(i).supply);
            System.out.println();
        }
    }

    public static ArrayList getInstances(){
        return instances;
    }

    public static ArrayList returnList(){
        ArrayList<Security> listCopy = new ArrayList<Security>(instances);
        return listCopy;
    }

}
