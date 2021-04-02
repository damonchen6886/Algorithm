package BinaryTree.day38;

public class TreeNodeNextPointer {

    //Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set toNULL.
    //Initially, all next pointers are set toNULL.
    //Note:
    //You may only use constant extra space.
    //Recursive approach is fine, implicit stack space does not count as extra space for this problem.
    //You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
    //Example:
    //Given the following perfect binary tree,
    //     1
    //   /  \
    //  2    3
    //  \  / \
    //   5  6  7
    //After calling your function, the tree should look like:
    //     1 -> NULL
    //   /  \
    //  2 -> 3 -> NULL
    // / \  / \
    //4->5->6->7 -> NULL

    public class TreeNode{
        int val;
        TreeNode left, right, next;
        TreeNode(int val){
            this.val = val;
        }
    }

    // Iterative approach
    public void Connect(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode start = root;
        // handle cross level
        while(start != null){
            TreeNode cur = start;
            while(cur != null){
                // handle within level
                if(cur.left != null){
                    cur.left.next = cur.right;
                }
                if(cur.right != null && cur.next != null){
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            start = start.left;
        }
    }


    // recursion approach
    public void connectRecursion(TreeNode root){
        if(root == null){
            return;
        }
        recursion(root.left, root.right);
    }
    private void recursion(TreeNode one, TreeNode two){
        // base case
        if(one == null || two == null){
            return;
        }
        // recursion rule
        one.next = two;
        recursion(one.left, one.right);
        recursion(one.right, two.left);
        recursion(two.left, two.right);
    }

}

