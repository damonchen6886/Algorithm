package BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AllNodesDistanceK {

//    Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//
//    Output: [7,4,1]
//
//    Explanation:
//    The nodes that are a distance 2 from the target node (with value 5)
//    have values 7, 4, and 1.
//                    3
//               /         \
//            5               1
//          /  \             /  \
//        6       2         0     8
//      /  \
//     7    4




    class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
        }
    }

    Map<TreeNode, Integer> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new LinkedList<>();
        find(root, target);
        // map.forEach((key, value) -> System.out.println(key.val + ":" + value));
        dfs(root, target, K, map.get(root), res);
        return res;
    }

    // find target node first and store the distance in that path that we could use it later directly
    private int find(TreeNode root, TreeNode target) {
        if (root == null) return -1;
        if (root == target) {
            map.put(root, 0);
            return 0;
        }
        int left = find(root.left, target);
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }
        int right = find(root.right, target);
        if (right >= 0) {
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }

    private void dfs(TreeNode root, TreeNode target, int K, int length, List<Integer> res) {
        if (root == null) return;
        if (map.containsKey(root)) length = map.get(root);
        if (length == K) res.add(root.val);
        dfs(root.left, target, K, length + 1, res);
        dfs(root.right, target, K, length + 1, res);
    }
}
