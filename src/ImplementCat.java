
public class ImplementCat {
	
	public static void main(String[] args){
		int N = args.length;
		Out out = new Out(args[N-1]);
		for(int i = 0; i < N - 1; i++){
			In in = new In(args[i]);
			String s = in.readAll();
			out.println(s);
			in.close();
		}
		out.close();
	}

}
