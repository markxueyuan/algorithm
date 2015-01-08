/**
 * Created by Xue on 2015/1/8.
 */
public class ITwoSum {
    public static int count(int[] a){
        int N = a.length;
        int cnt = 0;
        for(int i = 0; i < N; i++)
            for(int j = i + 1; j < N; j++)
                if(a[i] + a[j] == 0) cnt++;
        return cnt;
    }

    public static void main(String[] args){
        int[] a = IReadInts.readInts(args[0]);
        StdOut.println(count(a));
    }
}
