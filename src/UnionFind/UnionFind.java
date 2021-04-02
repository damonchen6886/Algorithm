package UnionFind;

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

    // find, compressed
        private int find(int x){
        // recursively find you dad
        if(father[x] == x){
            return x;
        }
        // recursive rule
        return father[x] = find(father[x]);
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

//    // uncompressed
//    private int find(int x){
//        // recursively find you dad
//        if(father[x] == x){
//            return x;
//        }
//        // recursive rule
//        return find(father[x]);
//    }

//  // compressed iterative:
//public int compress_find(int x){
//
//    int x_parent = parent[x];
//    // step 1: find real parent
//    while(x_parent != parent[x_parent]){
//        x_parent = parent[x_parent];
//    } // x_parent is the thing you need to return
//    // step 2：compress
//    int temp = -1;
//    int t_parent = parent[x];
//    while(t_parent != parent[t_parent]){
//        temp = parent[t_parent];
//        parent[t_parent] = x_parent;
//        t_parent = temp;
//    }
//    return x_parent;
//}




}
