
public class TryCompareDate {
	public static void main(String[] args){
		ImplementDate date1 = new ImplementDate(3,4,2012);
		ImplementDate date2 = new ImplementDate(4,3,2012);
		ImplementDate date3 = date1;
		StdOut.println(date1.equals(date2));
		StdOut.println(date1.equals(date3));
	}
}
