import java.nio.ByteBuffer;
public class music {
    public static void main (String[] args) {
        for (char t=0;; t++) {
            ByteBuffer.putChar(
            (char)t*(((char)t>>(char)12|(char)t>>(char)8)&(char)63&(char)4>>(char)t)
                    );
        }
    }
}
