public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");

        Trader.register("Manwel", 200);
        Lister.register("Christian", 300);

        try {
            System.out.println(Lister.getWallet("Manwel"));
        }
        catch(NonExistingException e){
            System.out.println("Lister does not exist");
        }

    }
}
