/**
 * Created by Xue on 2015/2/5.
 */
public class ILazyPrimMinimumSpanningTree{

    private boolean[] marked;
    private Queue<IEdge> mst;
    private MinPQ<IEdge> pq;

    public ILazyPrimMinimumSpanningTree(IEdgeWeightedGraph G){

        pq = new MinPQ<IEdge>();
        marked = new boolean[G.V()];
        mst = new Queue<IEdge>();

        visit(G, 0);
        while(!pq.isEmpty()){
            IEdge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if(marked[v] && marked[w])
                continue;
            mst.enqueue(e);
            if(!marked[v])
                visit(G, v);
            if(!marked[w])
                visit(G, w);
        }
    }

    private void visit(IEdgeWeightedGraph G, int v){
        marked[v] = true;
        for(IEdge e : G.adj(v))
            if(!marked[e.other(v)])
                pq.insert(e);
    }

    public Iterable<IEdge> edges(){
        return mst;
    }
}
