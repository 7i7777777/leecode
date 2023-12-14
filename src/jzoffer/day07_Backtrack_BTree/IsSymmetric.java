package jzoffer.day07_Backtrack_BTree;

public class IsSymmetric {
    //请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
    //
    //例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     public class TreeNode{
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x){
             val = x;
         }
    }
    public boolean isSymmetric(TreeNode root){
         //递归
        return root == null ? true:recur(root.left,root.right);
    }
    boolean recur(TreeNode L,TreeNode R){
         if(L==null&&R==null) return true;
         if(L==null||R==null||L.val!=R.val) return false;
         return recur(L.left,R.right)&&recur(L.right,R.left);
    }
}