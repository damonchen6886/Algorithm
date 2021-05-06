package BinaryTree;

public class isSubTree {
// tree:
//         3
//      /    \
//    4       5
//   / \
//  1   2
//    sub tree:
//     4
//    / \
//   1   2
//    -- > return true;
//    Input: root = [3,4,5,1,2], subRoot = [4,1,2]
//    Output: true


    class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }
        if(dfs(root, subRoot)){
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right,subRoot);
    }

    private boolean dfs(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }
        if(root == null || subRoot == null){
            return false;
        }
        if(root.val != subRoot.val){
            return false;
        }
        return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right);
    }
}
