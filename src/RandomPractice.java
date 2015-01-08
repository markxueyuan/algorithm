public class RandomPractice {
	
	public static double uniform(double a, double b){
		return a + StdRandom.random() * (b - a);
	}
	
	public static int uniform(int N){
		return (int) (StdRandom.random() * N);
	}
	
	public static int uniform(int lo, int hi){
		return lo + uniform(hi - lo);
	}
	
	public static int discrete(double[] a){
		double r = StdRandom.random();
		double sum = 0.0;
		for(int i = 0; i < a.length; i++){
			sum += a[i];
			if(sum >= r) return i;
		}
		return -1;
	}
	
	public static void shuffle(double[] a){
		int N = a.length;
		for(int i = 0; i < N; i++){
			int r = i + StdRandom.uniform(N-i);
			double temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}
	
	public static void main(String[] args){
		StdOut.println(uniform(4.2, 7.9));
		StdOut.println(uniform(5));
		StdOut.println(uniform(4.0, 7.0));
		StdOut.println(uniform(4, 7));
		StdOut.println(uniform(4.0,7));
		
		double[] a = {0.2, 0.3, 0.4, 0.1};
		StdOut.println(discrete(a));
		
		for(int i = 0; i < a.length; i++)
			StdOut.println(a[i]);
		
		shuffle(a);
		
		for(int i =0; i < a.length; i++)
			StdOut.println(a[i]);
		
	}
}
