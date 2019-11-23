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
            System.out.println("4. trade");
            System.out.println("5. cancel order");
            System.out.println();

            input = sc.nextInt();
        }
    }
}
