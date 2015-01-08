/**
 * Created by Xue on 2015/1/7.
 */
public class IThreeSum {
    public static int count(int[] a){
        int N = a.length;
        int cnt = 0;
        for(int i = 0; i < N; i++)
            for(int j = i+1; j < N; j++)
                for(int k = j+1; k < N; k++)
                    if(a[i] + a[k] + a[j] == 0) cnt++;
        return cnt;
    }

    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        int[] a = new int[N];
        for(int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-1000000,1000000);
        IStopWatch timer = new IStopWatch();
        int cnt = IThreeSum.count(a);
        double time = timer.elapsedTime();
        StdOut.println(cnt + " triples " + time + " seconds ");
    }
}
