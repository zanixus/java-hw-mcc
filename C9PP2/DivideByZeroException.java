/**
 @author Kevin M. Mallgrave
 Professor Janet Brown-Sederberg
 CTIM-168 W01
 @since  24 Mar 2019

 @version 1.0: initial release
 */
public class DivideByZeroException extends Exception {
    public DivideByZeroException(){
        super("Cannot divide by zero.");
    }

    public DivideByZeroException(String message){
        super(message);
    }

}