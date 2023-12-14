package jzoffer.day19_SearchAndBacktracking;

public class LowestCommonAncestor {
    //给定一个二叉搜索树，找到该树中两个指定节点的最近公共祖先。


    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x;}
    }

    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if(root==null) return null;
        if((p.val>=root.val&&q.val<=root.val) || (p.val<=root.val&&q.val>=root.val))
            return root;
        if(p.val>=root.val) return lowestCommonAncestor(root.right,p,q);
        return lowestCommonAncestor(root.left,p,q);
    }
}
