package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class AllPathSumToTarget {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    //leetcode 113
    //Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.
    //
    //A leaf is a node with no children.
//                  5
//                /  \
//               4     8
//            /        / \
//          11        13  4
//         /  \          /  \
//        7    2        5     1
//    Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//    Output: [[5,4,11,2],[5,8,4,5]]
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result=  new ArrayList<>();
        if(root == null){
            return result;
        }
        dfs(root, targetSum, result, new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode root, int target, List<List<Integer>> result, List<Integer> cur){
        if(root == null){
            return;
        }
        cur.add(root.val);
        if( root.left  == null && root.right == null && target == root.val){
            result.add(new ArrayList<Integer>(cur));
        }
        dfs(root.left, target-root.val, result, cur);
        dfs(root.right, target-root.val, result, cur);
        cur.remove(cur.size()-1);
    }
}
