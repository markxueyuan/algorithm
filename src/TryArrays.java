
public class TryArrays {
	
	public static double[][] twoDimensionalArray(int m, int n){
		
		double[][] a;
		a = new double[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				a[i][j] = 1.0;
		return a;
	}
	
	public static double maxOfArray(double[] a){
		
		double max = a[0];
		int n = a.length;
		for(int i=1; i < n; i++)
			if(a[i] > max) max = a[i];
		return max;
		
	}
	
	public static double averageOfArray(double[] a){
		int N = a.length;
		double sum = 0.0;
		for(int i = 0; i < N; i++)
			sum += a[i];
		return sum / N;
	}
	
	public static double test(double[] a){
		double b = a[2];
		b = 3.14;
		return a[2];
	}
	
	public static double test2(double[] a){
		double b = a[2];
		b = 3.14;
		return b;
	}
	
	public static double[] copy(double[] a){
		
		int N = a.length;
		double[] b = new double[N];
		for(int i = 0; i < N; i++)
			b[i] = a[i];
		return b;
	}
	
	public static double[] reverse(double[] a){
		
		int N = a.length;
		for (int i = 0; i < N/2; i++){
			double temp = a[i];
			a[i] = a[N-1-i];
			a[N-1-i] = temp;
		}
		return a;
	}
	
	public static double[][] squareMatrices(double[][] a){
		
		int N = a.length;
		double[][] b = new double[N][N];
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++){
				// compute dot product of i row and j column
				for (int k = 0; k < N; k++)
					b[i][j] += a[i][k] * a[k][j];
			}
		return b;
	}
	
	public static void main(String[] args){
		
		double[][] b = twoDimensionalArray(3,6);
		StdOut.println(b[2][5]);
		
		double[] a = {2, 2, 3, 4, 5, 6};
		double max = maxOfArray(a);
		StdOut.println(max);
		
		double average = averageOfArray(a);
		StdOut.println(average);
		
		StdOut.println(test(a));
		StdOut.println(test2(a));
		
		double[] d = copy(a);
		d[2] = 48;
		StdOut.println(a[2]);
		StdOut.println(d[2]);
		
		StdOut.println(a[4]);
		StdOut.println(reverse(a)[1]);
		
		double[][] mm = new double[3][3];
		double[] row0 = {1, 2, 3};
		double[] row1 = {2, 4, 6};
		double[] row2 = {3, 6, 9};
		mm[0] = row0;
		mm[1] = row1;
		mm[2] = row2;
		StdOut.println(squareMatrices(mm)[1][1]);
		
	}

}
