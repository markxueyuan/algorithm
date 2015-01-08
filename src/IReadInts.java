/**
 * Created by Xue on 2015/1/6.
 */
public class IReadInts {

    public static int[] readInts(String name){
        In in = new In(name);
        Queue<Integer> q = new Queue<Integer>();

        while(!in.isEmpty())
            q.enqueue(in.readInt());

        int N = q.size();
        int[] a = new int[N];

        for(int i = 0; i < N; i++)
            a[i] = q.dequeue();
        return a;
    }

    public static void main(String[] args){
        String name = args[0];
        int second = readInts(name)[1];
        StdOut.println(second);
    }
}
