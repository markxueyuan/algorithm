/**
 * Created by Xue on 2015/1/16.
 */
public class CSTTestClient {

    public static void main(String[] args){
        ST<String, Integer> st = new ST<String, Integer>();

        for(int i = 0; !StdIn.isEmpty(); i++){
            String key = StdIn.readString();
            st.put(key, i);
        }

        for(String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
