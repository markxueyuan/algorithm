/**
 * Created by Xue on 2015/1/22.
 */
public class ISeparateChainingHashST<Key, Value> {
    private int N; //number of key-value pairs
    private int M; //hash table size
    private SequentialSearchST<Key, Value>[] st;

    public ISeparateChainingHashST(){
        this(997);
    }

    public ISeparateChainingHashST(int M){
        this.M = M;
        st = (SequentialSearchST<Key, Value>[])new SequentialSearchST[M];
        for(int i = 0; i < M; i++){
            st[i] = new SequentialSearchST();
        }
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key){
        return (Value) st[hash(key)].get(key);
    }

    public void put(Key key, Value val){
        st[hash(key)].put(key, val);
    }
}
