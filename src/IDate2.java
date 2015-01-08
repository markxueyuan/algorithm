
public class IDate2 {
	
	private final int value;
	
	public IDate2(int m, int d, int y){
		value = y*512 + m*32 + d;
	}
	
	public int month(){
		return (value / 32) % 16;
	}
	
	public int day(){
		return value % 32;
	}
	
	public int year(){
		return value / 512;
	}
	
	public static int divideBy7(int v){
		return (v / 7);
	}
	
	public static void main(String[] args){
		StdOut.println(divideBy7(36));
	}
	
}
