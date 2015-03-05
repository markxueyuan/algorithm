/**
 * Created by Xue on 2015/2/4.
 */
public class IEdgeWeightedGraph {
    private final int V;
    private int E;
    private Bag<IEdge>[] adj;

    public IEdgeWeightedGraph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<IEdge>[])new Bag[V];
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(IEdge e){
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<IEdge> adj(int v){
        return adj[v];
    }

    public Iterable<IEdge> edges(){
        Bag<IEdge> b = new Bag<IEdge>();
        for(int v = 0; v < V; v++)
            for(IEdge e : adj[v])
                if(e.other(v) > v)
                    b.add(e);
        return b;
    }
}
