/**
 * Created by Xue on 2015/3/1.
 */
public class ICount {
    public static void main(String[] args){
        Alphabet alpha = new Alphabet(args[0]);
        int R = alpha.R();
        int[] count = new int[R];

        String s = StdIn.readAll();
        int N = s.length();

        for(int i = 0; i < N; i++)
            if(alpha.contains(s.charAt(i)))
                count[alpha.toIndex(s.charAt(i))]++;

        for(int c = 0; c < R; c++)
            StdOut.println(alpha.toChar(c) + " " + count[c]);
    }
}
