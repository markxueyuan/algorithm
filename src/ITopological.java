/**
 * Created by Xue on 2015/2/3.
 */
public class ITopological {

    private Iterable<Integer> order;

    public ITopological(Digraph G){

        DirectedCycle cyclefinder = new DirectedCycle(G);
        if(!cyclefinder.hasCycle()){
            IDepthFirstOrder dfs = new IDepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order(){
        return order;
    }

    public boolean isDAG(){
        return order != null;
    }

    public static void main(String[] args){

        String filename = args[0];
        String separator = args[1];

        SymbolDigraph sg = new SymbolDigraph(filename, separator);

        ITopological top = new ITopological(sg.G());

        for(int v : top.order())
            StdOut.println(sg.name(v));
    }
}
