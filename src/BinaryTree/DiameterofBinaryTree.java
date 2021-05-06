package BinaryTree;

public class DiameterofBinaryTree {
    public class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(){};
        TreeNode(TreeNode left, TreeNode right, int val){
            this.left = left;
            this.right =right;
            this.val = val;
        }

    }

    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);
        return max-1;
    }

    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right =dfs(root.right);
        max  =Math.max(max, left+right+1);
        return Math.max(left, right)+1;

    }

}
