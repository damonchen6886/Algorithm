package BinaryTree;

public class ConvertArraytoTree {
    //* Description:
    //* 	Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
    //* 	For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of_every_node never differ by more than 1.
    //* 	Given the sorted array: [-10,-7, -4, -3,0, 5,9],
    //
    public TreeNode convert(int[] arr){
        if(arr == null || arr.length == 0){
            return null;
        }
        TreeNode root = dfs(arr, 0, arr.length - 1);
        return root;
    }
    private TreeNode dfs(int[] array, int left, int right){
        // base case
        if(left > right){
            return null;
        }
        int mid = left + (right - left)/2;
        TreeNode newRoot = new TreeNode(array[mid]);
        newRoot.left = dfs(array, left, mid-1);
        newRoot.right = dfs(array, mid + 1, right);
        return newRoot;
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }

    }
}
