package day38;

public class flipBST {
    //*	Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node)
    // *	or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
    // *	For example:
    // *		Given a binary tree {1,2,3,4,5},

    //  -------------
    //   original tree:
    //         1
    //        / \
    //       2   3
    //      / \
    //     4  5
    //	   	return the root of the binary tree [4,5,2,#,#,3,1].
    //	   	    4
    //  	   / \
    //        5   2
    //           / \
    //          3   1
    // *
    // * Algorithm Class
    class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
        }
    }


    // iterative method
    //             null
    //            /
    // *	    1 -- null
    //	      /
    //	     2 -- 3
    //
    //	   4   5
    public TreeNode UpsideDown(TreeNode root){
        TreeNode prev = null, prevRight = null;
        while(root != null){
            TreeNode next = root.left;
            TreeNode right = root.right;
            root.left = prevRight;
            root.right = prev;
            prevRight = right;
            prev = root;
            root = next;
        }
        return prev;

    }

    // similar concept with the reverse linked list recursion method below:
    private TreeNode flipTree(TreeNode root){
        if(root == null || root.left == null){
            return root;
        }
        TreeNode newRoot = flipTree(root.left);
        root.left.right = root.right;
        root.left.left = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }

// reverse linked list recursion method:
//    public ListNode reverse(ListNode head){
//        // base case;
//        if(head == null || head.next == null){
//            return head;
//        }
//        ListNode newHead = reverse(head.next);
//        head.next.next = head;
//        head.next = null;
//        return newHead;
//    }
}
