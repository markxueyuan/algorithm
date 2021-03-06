/**
 * Created by Xue on 2015/2/27.
 */
public class IAcyclicShortestPaths {

    private DirectedEdge[] edgeTo;
    private double[] distTo;

    public IAcyclicShortestPaths(EdgeWeightedDigraph G, int s){
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];

        for(int v = 0; v < G.V(); v++){
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        distTo[s] = 0.0;

        Topological top = new Topological(G);

        for(int v : top.order())
            relax(G, v);
    }

    private void relax(EdgeWeightedDigraph G, int v){
        for(DirectedEdge e : G.adj(v)){

            int w = e.to();
            if(distTo[w] > distTo[v] + e.weight()){
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
            }
        }
    }
}
