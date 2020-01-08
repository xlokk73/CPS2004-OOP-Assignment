public class NonExistingException extends Throwable{
    public NonExistingException(String type){
        super(type + "does not exist");
    }
}
