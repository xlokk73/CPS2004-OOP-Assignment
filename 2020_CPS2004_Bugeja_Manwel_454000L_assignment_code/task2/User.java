class User{
    private String userType;

    User(String type){
        if(type == "trader" || type == "lister"){
            userType = type;
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
