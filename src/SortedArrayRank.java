//import java.util.Arrays;



public class SortedArrayRank {
	public static int rank(int key, int[] a){
		return rank(key, a, 0, a.length -1);
	}
	
	public static int rank(int key, int[] a, int lo, int hi){
		if (lo > hi) return -1;
		int mid = lo + (hi - lo) / 2;
		if (key < a[mid]) return rank(key, a, lo, mid - 1);
		else if (key > a[mid]) return rank(key, a, mid + 1, hi);
		else return mid;
	}
	
	public static void main(String[] args){
		int key = 6;
		int[] a = {1, 2, 3, 4, 5, 7, 8};
		System.out.println(rank(key, a));
	}
}
