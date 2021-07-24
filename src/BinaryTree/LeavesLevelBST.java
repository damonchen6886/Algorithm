package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class LeavesLevelBST {
    // leetcode 366
    //Given the root of a binary tree, collect a tree's nodes as if you were doing this:
    //
    //Collect all the leaf nodes.
    //Remove all the leaf nodes.
    //Repeat until the tree is empty.
    //          1
    //        /  \
    //      2       3
    //     /  \
    //    4    5
    //
    // 453 is a group
    // 2 is a group
    // 1 is a group

    //Input: root = [1,2,3,4,5]
    //Output: [[4,5,3],[2],[1]]
    //Explanation:
    //[[3,5,4],[2],[1]] and [[3,4,5],[2],[1]]
    // are also considered correct answers since per each level it does not matter the order on which elements are returned.

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){
        }
    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root,result);
        return result;
    }

    private int dfs(TreeNode root, List<List<Integer>>result){
        if(root == null){
            return -1;
        }
        int level = 1+Math.max(dfs(root.left, result), dfs(root.right, result));
        if(result.size() == level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        return level;
    }
}
