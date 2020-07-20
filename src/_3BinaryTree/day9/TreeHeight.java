package _3BinaryTree.day9;

public class TreeHeight {

    static class TreeNode{
        TreeNode left,right;
        int value;
        public TreeNode(int _value){
            value = _value;
        }
    }

    // return the height of a binary tree O(n)
    // Space:O(height) = O(n) worst case
    public static int getHeight(TreeNode root){
        // base case:
        if(root == null){
            return 0;

        }
        // recursion rule:
        int countleft = getHeight(root.left);
        int countright=  getHeight(root.right);
        return (countleft > countright) ? countleft +1: countright+1;


    }
int ans;
    // return sum of the depth of all the nodes in  a binary tree
    // Space:O(height) = O(n) worst case
    public  int getHeight2(TreeNode root){
        // base case:
        ans = 0;
        dfs(root, 0);
        return ans;

    }

    public  void dfs(TreeNode t, int dep){
         ans += dep;
         if(t.left != null){
             dfs(t.left, dep+1);
         }
         if(t.right != null){
             dfs(t.right, dep+1);
         }


    }





    // follow 1: how to determine whether a binary tree is a balanced binary tree?
    // Time: O(n2)
    public static boolean isBalanced(TreeNode root){
        // base case:
        if(root == null){
            return true;
        }
        // recursion rule:
        int leftHeight = getHeight(root);
        int rightHeight = getHeight(root);
        if(Math.abs(leftHeight - rightHeight) > 1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    // Optimize
    public static boolean isBalanceOpt(TreeNode root){
        // corner case
        if(root == null) return true;
        return height(root) != -1;
    }
    // same as getHeight with slightly difference
    // Time : O(nlogn)
    private static int height(TreeNode root){
        // base case
        if(root == null) return 0;
        int leftCount = height(root.left);
        if(leftCount == -1){
            return -1;
        }
        int rightCount = height(root.right);
        if(rightCount == -1){
            return -1;
        }
        // determine whether it is balanced
        if(Math.abs(leftCount - rightCount) > 1){
            return -1;
        }
        return Math.abs(leftCount - rightCount) + 1;

    }





    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode one = new TreeNode(2);
        TreeNode two = new TreeNode(3);
        TreeNode three = new TreeNode(4);
        TreeNode four = new TreeNode(5);
        TreeNode five = new TreeNode(6);
        TreeNode six = new TreeNode(7);
        TreeNode seven = new TreeNode(7);
        root.left = one;
        root.right = two;
        one.left = three;
        one.right = four;
        three.left = five;
        five.left = six;
        two.left = seven;
        //          1
        //        /   \
        //       2      3
        //      /\      /
        //     4  5    7
        //    /
        //   6
        //  /
        // 7
        TreeNode root2 = new TreeNode(1);
        TreeNode two2 = new TreeNode(2);
        TreeNode three2 = new TreeNode(3);
        TreeNode four2 = new TreeNode(4);
        TreeNode five2 = new TreeNode(5);
        TreeNode six2 = new TreeNode(6);
        root2.left =two2;
        two2.left = four2;
        four2.right = five2;
        root2.right = three2;
        three2.right = six2;
        //          1
        //        /   \
        //       2      3
        //      /       \
        //     4          6
        //     \
        //      5



        TreeHeight H1 = new TreeHeight();
        int height2=  H1.getHeight2(root);
        int height3=  H1.getHeight2(root2);
        int height = getHeight(root);
        System.out.println(height);
        System.out.println(height2);
        System.out.println(height3);
    }
}
