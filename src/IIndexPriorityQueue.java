/**
 * Created by Xue on 2015/1/14.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;


public class IIndexPriorityQueue<Key extends Comparable<Key>>{

    private int NMax;
    private int N;
    private int[] pq;
    private int[] qp;
    private Key[] keys;

    public IIndexPriorityQueue(int NMax){
        if(NMax < 0) throw new IllegalArgumentException();
        this.NMax = NMax;
        keys = (Key[]) new Comparable[NMax+1];
        pq = new int[NMax+1];
        qp = new int[NMax+1];

        for(int i = 0; i <= NMax; i++)
            qp[i] = -1;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public boolean contains(int i){
        if(i < 0 || i >= NMax) throw new IndexOutOfBoundsException();
        return qp[i] != -1;
    }

    public int size(){
        return N;
    }

    public void insert(int i, Key key){
        if(i < 0 || i >= NMax) throw new IndexOutOfBoundsException();
        if(contains(i)) throw new IllegalArgumentException();
        N++;
        qp[i] = N;
        pq[N] = i;
        keys[i] = key;
        swim(N);
    }

    public int minIndex(){
        if(N==0) throw new NoSuchElementException("Priority Queue underflow");
        return pq[1];
    }

    public Key minKey(){
        if(N==0) throw new NoSuchElementException("Priority Queue underflow");
        return keys[pq[1]];
    }

    public int delMin(){
        if(N == 0) throw new NoSuchElementException("Priority Queue underflow");
        int min = pq[1];
        exch(1, N--);
        sink(1);
        qp[min] = -1;
        keys[pq[N+1]] = null;
        pq[N+1] = -1;
        return min;
    }

    public Key keyof(int i){
        if(i < 0 || i >= NMax) throw new IndexOutOfBoundsException();
        if(!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        else return keys[i];
    }

    public void change(int i, Key key){
        if (i < 0 || i >= NMax) throw new IndexOutOfBoundsException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        keys[i] = key;
        swim(qp[i]);
        sink(qp[i]);
    }

    public void delete(int i){
        if (i < 0 || i >= NMax) throw new IndexOutOfBoundsException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        int index = qp[i];
        exch(index, N--);
        swim(index);
        sink(index);
        keys[i] = null;
        qp[i] = -1;
    }

    private void swim(int k)  {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean greater(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void exch(int i, int j) {
        int swap = pq[i]; pq[i] = pq[j]; pq[j] = swap;
        qp[pq[i]] = i; qp[pq[j]] = j;
    }


}
