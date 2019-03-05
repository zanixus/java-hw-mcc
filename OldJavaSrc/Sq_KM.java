import java.util.Scanner;
public class Sq_KM
{
    public static void main(String[] args)
    {
    Scanner keyboard    = new Scanner(System.in);
        int n, originalNuts, squirrel1Nuts, squirrel2Nuts, squirrel3Nuts;
        int squirrel4Nuts, squirrel5Nuts, morningNuts, endNuts;
        int chipmunkNuts = 0;
    System.out.println("Enter a whole number");
        n  = keyboard.nextInt();
        originalNuts  = 12495 + 15625 * n;
    System.out.println(" ");
    System.out.println("Number entered by the user: " + n);
    System.out.println("Initial number of nuts:     " + originalNuts);
        squirrel1Nuts = originalNuts / 5;
        originalNuts  = originalNuts - squirrel1Nuts;
        originalNuts  --;
        chipmunkNuts  ++;
    System.out.println("Squirrel 1 splits the pile during the night.");
    System.out.println("Squirrel 1 nuts:            " + squirrel1Nuts);
    System.out.println("Chipmunk nuts:              " + chipmunkNuts);
        squirrel2Nuts = originalNuts / 5;
        originalNuts  = originalNuts - squirrel2Nuts;
        originalNuts  --;
        chipmunkNuts  ++;
    System.out.println("Squirrel 2 splits the pile during the night.");
    System.out.println("Squirrel 2 nuts:            " + squirrel2Nuts);
    System.out.println("Chipmunk nuts:              " + chipmunkNuts);
        squirrel3Nuts = originalNuts / 5;
        originalNuts  = originalNuts - squirrel3Nuts;
        originalNuts  --;
        chipmunkNuts  ++;
    System.out.println("Squirrel 3 splits the pile during the night.");
    System.out.println("Squirrel 3 nuts:            " + squirrel3Nuts);
    System.out.println("Chipmunk nuts:              " + chipmunkNuts);
        squirrel4Nuts = originalNuts / 5;
        originalNuts  = originalNuts - squirrel4Nuts;
        originalNuts  --;
        chipmunkNuts  ++;
    System.out.println("Squirrel 4 splits the pile during the night.");
    System.out.println("Squirrel 4 nuts:            " + squirrel4Nuts);
    System.out.println("Chipmunk nuts:              " + chipmunkNuts);
        squirrel5Nuts = originalNuts / 5;
        originalNuts  = originalNuts - squirrel5Nuts;
        originalNuts  --;
        chipmunkNuts  ++;
    System.out.println("Squirrel 5 splits the pile during the night.");
    System.out.println("Squirrel 5 nuts:            " + squirrel5Nuts);
    System.out.println("Chipmunk nuts:              " + chipmunkNuts);
    System.out.println(" ");
    System.out.println
    ("The dishonest squirrels and the lazy chipmunk wake up in the morning.");
    System.out.println("They notice the pile is smaller but keep quiet.");
    System.out.println("They agree to split the pile five ways.");
    System.out.println("Current number of nuts: " + originalNuts);
        morningNuts   = originalNuts / 5;
        originalNuts  --;
        chipmunkNuts  ++;
    System.out.println("Each squirrel gets " + morningNuts + " " +
    "nuts, and the chipmunk gets "+ (chipmunkNuts - 5) + " that is left over.");
    System.out.println("The squirrels go their separate ways.");
    System.out.println("The chipmunk goes back to sleep.");
    squirrel1Nuts = squirrel1Nuts + morningNuts;
    squirrel2Nuts = squirrel2Nuts + morningNuts;
    squirrel3Nuts = squirrel3Nuts + morningNuts;
    squirrel4Nuts = squirrel4Nuts + morningNuts;
    squirrel5Nuts = squirrel5Nuts + morningNuts;
    System.out.println(" ");
    System.out.println("Counts");
    System.out.println("Squirrel 1 nuts:            " + squirrel1Nuts);
    System.out.println("Squirrel 2 nuts:            " + squirrel2Nuts);
    System.out.println("Squirrel 3 nuts:            " + squirrel3Nuts);
    System.out.println("Squirrel 4 nuts:            " + squirrel4Nuts);
    System.out.println("Squirrel 5 nuts:            " + squirrel5Nuts);
    System.out.println("Chipmunk nuts:              " + chipmunkNuts);
    endNuts = squirrel1Nuts +  squirrel2Nuts + squirrel3Nuts +
              squirrel4Nuts +  squirrel5Nuts + chipmunkNuts;
    System.out.println("Total amount of nuts:       " + endNuts);
    }
}