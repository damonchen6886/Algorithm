package day9;

public class isBinaryTree {
    static class TreeNode{
        TreeNode left,right;
        int value;
        public TreeNode(int _value){
            value = _value;
        }
    }


    // Assume: it will not be overflow
    public static boolean isBST(TreeNode root){
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private static boolean isBST(TreeNode root, Integer min, Integer max){
        if(root == null) return true;
        if(root.value < min || root.value > max) return false;
        return isBST(root.left, min, root.value - 1) && isBST(root.right, root.value+1, max);
    }






}
