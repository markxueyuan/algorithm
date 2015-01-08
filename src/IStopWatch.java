/**
 * Created by Xue on 2015/1/7.
 */
public class IStopWatch {

    private final long start;

    public IStopWatch(){
        start = System.currentTimeMillis();
    }

    public double elapsedTime(){
        long now = System.currentTimeMillis();
        return (now - start) / 1000;
    }

    public static void main(String[] args){
        IStopWatch w = new IStopWatch();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            }
        StdOut.println(w.elapsedTime());
    }
}
