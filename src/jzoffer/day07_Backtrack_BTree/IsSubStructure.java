package jzoffer.day07_Backtrack_BTree;

public class IsSubStructure {
    //输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
    //B是A的子结构， 即 A中有出现和B相同的结构和节点值。
    //B 与 A 的一个子树拥有相同的结构和节点值返回true，反之返回false
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public boolean isSubStructure(TreeNode A,TreeNode B){
        return (A!=null && B!=null)&&(recur(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B));
    }

    boolean recur(TreeNode A,TreeNode B){
        if(B==null) return true;
        if(A==null || A.val!=B.val) return false;
        return recur(A.left,B.left) && recur(A.right,B.right);
    }
}