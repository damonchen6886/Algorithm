package day22;

import day9.isTweakedBT;

import java.util.HashMap;

public class HouseRubber {

    // [100,1,1,200]
    // physical meaning i: 偷到i，最多能偷多少钱，0 -> i < house.length, dp[i]
    // base case. dp[0] = 0, dp[1] = house[0];

    public int houseRobber(int[] house){
        if(house == null|| house.length == 0){
            return 0;
        }

        int[] dp = new int[house.length+1];
        // base case :
        dp[0] = 0;
        dp[1] = house[0];
        // induction rule
        for(int i = 2; i <= house.length; i++){
            // case 1 : steal,
            dp[i] =  Math.max(dp[i-2] + house[i-1],dp[i-1]);
        }
        return dp[house.length];
    }



    // houses is a cycle
    public int houseRobber2(int[] house){
        if(house == null|| house.length == 0){
            return 0;
        }
        int[] house1 = new int[house.length -1];
        int[] house2 = new int[house.length -1];
        for(int i = 0; i < house2.length-1; i++){
            house2[i] = house[i+1];
        }
        for(int i = 0; i < house.length-1; i++){
            house1[i] = house[i];
        }


        int[] dp1 = new int[house1.length+1];
        int[] dp2 = new int[house2.length+1];
        // base case :
        dp1[0] = 0;
        dp1[1] = house1[0];
        dp2[0]= 0;
        dp2[1] = house2[0];
        // induction rule
        for(int i = 2; i <= house1.length; i++){
            // case 1 : steal,
            dp1[i] =  Math.max(dp1[i-2] + house1[i-1],dp1[i-1]);
        }
        for(int i = 2; i <= house2.length;i++){
            dp2[i] = Math.max(dp2[i-2] + house2[i-1], dp2[i-1]);
        }
        return Math.max(dp2[house2.length],dp1[house1.length]);
    }


    // house rubber tree

    //House Robber III
    //The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
    //
    //Determine the maximum amount of money the thief can rob tonight without alerting the police.
    //
    //Example 1:
    //
    //Input: [3,2,3,null,3,null,1]
    //​
    //     3
    //    / \
    //   2   3
    //    \   \
    //     3   1
    //​
    //Output: 7
    //Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
    //Example 2:
    //
    //Input: [3,4,5,1,3,null,1]
    //​
    //     3
    //    / \
    //   4   5
    //  / \   \
    // 1   3   1
    //​
    //Output: 9
    //Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
    public int rob(TreeNode root){
        return robHelper(root, new HashMap<>());
    }
    private int robHelper(TreeNode root, HashMap<TreeNode, Integer> map){
        if(root == null) return 0;
        if(map.containsKey(root)){
            return map.get(root);
        }
        int val = 0;
        if(root.left != null){
            val += robHelper(root.left.left, map) + robHelper(root.left.right, map);
        }
        if(root.right != null){
            val += robHelper(root.right.left, map) + robHelper(root.right.right, map);
        }
        // start to compare
        val = Math.max(root.val + val, robHelper(root.left, map) + robHelper(root.right, map));
        map.put(root, val);
        return val;
    }
    static class TreeNode{
        TreeNode left,right;
        int val;
        public TreeNode(int val){
            this.val = val;
        }
    }


}
