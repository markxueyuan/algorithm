/**
 * Created by Xue on 2015/1/8.
 * Assumpts that integers in a are unique.
 */

import java.util.Arrays;
public class ITwoSumFast {

    public static int count(int[] a){

        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for(int i = 0; i < N; i++)
            if(ImplementBinarySearch.rank(-a[i], a) > i)
                cnt++;
        return cnt;
    }

    public static void main(String[] args){
        int[] a = IReadInts.readInts(args[0]);
        StdOut.println(count(a));
    }
}
