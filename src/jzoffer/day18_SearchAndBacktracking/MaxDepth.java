package jzoffer.day18_SearchAndBacktracking;

public class MaxDepth {
    //求二叉树的深度
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        int l, r;
        if (root == null)
            return 0;
        else {
            l = maxDepth(root.left);
            r = maxDepth(root.right);
            return (l > r ? l : r) + 1;
        }
    }
}
