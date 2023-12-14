package jzoffer.day20_DivideAndConquer;

import jzoffer.TreeNode;

import java.util.HashMap;

public class BuildTree {
    //输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
    //
    //假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

    int[] preoder;
    HashMap<Integer,Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder,int[] inorder){
        this.preoder = preorder;
        for(int i=0;i<inorder.length;i++)
            dic.put(inorder[i],i);
        return recur(0,0,inorder.length-1);
    }
    TreeNode recur(int root,int left,int right){
        if(left > right) return null;
        TreeNode node = new TreeNode(preoder[root]);
        int i=dic.get(preoder[root]);
        node.left=recur(root+1,left,i-1);
        node.right=recur(root+i-left+1,i+1,right);
        return node;
    }

}
