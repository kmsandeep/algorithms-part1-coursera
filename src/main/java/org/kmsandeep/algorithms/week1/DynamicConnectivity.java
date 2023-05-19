package org.kmsandeep.algorithms.week1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DynamicConnectivity {
    private static List<String> lines;
    private static int N ;
    public DynamicConnectivity(){

        try {
            String path = this.getClass().getClassLoader().getResource("dynamicConnectivity.txt").getPath();
            this.lines = Files.readAllLines(Path.of(path));
            this.N = Integer.parseInt(lines.get(0));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void dynamicConnectivityImplementation(DynamicConnectivityInterface dnInterface){
        for (int i=1; i < lines.size(); i++){
            String[] command = lines.get(i).split(" ");
            System.out.println(lines.get(i));
            String operation = command[0];
            int p = Integer.parseInt(command[1]);
            int q = Integer.parseInt(command[2]);
            if("find".equalsIgnoreCase(operation)){
                boolean connected = dnInterface.isConnected(p,q);
                if (connected){
                    System.out.println("--> "+p +" and "+ q + " are connected.");
                }
                else{
                    System.out.println("--> "+p +" and "+ q + " are not connected.");
                }
            }
            else if("union".equalsIgnoreCase(operation)){
                dnInterface.union(p,q);
            }

        }
    }
    public static void main(String[] args) {
        DynamicConnectivity dc = new DynamicConnectivity();
//        dynamicConnectivityImplementation(new QuickFindUF(N));
//        dynamicConnectivityImplementation(new QuickUnionUF(N));
        dynamicConnectivityImplementation(new WeightedQuickUnionUF(N));

    }
}
