/**
 * Created by Xue on 2015/1/13.
 */
public class IQuickSort3Way {

    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo) return;
        int lt = lo, i = lo+1, gt = hi;
        Comparable v = a[lo];
        while(i <= gt){
            int comp = a[i].compareTo(v);
            if(comp < 0) exch(a, lt++, i++);
            else if(comp > 0) exch(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        Integer[] a = new Integer[N];

        for(int i = 0; i < N; i++){
            a[i] = i;
        }

        IStopWatch timer = new IStopWatch();
        sort(a);
        StdOut.println(timer.elapsedTime());
    }

}
