public class User {
    protected String name;
    protected double wallet;
    
    Boolean cancelOrder(){
        return false;
    }

    String getName(){
        return name;
    }
    double getWallet() {
        return wallet;
    }

}

