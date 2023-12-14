package random.Dec25;

import jzoffer.day18_SearchAndBacktracking.IsBalanced;

public class TreeNodeP {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int i=0;
    public int treeNodeP(TreeNode T,int k){
        if(T==null) return 0;
        i++;
        if(i==k) return T.val;
        if(T.left!=null) return treeNodeP(T.left,k);
        if(T.right!=null)return treeNodeP(T.right,k);
        return -1;
    }
}
