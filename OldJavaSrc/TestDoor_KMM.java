public class TestDoor_KMM
{
public static void main(String[] args)
   {
   Door door1 = new Door("Enter");
   Door door2 = new Door("Exit");
   Door door3 = new Door("Treasure");
   //The "Enter" door should be unlocked and opened. 
   door1.unlock();
   door1.open();
   // The "Exit" door should be closed and locked. 
   door2.open(); //can't open locked exit door
   door2.lock();
   //The "Treasure" door should be open but locked.
   door3.unlock();
   door3.open();
   door3.lock();   
   System.out.println(door1.toString());
   System.out.println(door2.toString());
   System.out.println(door3.toString());
   }//end main  
}