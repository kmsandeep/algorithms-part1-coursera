package org.kmsandeep.algorithms.week1;

public class WeightedQuickUnionUF implements DynamicConnectivityInterface{
    private int id[];
    private int sz[];
    private int N;
    public WeightedQuickUnionUF(int N){
        this.N = N;
        this.id = new int[N];
        this.sz = new int[N];
        for(int i=0; i<N; i++){
            id[i]=i;
            sz[i]=1;
        }
    }
    @Override
    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public void union(int p, int q) {
        int rp = root(p);
        int rq = root(q);
        if(rp == rq){
            System.out.printf("%d and %d are already connected.", p , q);
            return;
        }
        if(sz[rp] < sz[rq]){
            id[rp] = rq;
            sz[rq] += sz[rp];
        }
        else{
            id[rq] = rp;
            sz[rp] += sz[rq];
        }
    }

    private int root(int i){
        while (i != id[i]){
            i = id[i];
        }
        return i;
    }
}
