
import java.util.Scanner;
public class PlayTime {     
   private static void createTile(Tile[] tiles, boolean isBoard) {
      if (isBoard == false) {  
         for (int i = 0; i < tiles.length; i++) {
         tiles[i] = new Tile(false, i+1);
         }
      } else {
         for (int i = 0; i < tiles.length; i++) {
         tiles[i] = new Tile(true, 0);
         }
      }
   }  
   private static void displayBoardLine(Tile[][] board, Tile[] tile, String boardRow) {
      System.out.printf("\nList of tiles in row %s: ", boardRow);
      String displayString;
      int rowInt = Integer.parseInt(boardRow)-1;
      for(int j = 0; j < board[rowInt].length; ++j) {      
         if(j > 0 && j < board[rowInt].length) 
         System.out.printf("   ");
         if (board[rowInt][j].getValue() == 0) {
         System.out.printf("00");
         } else {
         displayString = Integer.toString(board[rowInt][j].getValue());
         displayString = ("00" + displayString).substring(displayString.length());
         System.out.printf(displayString); 
         }  
      }
      System.out.printf("\n");
      System.out.printf("List of unused tiles: ");
      for(Tile tileArray: tile) {
         if(tileArray.getPlaced() == false) {
         System.out.print(tileArray.getValue() + " ");
         }
      }
   System.out.printf("\n\n");
   }  
   private static void displayBoard(Tile[][] board) {
      for(int i = 0; i < board.length; ++i) {
         String displayString;
         switch(i) {
         case 0:
         case 4:
            System.out.printf("     ");
            break;
          case 1:
          case 3:
            System.out.printf("  ");
            break;
          default:          
            break;          
         }
         for(int j = 0; j < board[i].length; ++j) {      
            if(j > 0 && j < board[i].length) {
            System.out.printf("   ");
            }
            if (board[i][j].getValue() == 0) {
            System.out.printf("00");
            } else {
            displayString = Integer.toString(board[i][j].getValue());
               if ((board[i][j].getValue() > 0) &&
                  (board[i][j].getValue() < 10)) {
               displayString = ("00" + displayString).substring(displayString.length());
               }//let's keep the board readable, make sure it always ouputs String length == 2char)
            System.out.printf(displayString);
            }
         }
      System.out.printf("\n");  
      }
   }   
   private static boolean playTile(Tile tile[], Tile board[][]) { 
      boolean checkBoard = false;
      String rowToPlay, columnToPlay;
      int tileInt, rowInt, columnInt;
      Scanner keyboard = new Scanner(System.in);
      displayBoard(board);
      System.out.printf("\nPlease enter the row you would like to change, 1-5. Enter 99 to quit.\n");
      rowToPlay = keyboard.nextLine();
      while ((rowToPlay.matches("([1-5]|9[9])") == false) ||
            ((rowToPlay.trim().length() > 0)  == false)) {                
               System.out.printf("Invalid row entered. Please enter 1-5.\n");
               rowToPlay = keyboard.nextLine();        
               }      
      if (rowToPlay.matches("([1-5])") == true) {               
         switch(rowToPlay) {//I really like regular expressions and string case statements, it seems  
                
            case "1":
            case "5":
               displayBoardLine(board, tile, rowToPlay);
               System.out.printf("Please enter the column of row %s you would like to change, 1-3.\n", rowToPlay);
               columnToPlay = keyboard.nextLine();
               while ((columnToPlay.matches("([1-3])") == false) ||
                     ((columnToPlay.trim().length() > 0)  == false)) { 
                     displayBoardLine(board, tile, rowToPlay);                                  
                     System.out.printf("Invalid column of row %s entered. Please enter 1-3.\n", rowToPlay);
                     columnToPlay = keyboard.nextLine();        
               }
               break;   
                         
             case "2":
             case "4":
               displayBoardLine(board, tile, rowToPlay);
               System.out.printf("Please enter the column of row %s you would like to change, 1-4.\n", rowToPlay);            
               columnToPlay = keyboard.nextLine();
               while ((columnToPlay.matches("([1-4])") == false) ||
                     ((columnToPlay.trim().length() > 0)  == false)) {
                     displayBoardLine(board, tile, rowToPlay);                
                     System.out.printf("Invalid column of row %s entered. Please enter 1-4.\n", rowToPlay);
                     columnToPlay = keyboard.nextLine();        
               }
               break;
                              
             case "3":
               displayBoardLine(board, tile, rowToPlay);
               System.out.printf("Please enter the column of row %s you would like to change, 1-5.\n", rowToPlay);
               columnToPlay = keyboard.nextLine();
               while ((columnToPlay.matches("([1-5])") == false) ||
                     ((columnToPlay.trim().length() > 0)  == false)) {
                     displayBoardLine(board, tile, rowToPlay);                
                     System.out.printf("Invalid column of row %s entered. Please enter 1-5.\n", rowToPlay);
                     columnToPlay = keyboard.nextLine();        
               }
               break;
               
             default:
               columnToPlay = "1";//shouldn't be possible to get here but let's initalize these just in case
               rowToPlay = "1";
               break;        
            }         
         rowInt = Integer.parseInt(rowToPlay) -1;
         columnInt = Integer.parseInt(columnToPlay) -1;      
         System.out.printf
         ("Current tile on row %s, column %s is: %d.\n", rowToPlay, columnToPlay, board[rowInt][columnInt].getValue());
         System.out.printf("Please enter the tile you would like to play, 1-19, or 0 to remove the tile.\n");
         String tileToPlay = keyboard.nextLine();
         while ((tileToPlay.matches("([0-9]|1[0-9])") == false) ||
               ((tileToPlay.trim().length() > 0)  == false)) {                
                  System.out.printf("Invalid tile entered. Please enter 1-19, or 0 to remove the tile.\n");
                  tileToPlay = keyboard.nextLine();        
                  }
         if (tileToPlay.equals("0") == true) {              
            int tileValue = board[rowInt][columnInt].getValue();
            if (tileValue > 0) {                         //remove a tile: 
            tile[tileValue-1] = board[rowInt][columnInt];//copy that tile from the board into the array if it is >0,
            tile[tileValue-1].setPlaced(false);          //set the copied tile Placed variable to false
            }                                            //and populate the board array location with a zero tile
            board[rowInt][columnInt] = new Tile(true, 0);//replacing zero with zero will overwrite it with a new zero tile, which is fine               
         } else {
            tileInt = Integer.parseInt(tileToPlay)-1;
            if (tile[tileInt].getPlaced() == true) {
            System.out.printf("\nTile is already placed on board. Please pick another tile.\n\n");
            } else {
            board[rowInt][columnInt].setPlaced(false);
            tile[tileInt].setPlaced(true);  
            board[rowInt][columnInt] = tile[tileInt];         
            }
            checkBoard = winTest(board);
            if (checkBoard == true) {
               System.out.printf("All rows, right diagonals, and left diagonals individually add to 38. You win!\n");
            }      
         }      
      } else if (rowToPlay.equals("99") == true) {
         checkBoard = true;
         System.out.printf("Game over.\n");
      }      
      return checkBoard;  
   }     
   private static boolean winTest(Tile[][] board) {
   boolean winTest = false;
   int a = board[0][0].getValue(); 
   int b = board[0][1].getValue(); 
   int c = board[0][2].getValue();
   int d = board[1][0].getValue(); 
   int e = board[1][1].getValue(); 
   int f = board[1][2].getValue(); 
   int g = board[1][3].getValue();
   int h = board[2][0].getValue(); 
   int i = board[2][1].getValue(); 
   int j = board[2][2].getValue(); 
   int k = board[2][3].getValue(); 
   int l = board[2][4].getValue();   
   int m = board[3][0].getValue(); 
   int n = board[3][1].getValue(); 
   int o = board[3][2].getValue(); 
   int p = board[3][3].getValue();
   int q = board[4][0].getValue(); 
   int r = board[4][1].getValue(); 
   int s = board[4][2].getValue();   
   int firstRow = a + b + c;
   int secondRow = d + e + f + g;  
   int thirdRow = h + i + j + k + l;
   int fourthRow = m + n + o + p;
   int fifthRow = q + r + s;
   int firstLeft = a + d + h;
   int secondLeft = b + e + i + m;
   int thirdLeft = c + f + j + n + q;
   int fourthLeft = g + k + o + r;
   int fifthLeft = l + p + s;
   int firstRight = h + m + q;
   int secondRight = d + i + n + r;
   int thirdRight = a + e + j + o + s;
   int fourthRight = b + f + k + p;
   int fifthRight = c + g + l;   
   if (
      (firstRow == 38) && (secondRow == 38) && (thirdRow == 38) && 
      (fourthRow == 38) && (fifthRow == 38) &&
      (firstLeft == 38) && (secondLeft == 38) && (thirdLeft == 38) && 
      (fourthLeft == 38) && (fifthLeft == 38) &&
      (firstRight == 38) && (secondRight == 38) && (thirdRight == 38) && 
      (fourthRight == 38) && (fifthRight == 38)
      ) {   
      winTest = true;
      } else {
      winTest = false;
      }
   return winTest;
   }   
   public static void main(String[] args) {
      boolean gameOver = false;
      Tile[] tile = new Tile[19];
      Tile[][] board = new Tile[5][];
      board[0] = new Tile[3];
      board[1] = new Tile[4];
      board[2] = new Tile[5];
      board[3] = new Tile[4];
      board[4] = new Tile[3];
      createTile(tile, false);
      for (int i = 0; i < board.length; i++) {
         createTile(board[i], true);
         } 
      while (gameOver == false) {
         gameOver = playTile(tile, board);
      }
   }
}