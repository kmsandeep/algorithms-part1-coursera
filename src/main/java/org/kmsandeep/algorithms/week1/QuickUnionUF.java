package org.kmsandeep.algorithms.week1;

public class QuickUnionUF implements DynamicConnectivityInterface{
    private int id[];
    private int N;

    public QuickUnionUF(int N){
        this.N = N;
        this.id = new int[N];
        for(int i=0; i<N; i++){
            id[i]=i;
        }
    }

    private  int root(int i){
        while(i != id[i]){
            i = id[i];
        }
        return i;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public void union(int p, int q) {
        int rp = root(p);
        int rq = root(q);
        id[rp] = rq;
    }
}
