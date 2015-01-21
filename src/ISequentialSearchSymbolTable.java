/**
 * Created by Xue on 2015/1/16.
 */
public class ISequentialSearchSymbolTable<Key, Value> {

    private Node first;

    private class Node{
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next){

            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Value get(Key key){
        for(Node x = first; x != null; x = x.next){

            if(key.equals(x.key))
                return x.value;
        }

        return null;
    }

    public void put(Key key, Value value){
        for(Node x = first; x != null; x = x.next)
            if(key.equals(x.key)){
                x.value = value;
                return;
            }
        first = new Node(key, value, first);
    }

    public int size(){
        int cnt = 0;
        for(Node x = first; x != null; x = x.next)
            cnt++;
        return cnt;
    }

    public void delete(Key key){
        if(key.equals(first.key)) {
            first = first.next;
            return;
        }

        for(Node x = first; x != null; x = x.next){
            Node y = x.next;
            if(key.equals(y.key)){
                x.next = y.next;
                return;
            }
        }
        throw new java.util.NoSuchElementException();

    }

    public Key[] keys(){
        int N = size();
        Key[] a = (Key[])new Object[N];
        int i = 0;
        for(Node x = first; x != null; x = x.next){
            a[i] = x.key;
            i++;
        }
        return a;
    }

    public static void main(String[] args){

        ISequentialSearchSymbolTable<String, Integer> s = new ISequentialSearchSymbolTable<String, Integer>();
        s.put("a", 2);
        s.put("b", 3);
        s.put("c", 4);
        s.put("d", 5);
        s.put("a", 100);
        s.delete("a");
        s.keys();
        Object[] a = s.keys();
        int cnt = a.length;
        for(int i = 0; i < cnt; i++){
            StdOut.println(a[i]);
        }
        StdOut.println(s.size());
    }



}
