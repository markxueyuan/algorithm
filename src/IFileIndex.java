/**
 * Created by Xue on 2015/1/23.
 */

import java.io.File;

public class IFileIndex {
    public static void main(String[] args){
        ST<String, SET<File>> st = new ST<String, SET<File>>();

        for(String filename :args){
            File file = new File(filename);
            In in = new In(file);
            while(!in.isEmpty()){
                String word = in.readString();
                if(!st.contains(word))
                    st.put(word, new SET<File>());
                SET<File> set = st.get(word);
                set.add(file);
            }
        }

        while(!StdIn.isEmpty()){
            String query = StdIn.readString();
            if(st.contains(query))
                for(File file : st.get(query))
                    StdOut.println(" " + file.getName());
        }
    }
}
