package org.kmsandeep.algorithms.week1;

public class QuickFindUF implements DynamicConnectivityInterface{
    private int id[];
    private int N;
    public QuickFindUF(int N){
        this.id = new int[N];
        this.N = N;
        for(int i=0;i<N;i++){
            id[i]=i;
        }
    }
    @Override
    public boolean isConnected(int p, int q){
        return id[p] == id[q];
    }
    @Override
    public void union(int p, int q){
        if(id[p] == id[q]){
            System.out.printf("%d and %d are already connected.", p , q);
            return;
        }
        int pid = id[p];
        int qid = id[q];
        for (int i=0; i<N; i++){
            if(id[i] == pid){
                id[i] = qid;
            }
        }
    }
}
