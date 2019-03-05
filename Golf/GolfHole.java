public class GolfHole 
{
//instance variables 
private int number;
private int par;
private int handicap;
private int score;
private int distance;
private String description;

//default constructor
   public GolfHole()
   {
      number = 0;
      par = 0;
      handicap = 0;
      score = 0;
      distance = 0;
      description = "Not yet assigned";
   }//end default constructor

//non-default constructor
   GolfHole(int numberPassed, int parPassed, int handicapPassed, 
   int scorePassed, int distancePassed, String descriptionPassed)
   {
      this.setNumber(numberPassed);
      this.setPar(parPassed);
      this.setHandicap(handicapPassed);
      this.setScore(scorePassed);
      this.setDistance(distancePassed);
      this.setDescription(descriptionPassed);
   }

//getters
public int getNumber()
{
return number; 
}//end getter

public int getPar()
{
return par; 
}//end getter

public int getHandicap()
{
return handicap;
}//end getter

public int getScore()
{
return score; 
}//end getter

public int getDistance()
{
return distance; 
}//end getter

public String getDescription()
{
return description; 
}//end getter

//setters
public void setNumber(int numberPassed)
{
if(numberPassed < 1 || numberPassed > 18)
 {
  System.out.println("Invalid input hole number must be 1 - 18 inclusive.");
  System.out.println("Hole number will be set to 0");
  numberPassed = 0;
 }//end if
number = numberPassed; 
}//end setter

public void setPar(int parPassed)
{
if(parPassed < 1 || parPassed > 5)
 {
  System.out.println("Invalid input par must be 1 - 5 inclusive.");
  System.out.println("Par will be set to 0");
  parPassed = 0;
 }//end if
par = parPassed;  
}//end getter

public void setHandicap(int handicapPassed)
{
if(handicapPassed < 1 || handicapPassed > 18)
 {
  System.out.println("Invalid handicap must be 1 - 18 inclusive.");
  System.out.println("Handicap will be set to 18");
  handicapPassed = 18;
 }//end if
handicap = handicapPassed;  
}//end setter

public void setScore(int scorePassed)
{
if(scorePassed < 1 || scorePassed > 10)
 {
  System.out.println("Invalid score must be 1 - 10 inclusive.");
  System.out.println("Score will be set to 10");
  scorePassed = 10;
 }//end if
score = scorePassed;  
}//end getter

public void setDistance(int distancePassed)
{
if(distancePassed < 0)
 {
  System.out.println("Invalid distance must be positive.");
  System.out.println("Distance will be set to 325");
  distancePassed = 325;
 }//end if
distance = distancePassed;
}//end setter

public void setDescription(String descriptionPassed)
{
description =  descriptionPassed;
}//end setter

  public String toString()
{
return "Hole information\n"
+ "\n Number : " + number
+ "\n Par : " + par
+ "\n Handicap : " + handicap
+ "\n Score : " + score
+ "\n Distance : " + distance
+ "\n Description : " + description + "\n";
}
}//end class