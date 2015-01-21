/**
 * Created by Xue on 2015/1/6.
 */
public class IEx<Key> {

    private Key[] a;

    public IEx(){
        a = (Key[]) new Object[5];
    }

    public void add(Key key){
        a[0] = key;
        a[1] = key;
        a[2] = key;
        a[3] = key;
        a[4] = key;
    }

    public Key getSecond(){
        return a[1];
    }



    public static void main(String[] args){

        IEx<String> a = new IEx<String>();
        a.add("hello");
        StdOut.println(a.getSecond());

    }
}
