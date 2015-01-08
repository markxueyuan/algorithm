/**
 * Created by Xue on 2015/1/6.
 */
public class IFixedCapacityStackOfStrings {
    private String[] a;
    private int N;

    public IFixedCapacityStackOfStrings(int cap){
        a = new String[cap];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void push(String item){
        a[N++] = item;
    }

    public String pop(){
        return a[--N];
    }

    public String toString(){
        String s = "";
        for(int i = 0; i < N; i++){
            s = s + a[i] +", ";
        }
        return s;
    }

    public static void main(String[] args){
        IFixedCapacityStackOfStrings s = new IFixedCapacityStackOfStrings(20);

        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-"))
                s.push(item);
            else if(!s.isEmpty()) StdOut.println(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack.): " + s);

    }
}
