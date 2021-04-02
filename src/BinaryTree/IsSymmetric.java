package BinaryTree;

public class IsSymmetric {


    static class TreeNode{
        TreeNode left,right;
        int value;
        public TreeNode(int _value){
            value = _value;
        }
    }
    // Follow 3: Is symmetric
//         5

//       /    \

//     3        3

//   /   \    /   \

// 1      4  4      1
//          5

//       /    \

//     3        3

//   /   \    /   \

// 1      4  1      4



    public static boolean isSymmetric(TreeNode root){
        // case 0:
        if(root == null) return true; // you need to clearify with interviewer
        return isSymmetric(root.left, root.right);
    }
    private static boolean isSymmetric(TreeNode left, TreeNode right){
        // base case :
        if(left == null && right == null){
            // case 1：两边都是null
            return true;
        } else if( left == null || right == null){
            // case 2: 单边是null
            return false;
        } else if(left.value != right.value){
            // case 3: 两边值不等
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right,right.left);
    }




}
