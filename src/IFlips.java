
public class IFlips { 
	
	public static void main(String[] args){
		 
		int T = Integer.parseInt(args[0]);
		
		ImplementCounter heads = new ImplementCounter("heads");
		ImplementCounter tails = new ImplementCounter("tails");
		
		for(int t = 0; t < T; t++){
			if(StdRandom.bernoulli(0.5))
				heads.increment();
			else tails.increment();
		}
		
		StdOut.println(heads);
		StdOut.println(tails);
		int d = heads.tally() - tails.tally();
		StdOut.println("delta: " + Math.abs(d));
	}

}
