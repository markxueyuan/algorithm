/**
 * Created by Xue on 2015/1/6.
 */
public class IExpressionEvaluation {

    public static void main(String[] args){

        int N = args.length;

        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();

        for(int i = 0; i < N; i++){
            String c = args[i];
            if(c.equals("(")) ;
            else if(c.equals("+")) ops.push(c);
            else if(c.equals("-")) ops.push(c);
            else if(c.equals("*")) ops.push(c);
            else if(c.equals("/")) ops.push(c);
            else if(c.equals("sqrt")) ops.push(c);
            else if(c.equals(")")){
                String op = ops.pop();
                Double val = vals.pop();
                if(op.equals("+")) val = vals.pop() + val;
                else if(op.equals("-")) val = vals.pop() - val;
                else if(op.equals("*")) val = vals.pop() * val;
                else if(op.equals("/")) val = vals.pop() / val;
                else if(op.equals("sqrt")) val = Math.sqrt(val);
                vals.push(val);
            }
            else vals.push(Double.parseDouble(c));
        }

        StdOut.println(vals.pop());
    }
}
