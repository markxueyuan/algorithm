/**
 * Created by Xue on 2015/1/15.
 */

import java.util.Comparator;

public class ICompareBySecondChar implements Comparator<String> {


    public int compare(String a, String b){
        if(a.length() < 2 || b.length() < 2) throw new IllegalArgumentException();
        String x = Character.toString(a.charAt(1));
        String y = Character.toString(b.charAt(1));
        return x.compareTo(y);
    }
}
