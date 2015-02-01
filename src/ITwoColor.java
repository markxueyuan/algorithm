/**
 * Created by Xue on 2015/2/1.
 */
public class ITwoColor {

    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;

    public ITwoColor(Graph G){
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        for(int s = 0; s < G.V(); s++)
            dfs(G, s);
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        for(int w : G.adj(v))
            if(!marked[w]){
                color[w] = !color[v];
                dfs(G, w);
            }
            else if(color[w] = color[v])
                isTwoColorable = false;
    }

    public boolean isBipatite(){
        return isTwoColorable;
    }

    public static void main(String[] args){
        Graph g = new Graph(new In(args[0]));
        ITwoColor tc = new ITwoColor(g);
        StdOut.println(tc.isBipatite());
    }
}
