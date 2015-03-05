/**
 * Created by Xue on 2015/2/8.
 */
public class IEdgeWeightedDigraph {

    private final int V;
    private int E;
    private Bag<IDirectedEdge>[] adj;

    public IEdgeWeightedDigraph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<IDirectedEdge>[])new Bag[V];
        for(int v = 0; v < V; v++)
            adj[v] = new Bag<IDirectedEdge>();
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(IDirectedEdge e){
        adj[e.from()].add(e);
        E++;
    }

    public Iterable<IDirectedEdge> adj(int v){
        return adj[v];
    }

    public Iterable<IDirectedEdge> edges(){
        Bag<IDirectedEdge> bag = new Bag<IDirectedEdge>();
        for(int v = 0; v < V; v++)
            for(IDirectedEdge e : adj[v])
                bag.add(e);
        return bag;
    }
}
