/**
 * Created by Xue on 2015/1/22.
 */
public class ILinearProbingHashST<Key, Value> {
    private int N;
    private int M = 16;
    private Key[] keys;
    private Value[] vals;

    public ILinearProbingHashST(){
        keys = (Key[])new Object[M];
        vals = (Value[])new Object[M];
    }

    public ILinearProbingHashST(int cap){
        keys = (Key[])new Object[cap];
        vals = (Value[])new Object[cap];
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int cap){
        ILinearProbingHashST<Key, Value> t = new ILinearProbingHashST<Key, Value>(cap);
        for(int i = 0; i < M; i++){
            if(keys[i] != null) t.put(keys[i], vals[i]);
        }
        keys = t.keys;
        vals = t.vals;
        M = t.M;
    };

    public void put(Key key, Value val){
        if(N >= M/2) resize(2*M);

        int i;
        for(i = hash(key); keys[i] != null; i = (i + 1) % M)
            if(keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key){
        for(int i = hash(key); keys[i] != null; i = (i + 1) % M)
            if(keys[i].equals(key))
                return vals[i];
        return null;
    }

    public boolean contains(Key key){
        if(get(key) != null) return true;
        else return false;
    }

    public void delete(Key key){
        if(!contains(key)) return;
        int i = hash(key);
        while(!key.equals(keys[i]))
            i = (i+1) % M;
        keys[i] = null;
        vals[i] = null;
        i = (i+1) % M;
        while(keys[i] != null){
            Key keyToRedo = keys[i];
            Value valToRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(keyToRedo, valToRedo);
            i = (i+1) % M;
        }
        N--;
        if(N > 0 && N == M/8) resize(M/2);
    }

    public static void main(String[] args){
        ILinearProbingHashST<String, Integer> a = new ILinearProbingHashST<String, Integer>();
        a.put("a", 2);
        a.put("b", 3);
        a.put("c", 4);
        StdOut.println(a.get("b"));
    }

}
