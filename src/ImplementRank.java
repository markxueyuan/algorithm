
public class ImplementRank {
	
	public static int rank(int key, int[] a){
		return rank(key, a, 0, a.length - 1);
	}	
	public static int rank(int key, int[] a, int lo, int hi) {
		if (lo > hi) return -1;
		int mid = lo + (hi - lo) / 2;
		if (key < a[mid]) return rank(key, a, lo, mid - 1);
		else if (key > a[mid]) return rank(key, a, mid + 1, hi);
		else return mid;
	}
	public static void main(String[] args){
		
		int[] a = {2, 4, 6, 7, 9};
		StdOut.println(rank(7, a));
		StdOut.println(rank(2,a));
	}

}
