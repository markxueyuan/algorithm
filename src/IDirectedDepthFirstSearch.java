/**
 * Created by Xue on 2015/2/1.
 */
public class IDirectedDepthFirstSearch {

    private boolean[] marked;

    public IDirectedDepthFirstSearch(Digraph G, int s){
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    public IDirectedDepthFirstSearch(Digraph G, Iterable<Integer> sources){
        marked = new boolean[G.V()];
        for(int s : sources)
            if(!marked[s])
                dfs(G, s);
    }

    private void dfs(Digraph G, int v){
        marked[v] = true;
        for(int w : G.adj(v))
            if(!marked[w])
                dfs(G, w);
    }

    public boolean marked(int v){
        return marked[v];
    }

    public static void main(String[] args){
        Digraph G = new Digraph(new In(args[0]));
        Bag<Integer> sources = new Bag<Integer>();
        for(int i = 1; i < args.length; i++)
            sources.add(Integer.parseInt(args[i]));
        IDirectedDepthFirstSearch reachable = new IDirectedDepthFirstSearch(G, sources);

        for(int v = 0; v < G.V(); v++)
            if(reachable.marked(v))
                StdOut.print(v + " ");
        StdOut.println();
    }
}
