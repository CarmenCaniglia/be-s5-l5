package carmencaniglia.bes5l5.exceptions;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(long id){
        super("record with id: " +id + " is not found!");
    }
}
