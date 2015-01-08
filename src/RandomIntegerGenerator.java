
public class RandomIntegerGenerator {
	
	public static void main (String[] args){
		
		int N = Integer.parseInt(args[0]);
		int lo = Integer.parseInt(args[1]);
		int hi = Integer.parseInt(args[2]);
		for(int i = 0; i < N; i++){
			StdOut.println(StdRandom.uniform(lo, hi));
		}		
	}
}
