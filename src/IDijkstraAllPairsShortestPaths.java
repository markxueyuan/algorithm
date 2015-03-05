/**
 * Created by Xue on 2015/2/26.
 */
public class IDijkstraAllPairsShortestPaths {

    private DijkstraSP[] all;

    public IDijkstraAllPairsShortestPaths(EdgeWeightedDigraph G){

        all = new DijkstraSP[G.V()];
        for(int v = 0; v < G.V(); v++)
            all[v] = new DijkstraSP(G, v);
    }

    public Iterable<DirectedEdge> path(int s, int v){
        return all[s].pathTo(v);
    }

    public double dist(int s, int v){
        return all[s].distTo(v);
    }
}
