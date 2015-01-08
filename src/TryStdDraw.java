import java.util.Arrays;

public class TryStdDraw {
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		

		
		int M = 50;
		double[] a = new double[M];
		for(int i = 0; i < M; i++){
			a[i] = StdRandom.random();
		}
		Arrays.sort(a);
		for(int i = 0; i < M; i++){
			double u = 1.0*i/M;
			double v = a[i]/2.0;
			double rw = 0.3/M;
			double rh = a[i]/2.0;
			StdDraw.filledRectangle(u,v,rw,rh);
			
		}
		
	}
}
