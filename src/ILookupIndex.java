/**
 * Created by Xue on 2015/1/23.
 */
public class ILookupIndex {

    public static void main(String[] args){
        In in = new In(args[0]);
        String sp = args[1];

        ST<String, Queue<String>> st = new ST<String, Queue<String>>();
        ST<String, Queue<String>> ts = new ST<String, Queue<String>>();

        while(in.hasNextLine()){
            String line = in.readLine();
            String[] a = line.split(sp);
            String key = a[0];
            if(!st.contains(key)) st.put(key, new Queue<String>());

            for(int i = 1; i < a.length; i++){
                String val = a[i];
                if(!ts.contains(val)) ts.put(val, new Queue<String>());
                st.get(key).enqueue(val);
                ts.get(val).enqueue(key);
            }
        }

        while(!StdIn.isEmpty()){
            String query = StdIn.readString();
            if(st.contains(query)){
                Queue<String> q = st.get(query);
                for(String s : q)
                    StdOut.println("  " + s);
            }

            if(ts.contains(query)){
                Queue<String> q = ts.get(query);
                for(String s : q)
                    StdOut.println("  " + s);
            }
        }
    }
}
