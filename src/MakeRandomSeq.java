
public class MakeRandomSeq {
    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        double lo = Double.parseDouble(args[1]);
        double hi = Double.parseDouble(args[2]);
        for(int i = 0; i < N; i++){
            double x = StdRandom.uniform(lo,hi);
            StdOut.printf("May be %.2f \n", x);
        }
        StdOut.printf("Chongzhi Zu's PI is about %.7f\n", Math.PI);
    }
}
