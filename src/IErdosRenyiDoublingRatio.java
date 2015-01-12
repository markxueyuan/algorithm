/**
 * Created by Xue on 2015/1/10.
 */
public class IErdosRenyiDoublingRatio {

    public static void main(String[] args){

        IStopWatch timer = new IStopWatch();
        IErdosRenyi.count(10);
        double prev = timer.elapsedTime();

        for(int N = 20; true; N += N){
            timer = new IStopWatch();
            IErdosRenyi.count(N);
            double now = timer.elapsedTime();
            double ratio = now/prev;
            StdOut.println(N + " " + ratio);
            prev = now;
        }
    }
}
