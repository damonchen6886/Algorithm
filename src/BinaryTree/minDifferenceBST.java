package BinaryTree.day38;

import java.util.ArrayList;

public class minDifferenceBST {

    //Almost same as Minimum Absolute Difference in BST
    //Given a Binary Search Tree (BST) with the root noderoot, return the minimum difference between the values of any two different nodes in the tree.
    //Input:
    // root = [4,2,6,1,3,null,null]
    //
    //Output:
    // 1
    //
    //Explanation:
    //
    //Note that root is a TreeNode object, not an array.
    //
    //The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
    //
    //          4
    //        /   \
    //      2      6
    //     / \
    //    1   3
    //
    //while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
    //

    ArrayList<Integer> nodeList = new ArrayList<>();




    // method 2: optimized the space from O(n) to O(1);
    Integer res, prev;
    public int minDifference(TreeNode root){
        prev = null;
        res = Integer.MAX_VALUE;
        dfs(root);
        return res;
    }


    private void dfs(TreeNode root){
        // base case
        if(root == null){
            return;
        }
        dfs(root.left);
        // execution
        if(prev != null){
            res = Math.min(res, root.val - prev);
        }
        prev = root.val;
        // ----------
        dfs(root.right);
    }



    // method 1, not optimized the space

    public int minDifferenceBST(TreeNode root){
        dfs2(root);
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < nodeList.size() - 1; i++){
            res = Math.min(res, nodeList.get(i+1) - nodeList.get(i));
        }
        return res;
    }
    private void dfs2(TreeNode root){
        if(root == null) return;
        dfs2(root.left);
        nodeList.add(root.val);
        dfs2(root.right);
    }

    class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
        }
    }


}
