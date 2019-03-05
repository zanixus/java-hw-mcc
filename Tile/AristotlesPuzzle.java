import java.util.Scanner;
import java.util.Arrays;

public class AristotlesPuzzle
{
public static void main(String[] args) throws Exception
{
   Tile[][] Board = new Tile[5][];
   Board[0] = new Tile[3];
   Board[1] = new Tile[4];
   Board[2] = new Tile[5];
   Board[3] = new Tile[4];
   Board[4] = new Tile[3];
   PopulateBoard(Board);
   Tile[] AvailableTiles = new Tile[19];
   PopulateArrayOfPlayingTiles(AvailableTiles);
PrintArrayOfPlayedTiles(Board);
   PrintArrayOfAvailablesTiles(AvailableTiles);

/*
   do
   {
       System.out.println("The tiles as placed so far:");
       PrintArrayOfPlayedTiles(Board);
       PlaceTile(Board, AvailableTiles);
   }while(!TestAllTilesPlaced(AvailableTiles) && !TestForWinner(Board));

*/


   System.out.println("Game over.");
}//end main

//method to populate the array of tiles with numbers 1 to array length + 1 inclusive
private static void PopulateArrayOfPlayingTiles(Tile[] arrayOfTilesPassed)
{
for(int i = 0; i < arrayOfTilesPassed.length; ++i)
{
arrayOfTilesPassed[i] = new Tile(false, i + 1);
}//end for loop
}//end method

//method to place a tile
private static void PlaceTile(Tile[][] boardPassed, Tile[] tilesPassed){}

//method to populate the board
private static void PopulateBoard(Tile[][] arrayPassed)
{
for(int i = 0; i < arrayPassed.length; ++i)
for(int j = 0; j < arrayPassed[i].length; ++j)
arrayPassed[i][j] = new Tile();
}//end method

//method to print the array of placed tiles
private static void PrintArrayOfPlayedTiles(Tile[][] arrayPassed)
{
for(int i = 0; i < arrayPassed.length; ++i)
{
   switch(i)
       {
       case 0:
       case 4:
           System.out.print("  ");
           break;
       case 1:
       case 3:
           System.out.print(" ");
           break;
       default:
           break;          
       }//end switch
for(int j = 0; j < arrayPassed[i].length; ++j)
   {
      
   if(j > 0 && j < arrayPassed[i].length) 
      System.out.print("|");
      //System.out.print(arrayPassed[i][j].getValue());
      if (arrayPassed[i][j].getValue() == 0) 
      System.out.print("00");
      else
      System.out.print(arrayPassed[i][j].getValue());
      
   
   }//end inner for loop
System.out.println();  
}//end outer for loop
}//end method PrintArrayOfTiles


//method to populate the array of tiles with numbers 1 to array length + 1 inclusive
private static void PopulateArrayOfAvailableTiles(Tile[] arrayOfTilesPassed){}

//method to print the array of available tiles
private static void PrintArrayOfAvailablesTiles(Tile[] arrayPassed) {
   for(Tile x: arrayPassed) {
      if(x.getPlaced() == false) {
      System.out.print(x.getValue() + " ");
      }
    }//end for loop
System.out.println();
}//end method

//method to test if all tiles have been placed
public static boolean TestAllTilesPlaced(Tile[] arrayPassed){return true;}

//method to test if puzzle has been solved
private static boolean TestForWinner(Tile[][] a){return true;}
}//end class