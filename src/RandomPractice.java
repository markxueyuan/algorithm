public class RandomPractice {
	@SuppressWarnings("deprecation")
	public static double uniform(double a, double b){
		return a + StdRandom.random() * (b - a);
	}
	
	public static void main(String[] args){
		System.out.println(uniform(3.0,4.0));
	}

}
