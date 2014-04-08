
public class TryVisualAccumulator {
	public static void main(String[] args){
		int T = Integer.parseInt(args[0]);
		ImplementVisualAccumulator a = new ImplementVisualAccumulator(T, 1.0);
		for(int t = 0; t < T; t++)
			a.addDataValue(StdRandom.random());
		StdOut.println(a);
	}
}
