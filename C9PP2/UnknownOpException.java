/**
 @author Kevin M. Mallgrave
 Professor Janet Brown-Sederberg
 CTIM-168 W01
 @since  24 Mar 2019

 @version 1.0: initial release
 */
public class UnknownOpException extends Exception {
    public UnknownOpException(){
        super("Unknown arithmetic operator.");
    }

    public UnknownOpException(String message){
        super(message);
    }

}