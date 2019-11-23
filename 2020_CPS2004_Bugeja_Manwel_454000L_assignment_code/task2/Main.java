import java.util.Scanner; 

class Main{
    public static void main(String[] args){
        System.out.println("Hello, World!");
        System.out.println();

        User.create("Christian", "trader");
        Security.list("Balluta", 25.0, 2);
        Order.book("test", 2, 2.5, 1);

        int input = 1;
        Scanner sc = new Scanner(System.in);

        while(input != 0){
            System.out.println("0. quit");
            System.out.println("1. exchange");
            System.out.println("2. register");
            System.out.println("3. list");
            System.out.println("4. book");
            System.out.println("5. cancel order");
            System.out.println("6. show all");
            System.out.println();

            input = sc.nextInt();


            switch(input){
                case 0:
                    break;
                case 1:
                    fnExchange();
                    break;
                case 2:
                    fnRegister();
                    break;
                case 3:
                    fnList();
                    break;
                case 4:
                    fnBook();
                    break;
                case 5:
                    fnCancel();
                    break;
                case 6:
                    fnShowAll();
                    break;
                default:
                    System.out.println("Error: invalid option");
                    break;
            }
        }
    }

    public static void fnExchange(){
        System.out.println("exchanging");
    }
    public static void fnRegister(){
        System.out.println("registering");
        System.out.println("Enter name");

        Scanner sc = new Scanner(System.in);
        String inputName = sc.nextLine();

        System.out.println("Please select type:");
        System.out.println("1. lister");
        System.out.println("2. trader");

        int input = sc.nextInt();

        switch(input){
            case 1:
                System.out.println("Registering " + inputName + " as lister");
                User.create(inputName, "lister");
                break;
            case 2:
                System.out.println("Registering " + inputName + " as trader");
                User.create(inputName, "trader");
                break;
            default:
                System.out.println("Error: invalid option");
        }
    }
    public static void fnList(){
        System.out.println("listing");
    }
    public static void fnBook(){
        System.out.println("booking");
    }
    public static void fnCancel(){
        System.out.println("canceling order");
    }
    public static void fnShowAll(){
        System.out.println("Users:");
        User.showInstances();
        System.out.println();

        System.out.println("Securities:");
        Security.showInstances();
        System.out.println();

        System.out.println("Orders:");
        Order.showInstances();
        System.out.println();
    }
}
