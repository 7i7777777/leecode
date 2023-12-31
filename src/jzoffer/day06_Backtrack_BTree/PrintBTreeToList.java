package jzoffer.day06_Backtrack_BTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintBTreeToList {
    //从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
    //
    //
    //
    //例如:
    //给定二叉树: [3,9,20,null,null,15,7],
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public List<List<Integer>> printRTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right !=null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;

    }
}