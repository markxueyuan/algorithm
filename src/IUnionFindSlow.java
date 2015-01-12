/**
 * Created by Xue on 2015/1/9.
 */
public class IUnionFindSlow {

    private int[] id;
    private int cnt;

    public IUnionFindSlow(int N){
        cnt = N;
        id = new int[N];
        for(int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    public int count(){
        return cnt;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int find(int p){
        return id[p];
    }

    public void union(int p, int q){
        int pID = find(p);
        int qID = find(q);

        if(pID == qID) return;

        for(int i = 0; i < id.length; i++)
            if(find(i) == pID) id[i] = qID;
        cnt--;
    }

    public static void main(String[] args){
        int N = StdIn.readInt();
        IUnionFindSlow uf = new IUnionFindSlow(N);

        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }

        StdOut.println(uf.count() + " components");
    }




}
