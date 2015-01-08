
public class IAccumulator {
	
	private double total;
	private int N;
	
	public void addDataValue(double val){
		N++;
		total += val;
	}
	
	public double mean(){
		return total/N;
	}
	
	public String toString(){
		return "Mean (" + N + " values): "
				+ String.format("%7.5f", mean());
	}
	
	public static void main(String[] args){
		IAccumulator a = new IAccumulator();
		a.addDataValue(324);
		a.addDataValue(725);
		StdOut.println(a); 
	}

}
