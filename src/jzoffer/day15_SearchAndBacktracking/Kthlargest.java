package jzoffer.day15_SearchAndBacktracking;


public class Kthlargest {
    //给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
        int res,k;
        public int kthLargest(TreeNode root,int k){
            this.k=k;
            dfs(root);
            return res;
        }
        void dfs(TreeNode root){
            if(root==null) return;
            dfs(root.right);
            if(k==0) return;
            if(--k==0) res=root.val;
            dfs(root.left);
        }
    }
}