/**
 * Created by Xue on 2015/3/11.
 */
public class IBinaryDump {

    public static void main(String[] args){
        int width = Integer.parseInt(args[0]);
        int cnt;
        for(cnt = 0; !BinaryStdIn.isEmpty(); cnt++){
            if(width == 0)
                continue;
            if(cnt != 0 && cnt % width == 0)
                StdOut.println();
            if(BinaryStdIn.readBoolean())
                StdOut.print("1");
            else StdOut.print("0");
        }
        StdOut.println();
        StdOut.println(cnt + " bits");
    }
}