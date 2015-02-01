/**
 * Created by Xue on 2015/1/22.
 */
public class ITransaction {

    private String who;
    private Date when;
    private double amount;

    public int hashCode(){
        int hash = 17;
        hash = 31*hash + who.hashCode();
        hash = 31*hash + when.hashCode();
        hash = 31*hash  + ((Double) amount).hashCode();
        return hash;
    }

}
