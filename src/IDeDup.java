import java.util.HashSet;

/**
 * Created by Xue on 2015/1/23.
 */
public class IDeDup {

    public static void main(String[] args){
        HashSet<String> set = new HashSet<String>();
        while(!StdIn.isEmpty()){
            String key = StdIn.readString();
            if(!set.contains(key)){
                set.add(key);
                StdOut.println(key + " ");
            }
        }
    }
}
