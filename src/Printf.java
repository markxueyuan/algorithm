
public class Printf {
	public static void main(String[] args){
		StdOut.printf("%14d\n",512);//integer on the right
		StdOut.printf("%-14d\n",512);//integer on the left
		
		StdOut.printf("Pi is approximately %.2f\n", Math.PI);
		
		double a = 1744.198948783;
		StdOut.printf("%14.2f\n", a);
		StdOut.printf("%5.7f\n", a);
		StdOut.printf("%14.4e\n",a);
		String s = "Hello World!";
		StdOut.printf("%14s\n",s);
		StdOut.printf("%-14s\n", s);
		StdOut.printf("%14.5s\n", s);
	}
}
