public class GFG
{
    // Method to print the string
    static String printQuestion(String str, char ch, int count) {
        String question;
        int occ = 0, i;
        if (count == 0) {
            question = str;
        }
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                occ++;
            }
            if (occ == count) {
                break;
            }
        }
        if (i < str.length() - 1) {
            question = str.substring(i + 2);
        } else {
            question = "";
        }
        return question;
    }

    static void yo(String str, char ch, int count) {
        String question;
        int occ = 0, i;
        if (count == 0) {
            System.out.println(str);
            return;
        }
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                occ++;
            }
            if (occ == count) {
                break;
            }
        }
        if (i < str.length() - 1) {
            System.out.println(str.substring(i + 1));
        } else {
            System.out.println("Empty string");
        }
    }

    // Driver Method
    public static void main(String[] args)
    {
        String str = "false | q10";
        System.out.println(printQuestion(str, '|', 1));
        yo(str, '|', 1);
    }
}