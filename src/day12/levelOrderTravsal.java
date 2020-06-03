package day12;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class levelOrderTravsal {

    static class TreeNode{
        TreeNode left,right;
        int value;
        public TreeNode(int val){
            value = val;
        }
    }

    // Level Order traverse
    public List<List<Integer>> levelOrderTrverse(TreeNode t){

        if(t == null){
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(t, result, 0);
        return result;

    }

    private void dfs(TreeNode root, List<List<Integer>> result, int level){


        if(level  ==  result.size()){
            result.add(new ArrayList<>());


        }
        result.get(level).add(root.value);
        if(root.left != null){
            dfs(root.left, result, level+1);
        }
        if(root.right != null){
            dfs(root.right, result, level+1);
        }

        //  cur =  [4]
    }                                //result = [[-5],[2,],[4]]


    public List<List<Integer>> levelOrderdfs2(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        dfs2(root, 0, result);
        return result;
    }
    private void dfs2(TreeNode root, int level, List<List<Integer>> result){
        // base case
        if(root == null) return;
        // corner case
        if(level == result.size()) {
            result.add(new ArrayList<Integer>());
        }
        // recursion rule
        result.get(level).add(root.value);
        dfs2(root.left, level+1, result);
        dfs2(root.right,level+1, result);
    }

    // Queue (FIFO)
    // BSF : Queue
    // Deque interface --> queue --> poll, offer
    //                 --> stack --> push, pop
    //                 --> deque --> offerFirst, offerLast, pollFirst, pollLast
    public List<List<Integer>> levelOrderbfs(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        // bfs traverse
        queue.offer(root);
        while(!queue.isEmpty()){
            // step 1: calculate the number of value in current level
            int size = queue.size();
            List<Integer> curList = new ArrayList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
                curList.add(cur.value);
            }
            result.add(curList);
        }
        return result;
    }


//         -5
//
//        /    \
//
//      2       11
//
//    /   \   /    \
//
//    4   5  6     14
//
//                /
//
//              -3





}
