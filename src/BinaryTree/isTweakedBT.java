package _3BinaryTree.day9;

public class isTweakedBT {

    static class TreeNode{
        TreeNode left,right;
        int value;
        public TreeNode(int _value){
            value = _value;
        }
    }

    // Follow 4: Is tweakedIdentity

//             			 5                               5

//                   /    \                          /    \

//     	    		3        8                      8        3

//   			 /   \                                     /   \

//            1      4                                   1     4

    public static boolean isTweaked(TreeNode one, TreeNode two){
        if(one == null && two == null){
            return true;
        } else if (one == null || two == null){
            return false;
        } else if (one.value != two.value){
            return false;
        }
        // recursion rules
        return isTweaked(one.left, two.left) && isTweaked(one.right, two.right) ||
                isTweaked(one.left, two.right) && isTweaked(one.right, two.left);
    }

}
