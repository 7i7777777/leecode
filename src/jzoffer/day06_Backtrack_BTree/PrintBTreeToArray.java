package jzoffer.day06_Backtrack_BTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintBTreeToArray {
    //从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
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
    public int[] printBTree(TreeNode root){
        //广度优先搜索
        if(root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{add(root);}};
        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            ans.add(node.val);
            if(node.left != null) queue.add(node.left);
            if(node.right !=null) queue.add(node.right);
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}