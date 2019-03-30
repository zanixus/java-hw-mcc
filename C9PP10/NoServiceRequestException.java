/**
 @author Kevin M. Mallgrave
 Professor Janet Brown-Sederberg
 CTIM-168 W01
 @since  24 Mar 2019

 Class NoServiceRequestException

 @version 1.0: initial release
 */
public class NoServiceRequestException extends Exception {
    public NoServiceRequestException(){
        super("Name not in list of support tickets.");
    }

    public NoServiceRequestException(String message){
        super(message);
    }

}