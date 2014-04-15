//The whole thing is only a model, the details are not right!
public class ImplementIn {
	private String lala;
	public ImplementIn(String s){
		lala = s;
	}
	public boolean isEmpty(){
		return true;
	}
	public int readInt(){
		return 3;
	}
	public static int[] readInts(String name){
		ImplementIn in = new ImplementIn(name);
		Queue<Integer> q = new Queue<Integer>();
		while (!in.isEmpty())
			q.enqueue(in.readInt());
		int N =q.size();
		int[] a = new int[N];
		for(int i = 0; i < N; i++){
			a[i] = q.dequeue();
		}
		return a;
	}
}
