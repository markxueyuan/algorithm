/**
 * Created by Xue on 2015/1/8.
 */
public class IDoublingRatio {
    public static double timeTrial(int N){

        int MAX = 1000000;
        int[] a = new int[N];

        for(int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-MAX,MAX);

        IStopWatch timer = new IStopWatch();
        IThreeSumFast.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args){

        double prev = timeTrial(125);
        for(int N = 250; true; N += N){
            double time = timeTrial(N);
            StdOut.printf("%d6 %7.1f", N, time);
            StdOut.printf("%5.1f\n", time/prev);
            prev = time;
        }
    }
}
