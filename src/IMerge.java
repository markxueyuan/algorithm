/**
 * Created by Xue on 2015/1/11.
 */
public class IMerge {

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i] + " ");
        StdOut.println();
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi){

        int i = lo; int j = mid + 1;
        int N = a.length;
        Comparable[] aux = new Comparable[N];

        for(int k = lo; k <= hi; k++)
            aux[k] = a[k];

        for(int k = lo; k <= hi; k++){
            if(i > mid) a[k] = aux[j++];
            else if(j > hi) a[k] =aux[i++];
            else if(less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    public static void main(String[] args){

        Integer[] a = {0, 2, 4, 6, 8, 1, 3, 5, 7, 9};
        merge(a, 0, 4, 9);
        show(a);
    }
}
