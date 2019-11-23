import java.util.Scanner; 

class Main{
    public static void main(String[] args){
        System.out.println("Hello, World!");
        System.out.println();

    
        User Manwel = new User("lister");
        Manwel.listSecurity("Harruba", 250.0, 2);

        User Christian = new User("trader");
        Christian.bookOrder("buy", 2, 25);


        int input = 1;
        Scanner sc = new Scanner(System.in);

        while(input != 0){
            System.out.println("0. quit");
            System.out.println("1. exchange");
            System.out.println("2. register");
            System.out.println("3. list");
            System.out.println("4. book");
            System.out.println("5. cancel order");
            System.out.println();

            input = sc.nextInt();


            switch(input){
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
                default:
                    System.out.println("Error: not an option");
                    break;
            }
        }
    }

    public static void fnExchange(){
        System.out.println("exchanging");
    }
    public static void fnRegister(){
        System.out.println("registering");
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

}
