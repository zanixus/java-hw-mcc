import java.util.Random;
public class speedmph
{
  public static void main(String[] args)
     { 
     int speed = 10;
     int miles = 5;
     int myValueA; //a. speed + 12 - miles * 2; 
     int myValueB; //b. speed 1 miles * 3; 
     int myValueC; //c. (speed 1 miles) * 3;
     int myValueD; //d. speed 1 speed * miles 1 miles;
     int myValueE; //e. (10 - speed) 1 miles / miles;
     Random random = new Random();
     int myValueRandom = random.nextInt(6);
     myValueA = speed + 12 - miles * 2;
     myValueB = speed + miles * 3;        
     myValueC = (speed + miles) * 3;
     myValueD = speed + speed * miles + miles;
     myValueE = (10 - speed) + miles / miles;
     System.out.printf("a. " + myValueA + " b. " + myValueB
     + " c. " + myValueC + " d. " + myValueD + " e. " + myValueE+ " " + myValueRandom);       
     }
}
