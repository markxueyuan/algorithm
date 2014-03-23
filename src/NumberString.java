
public class NumberString {
	public static void main(String[] args){
		String a = "3";
		int b = Integer.parseInt(a);
		double c = Double.parseDouble(a);
		String d = Integer.toString(b);
		String e = Double.toString(c);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println("It is difficult to disinguish between "
				+ b + " and " + d + ", or " + c + " and " + e + ".");
	}
}
