/**
 * Created by Xue on 2015/3/14.
 */
public class IFlowEdge {

    private final int v;
    private final int w;

    private final double capacity;
    private double flow;

    public IFlowEdge(int v, int w, double capacity){

        this.v = v;
        this.w = w;
        this.capacity = capacity;
        this.flow = 0.0;
    }

    public IFlowEdge(int v, int w, double capacity, double flow){
        this.v = v;
        this.w = w;
        this.capacity = capacity;
        this.flow = flow;
    }

    public IFlowEdge(IFlowEdge e){
        this.v = e.v;
        this.w = e.w;
        this.capacity = e.capacity;
        this.flow = e.flow;
    }

    public int from(){
        return v;
    }

    public int to(){
        return w;
    }

    public double capacity(){
        return capacity;
    }

    public double flow(){
        return flow;
    }

    public int other(int vertex){
        if(vertex == v)
            return w;
        else if(vertex == w)
            return v;
        else throw new IllegalArgumentException("Illegal endpoint");
    }

    public double residualCapacityTo(int vertex){
        if(vertex == v)
            return flow;
        else if(vertex == w)
            return capacity - flow;
        else throw new IllegalArgumentException("Illegal endpoint");
    }

    public void addResidualFlowTo(int vertex, double delta){
        if(vertex == v)
            flow -= delta;
        else if(vertex == w)
            flow += delta;
    }

    public String toString(){
        return String.format("%d->%d %.2f %.2f", v, w, capacity, flow);
    }
}
