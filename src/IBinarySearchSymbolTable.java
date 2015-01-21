import java.util.NoSuchElementException;

/**
 * Created by Xue on 2015/1/17.
 */
public class IBinarySearchSymbolTable<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] vals;
    private int N;

    public IBinarySearchSymbolTable(int capacity){

        keys = (Key[])new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size(){
        return N;
    }

    public Value get(Key key){

        if(isEmpty()) return null;
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0) return vals[i];
        else return null;
    }

    public int rank(Key key){
        int lo = 0, hi = N -1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp < 0) hi = mid - 1;
            else if(cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public void put(Key key, Value val){

        int i = rank(key);

        if(i < N && keys[i].compareTo(key) == 0){
            vals[i] = val;
            return;
        }

        for(int j = N; j > i; j--){
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public void delete(Key key){

        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0){
            boolean test = i == N-1;
            if(i == N-1) {keys[i] = null; vals[i] = null; N--; return;}
            for(int j = i+1; j < N; j++){
                keys[j-1] = keys[j];
                vals[j-1] = vals[j];
            }
            N--;
        }
        else throw new NoSuchElementException();
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public Key min(){
        return keys[0];
    }

    public Key max(){
        return keys[N-1];
    }

    public Key select(int k){
        return keys[k];
    }

    public Key ceiling(Key key){
        int i = rank(key);
        return keys[i];
    }

    public Key floor(Key key){
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0)
            return key;
        else return keys[i-1];
    }

    public boolean test(Key key){
        int i = rank(key);
        return i < N && keys[i].compareTo(key) == 0;
    }

    public static void main(String[] args){
        IBinarySearchSymbolTable<String, Integer> st = new IBinarySearchSymbolTable(100);
        st.put("abc", 3);
        st.put("hehe", 4);
        st.put("foo", 5);
        StdOut.println(st.get("hehe"));
        st.delete("hehe");
        StdOut.println(st.get("hehe"));
        st.delete("abc");
        StdOut.println(st.size());

    }




}
