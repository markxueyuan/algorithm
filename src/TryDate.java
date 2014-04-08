
public class TryDate {
	public static void main(String[] args){
		
		int m = Integer.parseInt(args[0]);
		int d = Integer.parseInt(args[1]);
		int y = Integer.parseInt(args[2]);
		
		ImplementDate date1 = new ImplementDate(m, d, y);
		ImplementDate2 date2 = new ImplementDate2(m, d, y);
		
		StdOut.println(date1 + " state way");
		StdOut.println(date2 + " value way");
	}
}
