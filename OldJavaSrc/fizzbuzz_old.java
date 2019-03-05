public class fizzbuzz_old {

    public static void main (String[] args) {
        for (int i = 1; i < 101; i++) {
            int fizz = i % 3;
            int buzz = i % 5;
            if (fizz == 0 && buzz != 0) {
                System.out.printf("%d  fizz\n",i);
            }
            else if (fizz != 0 && buzz == 0){
                System.out.printf("%d  buzz\n",i);
            }
            else if (fizz == 0 && buzz == 0){
                System.out.printf("%d  fizzbuzz\n",i);
            }
            else {
                System.out.printf("%d\n",i);
            }
        }
    }
}
