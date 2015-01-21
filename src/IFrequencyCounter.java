/**
 * Created by Xue on 2015/1/16.
 */
public class IFrequencyCounter {

    public static void main(String[] args){

        int minLength = Integer.parseInt(args[0]);
        ST<String, Integer> st = new ST<String, Integer>();

        while(!StdIn.isEmpty()){
            String word = StdIn.readString();
            if(word.length() < minLength) continue;
            if(!st.contains(word)) st.put(word, 1);
            else st.put(word, st.get(word) + 1);
        }

        String max = "";
        st.put(max, 0);

        for(String word : st.keys())
            if(st.get(word) > st.get(max))
                max = word;

        StdOut.println(max + " " + st.get(max));
    }
}
