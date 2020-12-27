package shoppingcart;

public class ItemNotFoundException extends RuntimeException{

    private String message;

    public void itemNotFoundException(String error){
        this.message =error;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
