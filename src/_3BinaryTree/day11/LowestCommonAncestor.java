package _3BinaryTree.day11;


import java.util.List;

public class LowestCommonAncestor {

    //Given two nodes in a binary tree (with parent pointer available), find their lowest common ancestor.
    //
    //Assumptions
    //
    //There is parent pointer for the nodes in the binary tree
    //
    //The given two nodes are not guaranteed to be in the binary tree
    //
    //Examples
    //
    //        5
    //
    //      /   \
    //
    //     9     12
    //
    //   /  \      \
    //
    //  2    3      14
    //
    //The lowest common ancestor of 2 and 14 is 5
    //
    //The lowest common ancestor of 2 and 9 is 9
    //
    //The lowest common ancestor of 2 and 8 is null (8 is not in the tree)
    //
    static class TreeNode{
        TreeNode left,right, parent;
        int value;
        public TreeNode(int _value){
            value = _value;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode t1, TreeNode t2){
//         TreeNode root = t1;
//         while(root.parent != null){
//             root = root.parent;
//         }
        int level1 = 0;
        int level2 = 0;
        TreeNode temp1 = t1;
        TreeNode temp2 = t2;
        while(temp1.parent != null){
            temp1 = temp1.parent;
            level1++;
        }
        while(temp2.parent != null){
            temp2 = temp2.parent;
            level2++;
        }

        while(level1 != level2){
            if(level1 <level2){
                t2 = t2.parent;
            }
            if(level1 > level2){
                t1 = t1.parent;
            }

        }


        return helper2(t1, t2);


    }

    private TreeNode helper2(TreeNode t1, TreeNode t2){
        if(t1.parent == null && t1 != t2){
            return null;
        }
        if(t1 == t2){
            return t1;
        }
        t1 =t1.parent;
        t2 = t2.parent;
        return null;

    }

    //-------------

    public TreeNode LCAI(TreeNode one, TreeNode two){
        // return the height of each node
        int l1 = getHeight(one);
        int l2 = getHeight(two);
        if(l1 < l2){
            return merge(one, two, l2-l1);
        } else {
            return merge(two, one, l1-l2);
        }
    }
    //
    private int getHeight(TreeNode root){
        int length = 0;
        while(root != null){
            root = root.parent;
            length++;
        }
        return length;
    }

    private TreeNode merge(TreeNode shorter, TreeNode longer, int diff){
        while(diff > 0){
            longer = longer.parent;
            diff--;
        }
        while(longer != shorter){
            longer = longer.parent;
            shorter = shorter.parent;
        }
        return longer;
    }


/// without parent pointer but given root:


    public TreeNode dfs(TreeNode root, TreeNode one, TreeNode two){

        // base case
        if(root == null){
            return null;
        }
        if(root == one || root == two){
            return root;
        }
        // recursion rule
        TreeNode l1 = dfs(root.left,one, two);
        TreeNode l2 = dfs(root.right,one, two);
        if(l1 != null && l2 != null){
            return root;
        }
        return l1 == null ? l2:l1;
//                           1
//                         /  \
//                        5     6
//
//                      /   \
//
//                     9     12
//
//                   /  \      \
//
//                  2    3      14


    }
// given n nodes :
public TreeNode LCAIII(TreeNode root, List<TreeNode> nodes){

    // base case
    if(root == null){
        return null;
    }
    if(nodes.contains(root)){
        return root;
    }
    // recursion rule
    TreeNode l1 = LCAIII(root.left, nodes);
    TreeNode l2 = LCAIII(root.right,nodes);
    if(l1 != null && l2 != null){
        return root;
    }
    return l1 == null ? l2:l1;

}





}
