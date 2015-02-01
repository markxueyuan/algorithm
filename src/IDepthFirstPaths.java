/**
 * Created by Xue on 2015/1/28.
 */
public class IDepthFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public IDepthFirstPaths(Graph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        for(int w : G.adj(v))
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(G, w);
            }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for(int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

    public static void main(String[] args){
        In in = new In(args[0]);
        Graph G = new Graph(in);
        int s = Integer.parseInt(args[1]);
        IDepthFirstPaths search = new IDepthFirstPaths(G, s);
        for(int v = 0; v < G.V(); v++){
            StdOut.print(s + " to " + v + ":");
            if(search.hasPathTo(v))
                for(int x : search.pathTo(v))
                    if(x == s) StdOut.print(x);
            else StdOut.print("-" + x);
            StdOut.println();
        }
    }
}
