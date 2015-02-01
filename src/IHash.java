/**
 * Created by Xue on 2015/1/22.
 */
public class IHash<Key extends Comparable<Key>> {

    int M;

    public IHash(int M){
        this.M = M;
    }

    public int hash(Key x){

        return (x.hashCode() & 0x7fffffff) % M;
    }

    public static void main(String[] args){
        int M = Integer.parseInt(args[0]);
        IHash h = new IHash(M);
        String[] a = {"S", "E", "A", "R", "C", "H", "X", "M", "P", "L"};
        for(int i = 0; i < a.length; i++){
            StdOut.println(h.hash(i));
        }
    }
}
