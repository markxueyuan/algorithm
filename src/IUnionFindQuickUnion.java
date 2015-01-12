/**
 * Created by Xue on 2015/1/10.
 */
public class IUnionFindQuickUnion {

    int cnt;
    int[] id;

    public IUnionFindQuickUnion(int N){
        cnt = N;
        id = new int[N];
    }

    public int find(int p){
        while(p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) return;
        id[pRoot] = qRoot;
        cnt--;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
}
