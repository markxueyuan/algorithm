/**
 * Created by Xue on 2015/1/28.
 */
public class CPaths {

    public static void main(String[] args){
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        IDepthFirstPaths search = new IDepthFirstPaths(G, s);

        for(int v = 0; v < G.V(); v++){
            StdOut.println(s + "to " + v + ": ");
            if(search.hasPathTo(v))
                for (int x : search.pathTo(v)){
                    if(x == s) StdOut.print(x);
                    else StdOut.print("-" + x);
                }
            StdOut.println();

        }
    }
}
