package BinaryTree;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinaryTreeEixstTarget {

    static class TreeNode{
        TreeNode left,right;
        int value;
        public TreeNode(int _value){
            value = _value;
        }
    }

    //Review:
    //Given a binary tree in which each node contains an integer number. Determine if there exists a path (the path can only be from one node to itself or to any of its descendants), the sum of the numbers on the path is the given target number.
    //
    //Examples [5,11,6,3] =>
    //
    //    5
    //
    //  /    \
    //
    //2      11
    //
    //     /    \
    //
    //    6     14
    //
    //  /
    //
    // 3
    //
    //If target = 17, There exists a path 11 + 6, the sum of the path is target.
    //
    //If target = 20, There exists a path 11 + 6 + 3, the sum of the path is target.
    //

    public boolean exist(TreeNode root, int target){
        if(root == null){
            return false;
        }
        return helper(root, target, new ArrayList<Integer>());
    }

    private boolean helper(TreeNode root, int target, ArrayList<Integer> lst){
        if(root.left == null && root.right == null){
            lst.add(root.value);

            return containTarget(lst,target);
        }
        lst.add(root.value);

        helper(root.left, target,lst);
        helper(root.right, target, lst);
        return false;
    }

    private boolean containTarget(ArrayList<Integer> lst, int target ){
        int sum = 0;
        int inx = 0;
        for (Integer integer : lst) {
            sum += integer;

            if (sum > target) {
                sum -= lst.get(inx);
                inx++;
            } else if (sum == target) {
                return true;
            }

        }
        return false;


    }


    //--------------------------

    public boolean exist2(TreeNode root, int target){
        // sanity check
        if(root == null) return false;
        List<TreeNode> path = new ArrayList<TreeNode>();
        return helper2(root, path, target);

    }

    private boolean helper2(TreeNode root, List<TreeNode> path, int target){
        path.add(root);
        int temp = 0;

        for(int i = path.size()-1; i >= 0; i--){
            temp += path.get(i).value;
            if(temp == target){
                return true;
            }
        }
        // recursion rule
        if(root.left != null && helper2(root.left, path, target)){
            return true;
        }
        if(root.right != null && helper2(root.right, path, target)){
            return true;
        }
        path.remove(path.size()-1);
        return false;

    }
//-------------------------------
    //Optimize:
// Time: O(n)
public boolean existOptimzed(TreeNode root, int target){
    if(root == null) return false;
    Set<Integer> prefixSum = new HashSet<Integer>();
    prefixSum.add(0);
    return helperII(root, prefixSum, 0, target);
}

    private boolean helperII(TreeNode root, Set<Integer> prefixSum, int prevSum, int target){
        prevSum += root.value;
        if(prefixSum.contains(prevSum - target)){
            return true;
        }
        boolean flag = prefixSum.add(prevSum);
        if(root.left != null && helperII(root.left, prefixSum, prevSum, target)){
            return true;
        }
        if(root.right != null && helperII(root.right, prefixSum, prevSum, target)){
            return true;
        }
        if(flag) {
            prefixSum.remove(prevSum);
        }
        return false;
    }

}
