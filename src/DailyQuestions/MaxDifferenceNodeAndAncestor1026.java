package DailyQuestions;

public class MaxDifferenceNodeAndAncestor1026 {
    // 这道题 只要保证找到任意一条节点上的最大值和最小值 然后 比较当前节点与全局最大值和最小值的差值哪个大
//                8           -> max 8 min 8
//            /      \
//           3        10      -> left: (max 8 min3)   right: (max 10 min 8)
//        /    \         \
//       1     6         14    -> 1: max 8 min 1  val 7    6: max 8 min 3 val 5
//            /  \        /
//            4   7       13   -> 4: max 8 min 1   val 7  7: max 8 min 1 val: 7
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public int maxAncestorDiff(TreeNode root) {
        if(root == null){
            return 0;
        }
        int max = root.val;
        int min = root.val;
        return getMax(root, max, min);


    }
    private int getMax(TreeNode root, int max, int min){
        if(root == null){
            return max-min;
        }
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        int left = getMax(root.left, max, min);
        int right = getMax(root.right, max, min);
        return Math.max(left,right);


    }
}
