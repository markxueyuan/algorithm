/**
 * Created by Xue on 2015/2/4.
 */
public class IEdge {
    private final int v;
    private final int w;
    private final double weight;

    public IEdge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight(){
        return weight;
    }

    public int either(){
        return v;
    }

    public int other(int vertex){
        if(vertex == v) return w;
        else if(vertex == w) return v;
        else throw new RuntimeException("Inconsistent edge");
    }

    public int compareTo(IEdge that){
        if(this.weight() < that.weight()) return -1;
        else if(this.weight() > that.weight()) return +1;
        else return 0;
    }

    public String toString(){
        return String.format("%d-%d %.2f", v, w, weight);
    }
}
