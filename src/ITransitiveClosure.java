/**
 * Created by Xue on 2015/2/4.
 */
public class ITransitiveClosure {

    private IDirectedDepthFirstSearch[] all;

    ITransitiveClosure(Digraph G){
        all = new IDirectedDepthFirstSearch[G.V()];
        for(int v = 0; v < G.V(); v++)
            all[v] = new IDirectedDepthFirstSearch(G, v);
    }

    boolean reachable(int v, int w){
        return all[v].marked(w);
    }

}
