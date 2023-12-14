package random.Dec08;

public class ParentBTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode parentBTree(TreeNode bt,TreeNode p){
        TreeNode r;
        if(p ==null)
            return null;
        if(bt==p ||bt==null)
            return null;
        if(bt.left ==p || bt.right==p)
            return bt;
        r = parentBTree(bt.left,p);
        if(r!=null)
            return r;
        r = parentBTree(bt.right,p);
        if (r!=null)
            return r;
        return null;
    }
}