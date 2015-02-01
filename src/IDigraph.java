/**
 * Created by Xue on 2015/2/1.
 */
public class IDigraph {

    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public IDigraph(int V){
        this.V = V;
        this.E = 0;

        adj = (Bag<Integer>[]) new Bag[V];

        for(int v = 0; v < V; v++){
            adj[v] = new Bag<Integer>();
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public IDigraph reverse(){
        IDigraph R = new IDigraph(V);
        for(int v = 0; v < V; v++){
            for(int w : adj(v))
                R.addEdge(w, v);
        }
        return R;
    }
}
