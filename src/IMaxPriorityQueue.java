/**
 * Created by Xue on 2015/1/14.
 */
public class IMaxPriorityQueue<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N = 0;

    public IMaxPriorityQueue(int maxN){
        pq = (Key[])new Comparable[maxN+1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j){
        Key t = pq[i]; pq[i] = pq[j]; pq[j] = t;
    }

    private void swim(int k){
        while(k > 1 && less(k/2, k))
            exch(k/2, k);
    }

    private void sink(int k){
        while(2*k <= N){
            int j = 2*k;
            if(j < N && less(j, j+1)) j++;
            if(!less(k,j)) break;
            exch(k, j);
            k = j;
        }
    }

    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    public Key delMax(){
        Key max = pq[1];
        exch(1, N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }

    public static void main(String[] args){
        IMaxPriorityQueue<String> pq = new IMaxPriorityQueue<String>(100);
        pq.insert("a");
        pq.insert("b");
        pq.insert("x");
        pq.insert("z");
        StdOut.println(pq.delMax());
    }
}
