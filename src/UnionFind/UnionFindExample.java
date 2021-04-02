package day31;

public class UnionFindExample {
    //Example 1:
    //
    //Input:
    //UnionFind(5)
    //query()
    //connect(1, 2)
    //query()
    //connect(2, 4)
    //query()
    //connect(1, 4)
    //query()
    //
    //Output:[5,4,3,3]
    //
    //Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.
    //
    //You need to support the following method:
    //
    //connect(a, b), an edge to connect node a and node b
    //query(), Returns the number of connected component in the graph

    class unionFind{
        private int[] father;
        private int size;
        public unionFind(int n){
            father  = new int[n+1];
            size = n;
            for(int i = 0; i < n+1; i++){
                father[i] = i;

            }
        }

        private int find(int x){
            if(father[x] == x){
                return x;
            }
            return father[x] = find(father[x]);
        }

        private void connect(int a, int b){
            int fathera = find(a);
            int fatherb = find(b);
            if(fathera != fatherb){
                father[fathera] = fatherb;
                size--;
            }
        }
        public int query(){
            return size;
        }


    }

}
