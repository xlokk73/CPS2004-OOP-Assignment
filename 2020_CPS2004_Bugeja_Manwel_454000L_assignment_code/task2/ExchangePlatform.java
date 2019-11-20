public class ExchangePlatform{
    public static void main(String[] args){
        System.out.println("Hello, World!");
        System.out.println();

        Security Trees = new Security();
        Trees.createSecurity("Balluta", 25.0, 2);
        Trees.createSecurity("Harruba", 50.0, 1);

        Trees.showInstances();
    }
}
