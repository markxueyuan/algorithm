/**
 * Created by Xue on 2015/2/1.
 */
public class IDegreeOfSeparation {

    public static void main(String[] args){

        ISymbolGraph sg = new ISymbolGraph(args[0], args[1]);
        Graph G = sg.G();

        String source = args[2];

        if(!sg.contains(source)){
            StdOut.println(source + " not in database.");
            return;
        }

        int s = sg.index(source);

        IBreadthFirstPaths bfs = new IBreadthFirstPaths(G, s);

        while(!StdIn.isEmpty()){
            String sink = StdIn.readLine();
            if(sg.contains(sink)){
                int t = sg.index(sink);
                if(bfs.hasPathTo(t)){
                    for(int v : bfs.pathTo(t))
                        StdOut.println("  " + sg.name(v));
                }
                else StdOut.println("Not Connected");
            }
            else StdOut.println("Not in database.");
        }
    }
}
