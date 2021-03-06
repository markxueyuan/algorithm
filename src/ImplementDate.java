
public class ImplementDate {
	
	private final int month;
	private final int day;
	private final int year;
	
	public ImplementDate(int m, int d, int y){
		month = m;
		day = d;
		year = y;
	}
	
	public int month(){
		return month;
	}
	public int day(){
		return day;
	}
	public int year(){
		return year;
	}
	public String toString(){
		return month() + "/" + day() + "/" + year();
	}
	public boolean equals(Object x){
		if(this == x) return true;
		if(x == null) return false;
		if(this.getClass() != x.getClass()) return false;
		ImplementDate that = (ImplementDate) x;
		if(this.day() != that.day()) return false;
		if(this.month() != that.month()) return false;
		if(this.year() != that.year()) return false;
		return true;
	}
}
