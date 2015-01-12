/**
 * Created by Xue on 2015/1/9.
 */
public class IErdosRenyi {

    public static int count(int N){

        int B = N;

        int cnt = 0;
        IUnionFindWeightedQuickUnion uf = new IUnionFindWeightedQuickUnion(N);

        while(N != 1){
            int p = StdRandom.uniform(0, B);
            int q = StdRandom.uniform(0, B);
            cnt++;

            if(uf.connected(p, q)) continue;
            uf.union(p, q);
            N--;
        }

        return cnt;
    }

    public static void main(String[] args){

        int N = Integer.parseInt(args[0]);
        StdOut.println(count(N));
    }
}
