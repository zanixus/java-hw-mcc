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
public class PeriodicMetal extends Periodic {
    //
// Instance variables
    // Constructors
//
    public PeriodicMetal() {
        super();
    }

    public PeriodicMetal(String symbol, int atomicNumber, double atomicWeight) {
        this.setSymbol(symbol);
        this.setAtomicNumber(atomicNumber);
        this.setAtomicWeight(atomicWeight);
    }
    // Getter methods

    //
    public void describeElement() {
        DecimalFormat formatter = new DecimalFormat("#.########");
        System.out.printf("%s is a metallic element.\n", this.getSymbol());
        System.out.printf("Metallic elements often have higher densities and atomic weights.\n");
        System.out.printf("They tend to have high thermal and electric conductivity.\n");
        System.out.printf("%s has an atomic number of %d and an atomic weight of %s.\n",
                this.getSymbol(), this.getAtomicNumber(), formatter.format(this.getAtomicWeight()));
    }
}