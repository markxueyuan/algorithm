public class RandomPractice {
	@SuppressWarnings("deprecation")
	public static double uniform(double a, double b){
		return a + StdRandom.random() * (b - a);
	}
	
	@SuppressWarnings("deprecation")
	public static int uniform(int N){
		return (int) (StdRandom.random() * N);
	}
	
	public static int uniform(int lo, int hi){
		return lo + StdRandom.uniform(hi - lo);
	}
	
	public static int discrete(double[] a){
		//Entries in a[] must sum to 1;
		@SuppressWarnings("deprecation")
		double r = StdRandom.random();
		double sum = 0.0;
		for (int i = 0; i < a.length; i++){
			sum = sum + a[i];
			if (sum >= r) return i;
		}
		return -1;
	}
	
	public static double[] shuffle(double[] a){
		int N = a.length;
		for (int i = 0; i < N; i++){
			int r = i + StdRandom.uniform(N-i);
			double temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
		return a;
	}
	
	public static void main(String[] args){
		System.out.println(uniform(157,298));
		double[] a = {0.1, 0.2, 0.3, 0.2, 0.2};
		System.out.println(discrete(a));
		double[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		double[] c = shuffle(b);
		for (int i = 0; i < c.length; i++ ){
			System.out.println(c[i]);
		}
		//System.out.println(args[0]);
	}
}
