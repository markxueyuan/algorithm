import java.util.Arrays;

public class IStaticSETofInts {
	
	private int[] a;
	
	public IStaticSETofInts(int[] keys){
		a = new int[keys.length];
		for(int i = 0; i < keys.length; i++){
			a[i] = keys[i]; //defensive copy
		}
		Arrays.sort(a);
	}
	
	public boolean contains(int key){
		return rank(key) != -1;
	}
	
	private int rank(int key){
		int lo = 0;
		int hi = a.length - 1;
		while(lo <= hi){
			int mid = lo + (hi - lo)/2;
			if(key < a[mid]) hi = mid - 1;
			else if(key > a[mid]) lo = mid + 1;
			else return mid;
		}
		return -1;
	}
	
	public static void main(String[] args){
		int[] w = In.readInts(args[0]);
		IStaticSETofInts set = new IStaticSETofInts(w);
		while(!StdIn.isEmpty()){
			int key = StdIn.readInt();
			if(!set.contains(key))
				StdOut.println(key);
		}
	}

}
