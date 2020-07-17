package day31;

public class UnionFind {
    // Union Find
    private int[] father = null;

    // constructor
    public UnionFind(int n){
        father = new int[n + 1];
        for(int i = 1; i <= n; i++){
            father[i] = i;
        }
    }

    // find, uncompressed
    private int find(int x){
        // recursively find you dad
        if(father[x] == x){
            return x;
        }
        // recursive rule
        return find(father[x]);
    }
    // connect
    private void connect(int a, int b){
        int father_a = find(a);
        int father_b = find(b);
        if(father_a != father_b){
            father[father_a] = father_b;
            // father[father_b] = father_a
        }
    }
    // query
    private boolean query(int a, int b){
        int father_a = find(a);
        int father_b = find(b);
        return father_a == father_b;
    }

//    // compressed
//    private int find(int x){
//        // recursively find you dad
//        if(father[x] == x){
//            return x;
//        }
//        // recursive rule
//        return father[x] = find(father[x]);
//    }




}
