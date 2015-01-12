/**
 * Created by Xue on 2015/1/10.
 */
public class IUnionFindWeightedQuickUnion {

    private int cnt;
    private int[] id;
    private int[] sz;

    public IUnionFindWeightedQuickUnion(int N){
        cnt = N;
        id = new int[N];
        for(int i = 0; i < N; i++){
            id[i] = i;
        }
        sz = new int[N];
        for(int i = 0; i < N; i++){
            sz[i] = 1;
        }
    }

    public int find(int p){
        while(p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) return;

        if(sz[pRoot]<sz[qRoot]){
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        cnt--;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int count(){
        return cnt;
    }

}
