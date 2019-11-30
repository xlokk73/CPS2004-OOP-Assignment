import java.util.Scanner; 

class Main{
    public static void main(String[] args){
        System.out.println("Hello, World!");
        System.out.println();

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
        // ExchangePlatform.exchange();
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

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter user: ");
        String user = sc.nextLine();

        System.out.print("Enter product: ");
        String product = sc.nextLine();

        System.out.print("Enter description: ");
        String description = sc.nextLine();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        System.out.print("Enter supply: ");
        int supply = sc.nextInt();

        Security.list(user, product, description, price, supply);

    }
    public static void fnBook(){
        System.out.println("booking");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter user: ");
        String user = sc.nextLine();

        System.out.print("Enter product: ");
        String product = sc.nextLine();

        System.out.println("Select a type:");
        System.out.println("1. Buy");
        System.out.println("2. Sell");
        int input = sc.nextInt(); 
        String type = new String();

        switch(input){
            case 1:
                type = "buy";
            case 2:
                type = "sell";
        }

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        Order.book(user, product, type, quantity, price);
    }
    public static void fnCancel(){
        System.out.println("canceling order");
        System.out.println("Enter the details:");

        Scanner sc = new Scanner(System.in);
        System.out.print("Booker: ");
        String booker = sc.nextLine();

        System.out.print("Product: ");
        String product = sc.nextLine();

        System.out.println("Select type:");
        System.out.println("1. Buy");
        System.out.println("2. Sell");
        int input = sc.nextInt(); 
        String type = new String();

        switch(input){
            case 1:
                type = "buy";
            case 2:
                type = "sell";
        }

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        Order.delete(booker, product, type, quantity, price);

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
