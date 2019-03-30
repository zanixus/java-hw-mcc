/**
 @author Kevin M. Mallgrave
 Professor Janet Brown-Sederberg
 CTIM-168 W01
 @since  24 Mar 2019

 Class NoServiceRequestException

 @version 1.0: initial release
 */
public class ServiceBackUpException extends Exception {
    public ServiceBackUpException(){
        super("Failed to add service ticket. Array list is full.");
    }

    public ServiceBackUpException(String message){
        super(message);
    }

}