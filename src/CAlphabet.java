/**
 * Created by Xue on 2015/2/28.
 */
public class CAlphabet {

    public static void main(String[] args){
        StdOut.println("a".charAt(0) == 0);
        char b = "ab".charAt(1);
        int[] inverse =new int[Character.MAX_VALUE];
        inverse[b] = 2;
        StdOut.println(inverse[b]);
        StdOut.println(inverse.length);
    }
}
