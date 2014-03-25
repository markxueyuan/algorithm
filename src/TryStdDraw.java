import java.util.Arrays;
public class TryStdDraw {
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		if(Integer.parseInt(args[0]) == 1){
			int N = 100;
			StdDraw.setXscale(0,N);
			StdDraw.setYscale(0,N*N);
			StdDraw.setPenRadius(.01);
			for(int i = 1; i < N; i++){
				StdDraw.point(i, i);
				StdDraw.point(i, i*Math.log(i));
				StdDraw.point(i, i*i);
				}
		}
		if(Integer.parseInt(args[0]) == 2){
			int N = 50;
			double[] a = new double[N];
			for(int i = 0; i < N; i++){
				a[i] = StdRandom.random();
				double x = 1.0*i/N;
				double y = a[i]/2.0;
				double rw = 0.3/N;
				double rh = a[i]/2.0;
				StdDraw.filledRectangle(x,y,rw,rh);
			}
		}
		if(Integer.parseInt(args[0]) == 3){
			int N = 50;
			double[] a = new double[N];
			for(int i =0; i < N; i++){
				a[i] = StdRandom.random();
			}
			Arrays.sort(a);
			for(int i = 0; i < N; i++){
				double x = 1.0*i/N;
				double y = a[i]/2.0;
				double rw = 0.3/N;
				double rh = a[i]/2.0;
				StdDraw.filledRectangle(x,y,rw,rh);
			}
		}
	}
}
