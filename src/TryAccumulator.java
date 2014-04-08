
public class TryAccumulator {
	public static void main(String[] args){
		int T = Integer.parseInt(args[0]);
		ImplementAccumulator a = new ImplementAccumulator();
		for(int t = 0; t < T; t++)
			a.addDataValue(StdRandom.random());
		StdOut.println(a);
	}
}
