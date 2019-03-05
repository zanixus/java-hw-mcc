/**
 @author Kevin M. Mallgrave
 Professor Janet Brown-Sederberg
 CTIM-168 W01
 @since  09 Mar 2019

 //Part 3: Develop a class PeriodArray.java which creates array which holds at least 3 instances of each type
 and iterates over the array calling the toString and describeElement methods of each instance.
 @version 1.0: initial release
 */
public class PeriodArray {

    private static void initElements(Periodic periodicTable[]) {
        //input format: string int double
        periodicTable[0] = new PeriodicNonMetal("H", 1, 1.008);
        periodicTable[1] = new PeriodicNonMetal("He", 2, 4.0026);
        periodicTable[5] = new PeriodicNonMetal("C", 6, 12.011);
        periodicTable[6] = new PeriodicNonMetal("N", 7, 14.007);
        periodicTable[7] = new PeriodicNonMetal("O", 8, 15.999);
        periodicTable[8] = new PeriodicNonMetal("F", 9, 18.998);
        periodicTable[9] = new PeriodicNonMetal("Ne", 10, 20.18);
        periodicTable[14] = new PeriodicNonMetal("P", 15, 30.974);
        periodicTable[15] = new PeriodicNonMetal("S", 16, 32.06);
        periodicTable[16] = new PeriodicNonMetal("Cl", 17, 35.45);
        periodicTable[17] = new PeriodicNonMetal("Ar", 18, 39.948);
        periodicTable[33] = new PeriodicNonMetal("Se", 34, 78.971);
        periodicTable[34] = new PeriodicNonMetal("Br", 35, 79.904);
        periodicTable[35] = new PeriodicNonMetal("Kr", 36, 83.798);
        //metals
        periodicTable[2] = new PeriodicMetal("Li", 3, 6.94);
        periodicTable[3] = new PeriodicMetal("Be", 4, 9.0122);
        periodicTable[4] = new PeriodicMetal("Bo", 5, 10.81);
        periodicTable[10] = new PeriodicMetal("Na", 11, 22.99);
        periodicTable[11] = new PeriodicMetal("Mg", 12, 24.305);
        periodicTable[12] = new PeriodicMetal("Al", 13, 26.982);
        periodicTable[13] = new PeriodicMetal("Si", 14, 28.085);
        periodicTable[18] = new PeriodicMetal("K", 19, 39.098);
        periodicTable[19] = new PeriodicMetal("Ca", 20, 40.078);
        periodicTable[20] = new PeriodicMetal("Sc", 21, 44.956);
        periodicTable[21] = new PeriodicMetal("Ti", 22, 47.867);
        periodicTable[22] = new PeriodicMetal("V", 23, 50.942);
        periodicTable[23] = new PeriodicMetal("Cr", 24, 51.996);
        periodicTable[24] = new PeriodicMetal("Mn", 25, 54.938);
        periodicTable[25] = new PeriodicMetal("Fe", 26, 55.845);
        periodicTable[26] = new PeriodicMetal("Co", 27, 58.933);
        periodicTable[27] = new PeriodicMetal("Ni", 28, 58.693);
        periodicTable[28] = new PeriodicMetal("Cu", 29, 63.546);
        periodicTable[29] = new PeriodicMetal("Zn", 30, 65.38);
        periodicTable[30] = new PeriodicMetal("Ga", 31, 69.723);
        periodicTable[31] = new PeriodicMetal("Ge", 32, 72.63);
        periodicTable[32] = new PeriodicMetal("As", 33, 74.922);
    }


    public static void main(String[] args){
    Periodic[] periodicTable = new Periodic[36];
    PeriodicNonMetal hydrogen = new PeriodicNonMetal("H", 1, 1.008);
    initElements(periodicTable);
    for (int i = 0; i < periodicTable.length; i++) {
        System.out.println(periodicTable[i].toString());
        periodicTable[i].describeElement();
        }
    System.out.println(hydrogen.equals(periodicTable[0]));
    }

}