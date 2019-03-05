/**                                                       @version 1.0
   @author Kevin M. Mallgrave
           Professor Janet Brown-Sederberg
           CTIM-157 B02
   @since  13 December 2018
   
   Java door game methods
   
   Version 1.0: initial release
   
 */
public class Door
{
final String inscription;
boolean locked;
boolean closed;
Door(String c)
   {// Door(String c); //Constructor - initializes a Door with inscription c, closed and locked
   this.inscription = c; // Once the writing on a Door is set, it cannot be changed
   this.locked = true;
   this.closed = true;
   }
public String toString()
   {
   return
   "\nDoor inscription: " + this.inscription+
   "\nDoor is locked  : " + this.locked +
   "\nDoor is closed  : " + this.closed;
   }//end method   

boolean isClosed()
   {//Returns true if the Door is closed
   return this.closed;
   }
boolean isLocked() 
   { //Returns true if the Door is locked
   return this.locked;
   }
public void open()
   { //Opens a Door if it is closed and unlocked
   if 
      (this.closed == true
      && this.locked == false)
      {
      this.closed = false;
      System.out.println("The door opens.");
      }
   else
      {
      System.out.println("Action cannot be taken. Door is locked.");
      }
   }
public void close()
   { //Closes a Door if it is open
   if 
      (this.closed == false)
      {
      this.closed = true;
      System.out.println("The door closes.");
      }
      else if (this.closed == true)
      {
      System.out.println("Action cannot be taken. Door is already closed.");  
      }
      else if (this.locked == true && this.closed == false)
      {
      System.out.println("Action cannot be taken. Door is locked.");  
      }
   }
public void lock()
   { // You may lock a Door if and only if it is unlocked, 
      if (this.locked == false)
      {
      this.locked = true;
      System.out.println("The door locks.");
      }
      else
      {
      System.out.println("Action cannot be taken. Door is already locked."); 
      }
   }
public void unlock()
   { // Unlocks a Door if it is locked
      if (this.locked == true)
      {
      this.locked = false;
      System.out.println("The door unlocks.");
      }
      else
      {
      System.out.println("Action cannot be taken. Door is already unlocked.");  
      }
   }    
}//end class
