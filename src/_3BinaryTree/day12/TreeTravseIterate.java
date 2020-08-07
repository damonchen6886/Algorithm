package _3BinaryTree.day12;


import java.util.*;

public class TreeTravseIterate {



    static class TreeNode{
        TreeNode left,right;
        int value;
        public TreeNode(int val){
            value = val;
        }
    }

    public void preOrder(TreeNode root){
        if(root == null){return;}

        preOrder(root.left);
        System.out.println(root.value);
        preOrder(root.right);
    }

    // List, Deque
    public List<Integer> preOder2(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            result.add(root.value);
            stack.pop();
            if(root.right != null){
                stack.push(root.right);
            }
            if(root.left != null){
                stack.push(root.left);
            }
        }
        return result;

    }

    public List<Integer> inOrder(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        Deque<Integer> stack = new LinkedList<Integer>();
        TreeNode cur = root;
        while(cur !=null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur.value);
                cur = cur.left;
            } else {
                // if can not go left, maning all the nodes on the left side of the top node on the stack has been traversed
                result.add(stack.pop());
                cur = cur.right;
            }
        }
        return result;
    }

    // List, Deque
    public List<Integer> postOder(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            result.add(root.value);
            stack.pop();
            if(root.left != null){
                stack.push(root.left);
            }
            if(root.right != null){
                stack.push(root.right);
            }

        }
        Collections.reverse(result);
        return result;

    }





    public List<Integer> postOrdre(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        // Use another pointer to record the direction
        TreeNode prev = null;
        while(!stack.isEmpty()){
            TreeNode cur = stack.peek();
            // case 1: if we are going down, either left/ right
            if(prev == null || cur == prev.left || cur == prev.right){
                // if we can still go down, lets try left first
                if(cur.left != null){
                    stack.push(cur.left);
                } else if(cur.right != null){
                    stack.push(cur.right);
                } else {
                    stack.pop();
                    result.add(cur.value);
                }
            } else if(prev == cur.right || prev == cur.left && cur.right == null){
                // case 2: if we are going up from the right side or going up from left side but we can not go right afterwards
                stack.pop();
                result.add(cur.value);
            } else {
                // case 3: otherwise, we are going up from left side to current level and then going down to the right side
                stack.push(cur.right);
            }
            prev = cur;
        }
        return result;
    }



}
