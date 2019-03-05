/**
 @author Kevin M. Mallgrave
 Professor Janet Brown-Sederberg
 CTIM-168 W01
 @since  09 Mar 2019

 Part 2: Develop two classes (PeriodicMetal.java and PeriodicNonMetal.java)
 which extend Periodic.java and include the method describeElement
 (the method should print a brief explanation of the element
 i.e. metals are good conductors, non-metals are not good conductors).

 @version 1.0: initial release
 */
import java.text.DecimalFormat;
public class PeriodicNonMetal extends Periodic {
    //
// Instance variables
    // Constructors
//
    public PeriodicNonMetal() {
        super();
    }

    public PeriodicNonMetal(String symbol, int atomicNumber, double atomicWeight) {
        this.setSymbol(symbol);
        this.setAtomicNumber(atomicNumber);
        this.setAtomicWeight(atomicWeight);
    }
    // Getter methods

    //
    public void describeElement() {
        DecimalFormat formatter = new DecimalFormat("#.########");
        System.out.printf("%s is a non-metallic element.\n", this.getSymbol());
        System.out.printf("Non-metallic elements tend to have low melting and boiling points.\n");
        System.out.printf("They are often brittle and poor conductors when solid.\n");
        System.out.printf("%s has an atomic number of %d and an atomic weight of %s.\n",
                this.getSymbol(), this.getAtomicNumber(), formatter.format(this.getAtomicWeight()));
    }
}