/**
 * Created by Xue on 2015/1/15.
 */

import java.util.Comparator;

public class ISortAny {
    public static void sort(Object[] a, Comparator c){
        int N = a.length;
        for(int i = 1; i < N; i++){
            for(int j = i; j > 0 && less(c, a[j], a[j-1]); j--)
                exch(a, j, j-1);
        }
    }

    private static boolean less(Comparator c, Object v, Object w){
        return c.compare(v, w) < 0;
    }

    private static void exch(Object[] a, int i, int j){
        Object t = a[i]; a[i] = a[j]; a[j] = t;
    }

    public static void main(String[] args){
        String[] a = {"lunar", "eclipse", "was", "considered", "no", "less", "an", "omen", "of", "evil", "doings"};
        sort(a, new ICompareBySecondChar());
        int N = a.length;

        for(int i = 0; i < N; i++){
            StdOut.println(a[i]);
        }
    }
}
