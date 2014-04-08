
public class TryWhitelist {
	public static void main(String[] args){
		int[] w = In.readInts(args[0]);
		ImStaticSETofInts set = new ImStaticSETofInts(w);
		while(!StdIn.isEmpty()){
			int key = StdIn.readInt();
			if (!set.contains(key))
				StdOut.println(key);
	}
}}
