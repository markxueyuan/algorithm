/**
 * Created by Xue on 2015/1/8.
 */
public class IDoublingTest {

    public static double timeTrial(int N){
        int MAX = 1000000;
        int[] a = new int[N];
        for(int i = 0; i < N; i++){
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        IStopWatch timer = new IStopWatch();
        int cnt = IThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args){
        for(int N = 250; true; N += N){
            double time = timeTrial(N);
            StdOut.printf("%7d %5.1f\n", N, time);
        }
    }
}
