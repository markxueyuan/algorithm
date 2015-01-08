
public class ImplementCounter {
	
	private final String name;
	private int count;
	
	public ImplementCounter(String id){
		name = id;
	}
	
	public void increment(){
		count++;
	}
	
	public int tally() {
		return count;
	}
	
	public String toString(){
		return count + " " + name;
	}
	
	public static void main(String[] args){
		
		ImplementCounter heads = new ImplementCounter("heads");
		ImplementCounter tails = new ImplementCounter("tails");
		
		heads.increment();
		heads.increment();
		tails.increment();
		
		StdOut.println(heads + " " + tails);
		StdOut.println(heads.tally() + tails.tally());
	}
}
