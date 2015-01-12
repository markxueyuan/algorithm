/**
 * Created by Xue on 2015/1/9.
 */
public class IRandomConnections {

    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        StdOut.println(N);

        for(int i = 0; i < N; i++){
            int r = 0;
            int q = 0;
            while(r == q){
                r = StdRandom.uniform(0, N);
                q = StdRandom.uniform(0, N);
            }
            StdOut.println(r + " " + q);
        }
    }
}
