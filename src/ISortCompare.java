/**
 * Created by Xue on 2015/1/11.
 */
public class ISortCompare {

    public static double time(String alg, Comparable[] a){

        IStopWatch timer = new IStopWatch();

        if(alg.equals("Insertion")) IInsertionSort.sort(a);
        if(alg.equals("Selection")) ISelectionSort.sort(a);
        if(alg.equals("Shell")) IShellSort.sort(a);
        if(alg.equals("Merge")) IMergeSortTopDown.sort(a);
        if(alg.equals("Merge2")) IMergeSortBottomUp.sort(a);
        if(alg.equals("Quick")) IQuickSortHoare.sort(a);
        if(alg.equals("Quick3Way")) IQuickSort3Way.sort(a);
        if(alg.equals("Heap")) Heap.sort(a);

        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T){

        double total = 0.0;
        Double[] a = new Double[N];

        for(int t = 0; t < T; t++){
            for(int i = 0; i < N; i++)
                a[i] = StdRandom.uniform();
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args){
        String alg1 = args[0];
        String alg2 = args[1];

        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);

        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);

        StdOut.printf("For %d random Doubles\n %s is ", N, alg1);
        StdOut.printf("%.1f times faster than %s", t2/t1, alg2);

    }

}
