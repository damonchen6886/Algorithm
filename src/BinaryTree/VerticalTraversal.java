package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class VerticalTraversal {

//                     3
//                  /     \
//                9          20
//                         /     \
//                        15      7
    //Input: root = [3,9,20,null,null,15,7]
    //Output: [[9],[3,15],[20],[7]]
    //Explanation:
    //Column -1: Only node 9 is in this column.
    //Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
    //Column 1: Only node 20 is in this column.
    //Column 2: Only node 7 is in this column.

//                 1
//            /        \
//           2          3
//         /  \        /  \
//        4    5      6    7

//    Input: root = [1,2,3,4,5,6,7]
//    Output: [[4],[2],[1,5,6],[3],[7]]
//    Explanation:
//    Column -2: Only node 4 is in this column.
//            Column -1: Only node 2 is in this column.
//            Column 0: Nodes 1, 5, and 6 are in this column.
//          1 is at the top, so it comes first.
//          5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
//    Column 1: Only node 3 is in this column.
//            Column 2: Only node 7 is in this column.
 public class TreeNode {
      int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
    class Point{
        int x;
        int y;
        int val;
        public Point(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val =val;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result  =new ArrayList<>();

        PriorityQueue<Point> pq =new PriorityQueue<>((a, b)-> a.x  != b.x ? a.x-b.x : a.y != b.y ? b.y-a.y : a.val-b.val);
        dfs(root, 0,0,pq);
        int prevX  =Integer.MIN_VALUE;
        while(!pq.isEmpty()){
            Point cur = pq.poll();
            // 判断是否换column
            if(cur.x > prevX){
                ArrayList<Integer> lst = new ArrayList<>();
                lst.add(cur.val);
                result.add(lst);

            }
            else{
                List<Integer> lst  =result.get(result.size()-1);
                lst.add(cur.val);
            }
            prevX = cur.x;
        }
        return result;
    }

    private void dfs(TreeNode root, int x, int y, PriorityQueue<Point> pq){
        if(root == null){
            return;
        }
        pq.offer(new Point(x,y,root.val));
        dfs(root.left, x-1,y-1,pq);
        dfs(root.right, x+1,y-1,pq);
    }



}
