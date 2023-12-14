package jzoffer.day07_Backtrack_BTree;

import java.util.Stack;

public class MirrorTree {
    //请完成一个函数，输入一个二叉树，该函数输出它的镜像。
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public TreeNode mirrorTree(TreeNode root){
        //递归法
        if(root==null) return null;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }

    public TreeNode mirrorTree1(TreeNode root){
        //辅助栈(或队列)
        if(root==null) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>(){{add(root);}};
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left!=null) stack.add(node.left);
            if(node.right!=null) stack.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }
}