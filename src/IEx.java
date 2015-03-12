/**
 * Created by Xue on 2015/1/6.
 */
public class IEx<Key> {

    private static String a = "hzelloha";
    private static String b = "zelloha";

    private static String[] c = {"hzelloha", "zelloha", "abc", "def"};

    private static void insertion(String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1], d); j--)
                exch(a, j, j-1);
    }

    private static boolean less(String v, String w, int d) {
        assert v.substring(0, d).equals(w.substring(0, d));
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i)) return true;
            if (v.charAt(i) > w.charAt(i)) return false;
        }
        return v.length() < w.length();
    }


    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int tryTryTry(){
        for(int i = 0; i < 5; i++)
            return i;
        return 1000;
    }


    public static void main(String[] args){
        insertion(c, 0, c.length-1, 0);
        for(int i = 0; i < c.length; i++)
            StdOut.println(c[i]);
        char u = 25;
        StdOut.println("here it is " + u);

        StdOut.println(tryTryTry());
    }
}
