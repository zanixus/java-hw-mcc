/**
 @author Kevin M. Mallgrave
 Professor Janet Brown-Sederberg
 CTIM-168 W01
 @since  24 Mar 2019

 Class TimeFormatException

 This is a small class that extends Exception. It is used with C9PP1,
 to allow it to throw TimeFormatException.

 @version 1.0: initial release
 */
public class TimeFormatException extends Exception {
    public TimeFormatException(){
        super("Incorrect time format.");
    }

    public TimeFormatException(String message){
        super(message);
    }

}