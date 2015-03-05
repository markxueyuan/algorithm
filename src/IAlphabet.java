/*************************************************************************
 *  Compilation:  javac Alphabet.java
 *  Execution:    java  Alphabet
 *
 *  A data type for alphabets, for use with string-processing code
 *  that must convert between an alphabet of size R and the integers
 *  0 through R-1.
 *
 *  Warning: supports only the basic multilingual plane (BMP), i.e,
 *           Unicode characters between U+0000 and U+FFFF.
 *
 *************************************************************************/

public class IAlphabet {
    public static final IAlphabet BINARY         = new IAlphabet("01");
    public static final IAlphabet OCTAL          = new IAlphabet("01234567");
    public static final IAlphabet DECIMAL        = new IAlphabet("0123456789");
    public static final IAlphabet HEXADECIMAL    = new IAlphabet("0123456789ABCDEF");
    public static final IAlphabet DNA            = new IAlphabet("ACTG");
    public static final IAlphabet LOWERCASE      = new IAlphabet("abcdefghijklmnopqrstuvwxyz");
    public static final IAlphabet UPPERCASE      = new IAlphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    public static final IAlphabet PROTEIN        = new IAlphabet("ACDEFGHIKLMNPQRSTVWY");
    public static final IAlphabet BASE64         = new IAlphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
    public static final IAlphabet ASCII          = new IAlphabet(128);
    public static final IAlphabet EXTENDED_ASCII = new IAlphabet(256);
    public static final IAlphabet UNICODE16      = new IAlphabet(65536);

    private char[] alphabet;     // the characters in the alphabet
    private int[] inverse;       // indices
    private int R;               // the radix of the alphabet

    // Create a new Alphabet from sequence of characters in string.
    public IAlphabet(String alpha) {

        // check that alphabet contains no duplicate chars
        boolean[] unicode = new boolean[Character.MAX_VALUE];
        for (int i = 0; i < alpha.length(); i++) {
            char c = alpha.charAt(i);
            if (unicode[c])
                throw new IllegalArgumentException("Illegal alphabet: repeated character = '" + c + "'");
            unicode[c] = true;
        }

        alphabet = alpha.toCharArray();
        R = alpha.length();
        inverse = new int[Character.MAX_VALUE];
        for (int i = 0; i < inverse.length; i++)
            inverse[i] = -1;

        // can't use char since R can be as big as 65,536
        for (int c = 0; c < R; c++)
            inverse[alphabet[c]] = c;
    }

    // Create a new Alphabet of Unicode chars 0 to R-1
    private IAlphabet(int R) {
        alphabet = new char[R];
        inverse = new int[R];
        this.R = R;

        // can't use char since R can be as big as 65,536
        for (int i = 0; i < R; i++)
            alphabet[i] = (char) i;
        for (int i = 0; i < R; i++)
            inverse[i] = i;
    }

    // Create a new Alphabet of Unicode chars 0 to 255 (extended ASCII)
    public IAlphabet() {
        this(256);
    }

    // is character c in the alphabet?
    public boolean contains(char c) {
        return inverse[c] != -1;
    }

    // return radix R
    public int R() {
        return R;
    }

    // return number of bits to represent an index
    public int lgR() {
        int lgR = 0;
        for (int t = R-1; t >= 1; t /= 2)
            lgR++;
        return lgR;
    }

    // convert c to index between 0 and R-1.
    public int toIndex(char c) {
        if (c < 0 || c >= inverse.length || inverse[c] == -1) {
            throw new IllegalArgumentException("Character " + c + " not in alphabet");
        }
        return inverse[c];
    }

    // convert String s over this alphabet into a base-R integer
    public int[] toIndices(String s) {
        char[] source = s.toCharArray();
        int[] target  = new int[s.length()];
        for (int i = 0; i < source.length; i++)
            target[i] = toIndex(source[i]);
        return target;
    }

    // convert an index between 0 and R-1 into a char over this alphabet
    public char toChar(int index) {
        if (index < 0 || index >= R) {
            throw new IndexOutOfBoundsException("Alphabet index out of bounds");
        }
        return alphabet[index];
    }

    // Convert base-R integer into a String over this alphabet
    public String toChars(int[] indices) {
        StringBuilder s = new StringBuilder(indices.length);
        for (int i = 0; i < indices.length; i++)
            s.append(toChar(indices[i]));
        return s.toString();
    }


    public static void main(String[] args) {
        int[]  encoded1 = Alphabet.BASE64.toIndices("NowIsTheTimeForAllGoodMen");
        String decoded1 = Alphabet.BASE64.toChars(encoded1);
        for(int i = 0; i < encoded1.length; i++)
            StdOut.print(encoded1[i] + " ");
        StdOut.println();
        StdOut.println(decoded1);

        int[]  encoded2 = Alphabet.DNA.toIndices("AACGAACGGTTTACCCCG");
        String decoded2 = Alphabet.DNA.toChars(encoded2);
        for(int i = 0; i < encoded2.length; i++)
            StdOut.print(encoded2[i] + " ");
        StdOut.println();
        StdOut.println(decoded2);

        int[]  encoded3 = Alphabet.DECIMAL.toIndices("01234567890123456789");
        String decoded3 = Alphabet.DECIMAL.toChars(encoded3);
        for(int i = 0; i < encoded3.length; i++)
            StdOut.print(encoded3[i] + " ");
        StdOut.println();
        StdOut.println(decoded3);
    }
}