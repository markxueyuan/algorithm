import java.util.HashSet;

/**
 * Created by Xue on 2015/1/23.
 */
public class IWhiteFilter {

    public static void main(String[] args){
        HashSet<String> set = new HashSet<String>();
        In in = new In(args[0]);
        while(!in.isEmpty())
            set.add(in.readString());
        while(!StdIn.isEmpty()){
            String word = StdIn.readString();
            if(set.contains(word))
                StdOut.print(word + " ");
        }
    }
}
