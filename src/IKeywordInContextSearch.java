/**
 * Created by Xue on 2015/3/13.
 */
public class IKeywordInContextSearch {

    public static void main(String[] args){
        In in = new In(args[0]);
        int context = Integer.parseInt(args[1]);

        String text = in.readAll().replaceAll("\\s+", " ");

        int N = text.length();

        ISuffixArray sa = new ISuffixArray(text);

        while(StdIn.hasNextLine()){

            String q = StdIn.readLine();

            for(int i = sa.rank(q); i < N && sa.select(i).startsWith(q); i++){
                int from = Math.max(0, sa.index(i) - context);
                int to = Math.min(N-1, from + q.length() + 2 * context);
                StdOut.println(text.substring(from, to));
            }
            StdOut.println();
        }
    }
}
