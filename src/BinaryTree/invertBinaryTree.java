package BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class invertBinaryTree {

//     2           2
//   /  \  -->   /  \
//  1    3      3    1
//    Input: root = [4,2,7,1,3,6,9]
//    Output: [4,7,2,9,6,3,1]


class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int val){
        this.val = val;
    }
}

//     dfs version
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
// stack:
    public TreeNode invertTree2(TreeNode root) {
        if(root == null){
            return null;
        }
        Deque<TreeNode> stack = new ArrayDeque<>(0);
        stack.push(root);
        while( !stack.isEmpty()){
            TreeNode cur = stack.pop();
            TreeNode left =cur.left;
            cur.left =cur.right;
            cur.right =left;
            if(cur.left != null){
                stack.push(cur.left);
            }
            if(cur.right != null){
                stack.push(cur.right);
            }
        }
        return root;
    }
;

//    bfs version
public TreeNode invertTree3(TreeNode root) {
    if(root == null){
        return null;
    }
    Queue<TreeNode> q= new ArrayDeque<>();
    q.offer(root);
    while(!q.isEmpty()){
        TreeNode cur = q.poll();
        TreeNode left = cur.left;
        cur.left = cur.right;
        cur.right = left;
        if(cur.left != null){
            q.offer(cur.left);
        }
        if(cur.right != null){
            q.offer(cur.right);
        }
    }
    return root;
}
}
