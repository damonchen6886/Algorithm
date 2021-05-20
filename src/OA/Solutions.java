package OA;


import java.util.*;

public class Solutions {


    //------------------
    //filterDuplicates
    public String filterDuplicates(String S) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : S.toCharArray()) {
            if (!dq.isEmpty() && dq.peekLast() == c) {
                dq.pollLast();
            }else {
                dq.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : dq) { sb.append(c); }
        return sb.toString();
    }



    //------------------
    //BubbleSort
    public void  BubbleSort(int[] lst){
        int n = lst.length;
        boolean haschanged =false;
        for(int i = 0; i < n-1; i++){

            for(int j = 0; j < n-i-1; j++){
                if(lst[j] > lst[j+1]){
                    int temp = lst[j];
                    lst[j] = lst[j+1];
                    lst[j+1] = temp;
                    haschanged = true;
                }
            }
            if(!haschanged){
                break;
            }
        }
    }



    //------------------
    //TraverseInorder
    public List<Integer> TraverseInorder(TreeNode root){
        if(root == null){
            return null;
        }
        List<Integer> lst = new ArrayList<>();
        TraverseInorderImp(root, lst);
        return lst;
    }

    private void TraverseInorderImp(TreeNode root, List<Integer> lst){
        if(root == null){
            return;
        }
        TraverseInorderImp(root.left, lst);
        lst.add(root.val);
        TraverseInorderImp(root.right,lst);

    }

    //------------------
    //BSTVerification
    public boolean BSTVerification(TreeNode root){
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean check(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }
        return check(root.left, min,root.val) && check(root.right,root.val,max);
    }


    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){
        }
        public TreeNode(int val){
            this.val = val;
        }

    }


    public static void main(String[] args) {
        Solutions solutions =new Solutions();
        /// filterDuplicates
        System.out.println("------------------------------");
        System.out.println("----------filter Duplicates-----");
        String[] s  = new String[]{"xyzxzzx","caaabbbaacdddd", "geeksforgeeg","bookkeepinggofforit", "happyppycooding" };
        for(int i = 0;  i< s.length;i++){
            System.out.println(s[i]+ " -> " + solutions.filterDuplicates(s[i]));
        }

        // Bubble  sort:
        System.out.println("------------------------------");
        System.out.println("---------Bubble  sort----------");
        int[] lst = new int[]{29, 31, 39, 18, 6, 5, 34, 24, 13, 37};
        System.out.println("before : " + Arrays.toString(lst));
        solutions.BubbleSort(lst);
        System.out.println("after : " + Arrays.toString(lst));


        // TraverseInorder:
        System.out.println("------------------------------");
        System.out.println("--------Traverse Inorder---------");
        TreeNode  root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.right = new TreeNode(22);
        List<Integer> nodePrint = solutions.TraverseInorder(root);
        System.out.println("expected: {4, 8, 10, 12, 14, 20, 22} ---> actual: " + nodePrint);

        //BSTVerification
        System.out.println("------------------------------");
        System.out.println("--------BSTVerification---------");
        TreeNode root2 = new TreeNode(25);
        root2.left = new TreeNode(15);
        root2.right = new TreeNode(28);
        root2.right.left = new TreeNode(7);
        root2.right.right = new TreeNode(40);


        TreeNode root3 = new TreeNode(60);
        root3.left = new TreeNode(70);
        root3.left.left = new TreeNode(40);
        root3.right = new TreeNode(75);
        root3.right.left = new TreeNode(65);
        root3.right.right = new TreeNode(80);

        TreeNode root4 = new TreeNode(20);
        root4.left = new TreeNode(10);
        root4.left.left = new TreeNode(9);
        root4.left.left.left = new TreeNode(8);
        root4.right = new TreeNode(30);
        root4.right.left = new TreeNode(25);
        root4.right.right = new TreeNode(40);

        TreeNode root5 = new TreeNode(17);
        root5.left = new TreeNode(20);
        root5.left.left = new TreeNode(30);
        root5.right = new TreeNode(16);
        root5.right.right = new TreeNode(40);

        TreeNode root6 = new TreeNode(1);

        TreeNode root7 = new TreeNode();

        System.out.println("expect: false ---> actual: "+ solutions.BSTVerification(root2));
        System.out.println("expect: false ---> actual: "+ solutions.BSTVerification(root3));
        System.out.println("expect: true ---> actual: "+ solutions.BSTVerification(root4));
        System.out.println("expect: false ---> actual: "+ solutions.BSTVerification(root5));
        System.out.println("expect: true ---> actual: "+ solutions.BSTVerification(root6));
        System.out.println("expect: true ---> actual: "+ solutions.BSTVerification(root7));
    }
}
