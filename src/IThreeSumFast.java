/**
 * Created by Xue on 2015/1/8.
 */

import java.util.Arrays;

public class IThreeSumFast {

    public static int count(int[] a){
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for(int i=0; i < N; i++)
            for(int j = i+1; j < N; j++)
                if(ImplementBinarySearch.rank(-a[i]-a[j],a) > j)
                    cnt++;
        return cnt;
    }

    public static void main(String[] args){
        int[] a = IReadInts.readInts(args[0]);
        StdOut.println(count(a));
    }
}
