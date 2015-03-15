/**
 * Created by Xue on 2015/3/14.
 */
public class IFlowNetwork {

    private final int V;
    private int E;
    private Bag<IFlowEdge>[] adj;

    public IFlowNetwork(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<IFlowEdge>[])new Bag[V];
        for(int v = 0; v < V; v++){
            adj[v] = new Bag<IFlowEdge>();
        }
    }

    public IFlowNetwork(int V, int E){
        this(V);
        for(int i = 0; i < E; i++){
            int v = StdRandom.uniform(V);
            int w = StdRandom.uniform(V);
            double capacity = StdRandom.uniform(100);
            addEdge(new IFlowEdge(v, w, capacity));
        }
    }

    public IFlowNetwork(In in){
        this(in.readInt());
        int E = in.readInt();

        for(int i = 0; i < E; i++){
            int v = in.readInt();
            int w = in.readInt();
            double capacity = in.readDouble();
            addEdge(new IFlowEdge(v, w, capacity));
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(IFlowEdge e){
        int v = e.from();
        int w = e.to();
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<IFlowEdge> adj(int v){
        return adj[v];
    }

    public Iterable<IFlowEdge> edges(){
        Bag<IFlowEdge> list = new Bag<IFlowEdge>();
        for(int v = 0; v < V; v++){
            for(IFlowEdge e : adj(v)){
                if(e.to() != v)
                    list.add(e);
            }
        }
        return list;
    }

    private boolean localEq(IFlowNetwork G, int v){

        double EPSILON = 1E-11;
        double netflow = 0.0;

        for(IFlowEdge e : G.adj(v)){
            if(v == e.from())
                netflow -= e.flow();
            else netflow += e.flow();
        }

        return Math.abs(netflow) < EPSILON;
    }

    /**private boolean isFeasible(IFlowNetwork G){
        for(IFlowEdge e : G.edges())
            if(e.flow() < 0 || e.flow() > e.capacity())
                return false;

        for(int v = 0; v < G.V(); v++){
            if(v )
        }

    }*/
}
