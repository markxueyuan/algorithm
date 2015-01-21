/**
 * Created by Xue on 2015/1/20.
 */
public class IBinarySearchTree<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node{

        private Key key;
        private Value value;
        private Node left, right;
        private int N;

        public Node(Key key, Value value, int N){
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if (x == null) return 0; 
        else return x.N;
    }

    public Value get(Key key){
        return get(root, key);
    }

    private Value get(Node x, Key key){

        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if(cmp > 0) return get(x.right, key);
        else return x.value;
    }

    public void put(Key key, Value value){
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value){
        if(x == null) return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = put(x.left, key, value);
        else if(cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min(){
        return min(root).key;
    }

    private Node min(Node x){
        if(x.left == null) return x;
        return min(x.left);
    }

    public Key max(){
        return max(root).key;
    }

    private Node max(Node x){
        if(x.right == null) return x;
        return max(x.right);
    }

    public Key floor(Key key){
        return floor(root, key).key;
    }

    private Node floor(Node x, Key key){

        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) return floor(x.left, key);
        else if(cmp > 0){
            Node r = floor(x.right, key);
            if(r == null) return x;
            else return r;
        }
        else return x;
    }

    public Key select(int n){
        return select(root, n).key;
    }

    private Node select(Node x, int k){
        if(x == null) return null;
        int n = size(x.left);
        if(k < n) return select(x.left, k);
        else if(k > n) return select(x.right, k-n-1);
        else return x;
    }

    public int rank(Key key){
        return rank(root, key);
    }

    private int rank(Node x, Key key){
        if(x == null) return 0;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) return rank(x.left, key);
        else if(cmp > 0) return rank(x.right, key) + size(x.left) + 1;
        else return size(x.left);
    }

    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node x){
        if(x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) +size(x.right) + 1;
        return x;
    }

    public void delete(Key key){
        root = delete(root, key);
    }

    // In memory of Hibbard

    public Node delete(Node x, Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = delete(x.left, key);
        else if(cmp > 0) x.right = delete(x.right, key);
        else {
            if(x.left == null) return x.right;
            if(x.right == null) return x.left;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void print(){
        print(root);
    }

    public void print(Node x){
        if(x == null) return;
        print(x.left);
        StdOut.println(x.key);
        print(x.right);
    }

    public Iterable<Key> keys(){
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi){
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi){
        if(x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if(cmphi > 0) keys(x.right, queue, lo, hi);
    }

    public static void main(String[] args){
        IBinarySearchTree<String, Integer> bst = new IBinarySearchTree<String, Integer>();
        bst.put("a", 2);
        bst.put("b", 3);
        bst.put("c", 4);
        bst.print();
        StdOut.println(bst.get("a"));
        StdOut.println(bst.size());
    }
}
