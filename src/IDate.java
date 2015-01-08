
public class IDate implements FDatable{
	
	private final int month;
	private final int day;
	private final int year;
	
	public IDate(int m, int d, int y){
		month = m;
		day = d;
		year = y;
	}
	
	public int month(){
		return month;
	}
	
	public int day() {
		return day;
	}
	
	public int year() {
		return year;
	}
	
	public String toString(){
		return month() + "/" + day() + "/" + year();
	}
	
	public boolean equals(Object x){
		if(this == x) return true;
		if(x == null) return false;
		if(this.getClass() != x.getClass()) return false;
		IDate that = (IDate) x;
		if(this.day() != that.day()) return false;
		if(this.month() != that.month()) return false;
		if(this.year() != that.year()) return false;
		return true;
	}
	
	public static void main(String[] args){
		IDate first = new IDate(12, 3, 2014);
		IDate second = new IDate(12, 3, 2014);
		IDate third = new IDate(12, 4, 2014);
		StdOut.println(first.equals(second));
		StdOut.println(first.equals(third));
	}

}
