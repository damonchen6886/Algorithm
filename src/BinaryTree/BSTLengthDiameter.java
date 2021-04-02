package BinaryTree;

public class BSTLengthDiameter {
//Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
//Example:
//Given a binary tree
//          1
//         / \
//        2   3
//       / \
//      4   5
//Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int val){
        this.val = val;
    }
}

    Integer max = Integer.MIN_VALUE;
    public int treeDiameter(TreeNode root){
        getHeight(root);
        return max;

    }


    private int getHeight(TreeNode root){
        // base case
        if(root == null){
            return 0;
        }
        // recursion
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        max = Math.max(left+right+1, max);
        return Math.max(left, right) + 1;
    }


}
