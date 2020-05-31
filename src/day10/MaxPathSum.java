package day10;



public class MaxPathSum {

    static class TreeNode{
        TreeNode left,right;
        int value;
        public TreeNode(int _value){
            value = _value;
        }
    }
    //Given a binary tree in which each node contains an integer number. Find the maximum possible sum from one leaf node to another leaf node. If there is no such path available, return Integer.MIN_VALUE(Java)/INT_MIN (C++).
    //
    //Examples
    //                -5
    //
    //              /    \
    //
    //            20      11
    //
    //                 /    \
    //
    //                6     14
    //
    //                       / \
    //
    //                    -4     -6
    //
    //The maximum path sum is -5 + 11 + 14 -4 = 31.

    public static int maxPathSum(TreeNode root){
        // base case
        if(root.left == null && root.right == null){
            return root.value;
        }
        // case 1:
        if(root.left == null){
            return maxPathSum(root.right)+root.value;
        }
        // case 2:
        if(root.right == null){
            return maxPathSum(root.left) + root.value;
        }
        // case 3:
        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);
        return root.value + Math.max(left,right);
    }


//
//Follow Up 1: Given a binary tree in which each node contains an integer number. Find the maximum possible subpath sum(both the starting and ending node of the subpath should be on the same path from root to one of the leaf nodes, and the subpath is allowed to contain only one node).
//
//Assumptions
//
//The root of given binary tree is not null
//Examples
//
//   -5
//
//  /    \
//
//2      11
//
//     /    \
//
//    6     14
//
//           /
//
//        -3
//
//The maximum path sum is 11 + 14 = 25


    // follow 2: 有锅我不背
    public static int maxPathSumII(TreeNode root){
        // 当你有多个参数需要进行计算时，用数组传递进去
        int[] max = new int[]{Integer.MIN_VALUE};
        dfsI(root, max);
        return max[0];
    }
    public static int dfsI(TreeNode root, int[] max){
        // base case
        if(root == null){
            return 0;
        }
        // recursion rule
        int left = dfsI(root.left, max);
        int right = dfsI(root.right, max);
        int current = Math.max(Math.max(left, right),0) + root.value;
        max[0] = Math.max(current, max[0]);
        return current;
    }

    //Given a binary tree in which each node contains an integer number. Find the maximum possible sum from one leaf
// node to another leaf node. If there is no such path available, return Integer.MIN_VALUE(Java)/INT_MIN (C++).

    //                -5
    //
    //              /    \
    //
    //            20      11
    //
    //                 /    \
    //
    //                6     14
    //
    //                       / \
    //
    //                    -4     -6
    //    return sum( 20 -5 11 14)
    public int maxPathSum3(TreeNode root){
        int[] result = new int[]{Integer.MIN_VALUE};
        helper3(root, result);
        return result[0];

    }

    private int helper3(TreeNode root, int[] max){
        // base case
        if(root == null){
            return 0;
        }

        int left = helper3(root.left,max);
        int right = helper3(root.right,max);
        left = Math.max(left, 0);
        right = Math.max(right, 0);
        int current = root.value + left + right;
        max[0] = Math.max(current, max[0]);
        return root.value + Math.max(left,right);
    }


//Given a binary tree in which each node contains an integer number. Find the maximum possible sum from one leaf
// node to another leaf node. If there is no such path available, return Integer.MIN_VALUE(Java)/INT_MIN (C++).

    //                -5
    //
    //              /    \
    //
    //            20      11
    //
    //                 /    \
    //
    //                6     14
    //
    //                       / \
    //
    //                    -4     -6
    //    return  -5 20 11 6 14
    public int maxPathSum4(TreeNode root){
        int[] result = new int[]{Integer.MIN_VALUE};
        helper4(root, result);
        return result[0];

    }

    private int helper4(TreeNode root, int[] max){
        // base case
        if(root == null){
            return 0;
        }

        int left = helper4(root.left,max);
        int right = helper4(root.right,max);
        left = Math.max(left, 0);
        right = Math.max(right, 0);
        int current = root.value + left + right;
        max[0] = Math.max(current, max[0]);
        return root.value + left + right;
    }
//  // follow 0:
//    public static int getHeight(TreeNode root){
//        // base case:
//        if(root == null) return 0;
//        int left = getHeight(root.left);
//        int right = getHeight(root.right);
//        return Math.max(left,right) + 1;
//    }
//
//    // follow 1:全部一脉，照单全收
//    public static int maxPathSumI(TreeNode root){
//        // base case: case 1.2.3
//        if(root.left == null && root.right == null){
//            return root.value;
//        }
//        if(root.left == null){
//            return root.value + maxPathSumI(root.right);
//        }
//        if(root.right == null){
//            return root.value + maxPathSumI(root.left);
//        }
//        // current level manipulation
//        int left = maxPathSumI(root.left);
//        int right = maxPathSumI(root.right);
//        return root.value + Math.max(left, right);
//    }
//    // follow 2: 有锅我不背
//    public static int maxPathSumII(TreeNode root){
//        // 当你有多个参数需要进行计算时，用数组传递进去
//        int[] max = new int[]{Integer.MIN_VALUE};
//        dfsI(root, max);
//        return max[0];
//    }
//    public static int dfsI(TreeNode root, int[] max){
//        // base case
//        if(root == null){
//            return 0;
//        }
//        // recursion rule
//        int left = dfsI(root.left, max);
//        int right = dfsI(root.right, max);
//        int current = Math.max(Math.max(left, right),0) + root.value;
//        max[0] = Math.max(current, max[0]);
//        return current;
//    }
//
//    // follow 3: 人字形我全都要
//    public static int maxPathSumIII(TreeNode root){
//        int[] max = new int[]{Integer.MIN_VALUE};
//        dfsII(root,max);
//        return max[0];
//    }
//    public static int dfsII(TreeNode root, int[] max){
//        // base case;
//        if(root == null){
//            return 0;
//        }
//        // recursion rule
//        int left = dfsII(root.left, max);
//        int left = dfsII(root.right, max);
//        left = left < 0 ? 0 : left;
//        right = right < 0 ? 0 : right;
//        int current = root.value + left + right;
//        max[0] = Math.max(max[0], current);
//        return root.value + Math.max(left, right);
//        // 真我全都要
//        return root.value + left + right;
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Hello, world!");
//    }
//}
//    //                -5
//    //
//    //              /    \
//    //
//    //            20      11
//    //
//    //                 /    \
//    //
//    //                6     14
//    //
//    //                       / \
//    //
//    //                    -4     -6
//    //



}