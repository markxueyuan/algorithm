import java.math.BigInteger;
import java.util.Random;

/**
 * Created by Xue on 2015/3/10.
 */
public class IRabinKarpFingerprint {

    private String pat;
    private long patHash;
    private int M;
    private int R = 256;
    private long Q;
    private long RM;

    public IRabinKarpFingerprint(String pat){
        this.pat = pat;
        this.M = pat.length();
        Q = longRandomPrime();
        RM = 1;
        for(int i = 1; i <= M-1; i++)
            RM = (R * RM) % Q;
        patHash = hash(pat, M);

    }


    private long hash(String key, int M){
        long h = 0;
        for(int j = 0; j < M; j++)
            h = (R * h + key.charAt(j)) % Q;
        return h;
    }

    //I don't understand the following method
    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

    public int search(String txt){
        int N = txt.length();
        long txtHash = hash(txt, M);
        if(patHash == txtHash)
            return 0;
        for(int i = M; i < N; i++){
            txtHash = (txtHash + Q - RM*txt.charAt(i-M) % Q) % Q;
            txtHash = (txtHash*R + txt.charAt(i)) % Q;
            if(patHash == txtHash)
                return i - M + 1;
        }
        return N;
    }
}
