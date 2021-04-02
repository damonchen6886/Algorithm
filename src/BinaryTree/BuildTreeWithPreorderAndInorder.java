package BinaryTree;

public class BuildTreeWithPreorderAndInorder {
    //For example, given
    //preorder = [3,9,11,20,15,7]
    //inorder = [11,9,3,15,20,7]
    //Return the following binary tree:
    //    3
    //   / \
    //  9  20
    //  /  /  \
    // 11  15  7
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value){
            this.value = value;
        }


    }
    public TreeNode buildTree(int[] preOrder, int[] inOrder){
        if(preOrder == null || inOrder == null || preOrder.length != inOrder.length){
            return null;
        }
        return helper(preOrder, inOrder, 0, preOrder.length-1, 0, inOrder.length-1);
    }
    private TreeNode helper(int[] preOrder, int[] inOrder, int preStart, int preEnd, int inStart, int inEnd){
        // base case
        if(inStart>inEnd){
            return null;
        }
        // the index of root in inorder array
        int rootPos = findPosition(inStart, inEnd, inOrder, preOrder[preStart]);
        TreeNode root = new TreeNode(preOrder[preStart]);
        root.left = helper(preOrder, inOrder, preStart+1, preStart + rootPos - inStart, inStart, rootPos - 1);
        root.right = helper(preOrder, inOrder, preEnd - inEnd + rootPos + 1, preEnd, rootPos +1, inEnd);
        return root;
    }
    // find the corresponding index of inOrder
    private int findPosition(int start, int end, int[] array, int target){
        for(int i = start; i <= end; i++){
            if(array[i] == target){
                return i;
            }
        }
        return -1;
    }

}
