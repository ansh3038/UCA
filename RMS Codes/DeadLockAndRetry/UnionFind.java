import java.util.*;
public class UnionFind {
    private int id[];
    public UnionFind(int n){
        id = new int[n];

        
    }
    public boolean isConnected(int p, int q){
        return id[p]==id[q];
    }
    public void connect(int p, int q){

    }

}
