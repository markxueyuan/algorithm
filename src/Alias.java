
public class Alias {
	
	public static void main(String[] args){
		
		int[] a = new int[10];
		a[2] = 1234;
		int[] b = a;
		b[2] = 3456;
		
		StdOut.println(a[2]);
		StdOut.println(b[2]);
		StdOut.println(a[3]);
	}
}
