package leecodeHot100;

import utils.TreeNode;

import java.util.List;

/**
 * 226. 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * 示例 2：
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 * 提示：
 * 树中节点数目范围在 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class _038InvertTree {

    /**
     * 这道题是要求翻转一棵二叉树，即将每个节点的左右子树交换位置。
     * 为了解决这个问题，我们可以使用递归的方法。
     * 具体步骤如下：
     * 1. 如果根节点为空，说明二叉树为空，直接返回空。
     * 2. 递归翻转左子树，得到翻转后的左子树  left 。
     * 3. 递归翻转右子树，得到翻转后的右子树  right 。
     * 4. 将根节点的左子树指向  right ，右子树指向  left 。
     * 5. 返回根节点。
     * 以下是使用Java语言实现的递归算法代码：
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        _038InvertTree o = new _038InvertTree();
        // 创建二叉树 [4,2,7,1,3,6,9]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode result = o.invertTree(root);

        //打印输出结果
        printTree(result);
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
