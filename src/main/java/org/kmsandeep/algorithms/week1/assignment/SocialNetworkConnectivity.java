package org.kmsandeep.algorithms.week1.assignment;


import java.io.IOException;
import java.time.Instant;
import java.util.List;


public class SocialNetworkConnectivity {
    private int N;
    private int queryCount;
    private int friend[];
    private int fsz[];
    private List<String> lines;

    public SocialNetworkConnectivity(int N) throws IOException {
        this.queryCount=50;
        this.N = N;
        FileUtility.createFile(N,queryCount,"int int  time","/socialNetwork.txt");
        try {
            lines = FileUtility.readFile("/socialNetwork.txt");
            this.N = Integer.parseInt(lines.get(0));
            this.friend = new int[N];
            this.fsz = new int[N];
            for(int i =0; i<N; i++){
                friend[i]=i;
                fsz[i]=1;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        SocialNetworkConnectivity snc = new SocialNetworkConnectivity(10);
        Instant instant = getInstantOfNetworkCompletion(snc);
        System.out.println(instant.toString());
    }

    private  static Instant getInstantOfNetworkCompletion(SocialNetworkConnectivity snc) {
        Instant instant = Instant.now();
        for(int i = 1; i <snc.queryCount ; i++){
            String [] cols = snc.lines.get(i).split(" ");
            int p = Integer.parseInt(cols[0]);
            int q = Integer.parseInt(cols[1]);
            Instant time = Instant.parse(cols[2]);
            if(!snc.isConnected(p,q)){
               if(snc.union(p,q)== snc.N){
                   instant = time;
                   break;
               }
            }
            else if(snc.fsz[snc.root(p)]== snc.N){
                instant = time;
                break;
            }
        }
        return instant;
    }

    private int union(int p, int q){
        int rp = root(p);
        int rq = root(q);
        if(rp == rq){
            return fsz[rp];
        }
        if(fsz[rp]< fsz[rq]){
            friend[rp] = rq;
            fsz[rq] += fsz[rp];
            return fsz[rq];
        }
        else{
            friend[rq] = rp;
            fsz[rp] += fsz[rq];
            return fsz[rp];
        }
    }
    private boolean isConnected(int p, int q){
        return root(p) == root(q);
    }
    private int root(int i){
        int k = i;
        while(k != friend[k]){
            k = friend[k];
        }
        while(i != friend[i]){
            i = friend[i];
            friend[i] = k;
        }
        return k;
    }
}
