/**
 * Created by Xue on 2015/3/14.
 */
public class IOrderMatters {


    public static int sum(){

        int sum = 0;
        int x = 1;

        while(x < 100){
            sum += x;
            x += 2;
        }
        return sum;
    }

    public static int sun(){

        int sun = 0;
        int x = 1;

        while(x < 100){
            x += 2;
            sun += x;
        }
        return sun;
    }

    public static void main(String[] args){
        System.out.println("sum is " + sum());
        System.out.println("sun is " + sun());
    }
}
