/**
 * Created by Xue on 2015/1/15.
 */
public class ISelect {

    public static Comparable select(Comparable[] a, int k){
        StdRandom.shuffle(a);
        int lo = 0, hi = a.length - 1;
        while(hi > lo){
            int j = partition(a, lo, hi);
            if(j==k) return a[k];
            else if(j > k) hi = j - 1;
            else if(j < k) lo = j + 1;
        }

        return a[k];
    }

    private static int partition(Comparable[] a, int lo, int hi){

        int i = lo, j = hi+1;
        Comparable v = a[lo];
        while(true){
            while(less(a[++i], v)) if(i == hi) break;
            while(less(v, a[--j])) if(j == lo) break;
            if(i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args){
        Integer[] a = {2, 4, 5, 6, 7, 8};
        StdOut.println(select(a, 2));
    }
}
