package leecodeHot100;

import utils.TreeNode;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 * 示例 2：
 * 输入：root = [1,null,2]
 * 输出：2
 * 提示：
 * 树中节点的数量在 [0, 104] 区间内。
 * -100 <= Node.val <= 100
 */
public class _037MaxDepth {

    /**
     * 这道题是要求计算二叉树的最大深度，即从根节点到最远叶子节点的最长路径上的节点数。
     * 为了解决这个问题，我们可以使用递归的方法。
     * 具体步骤如下：
     * 1. 如果根节点为空，说明二叉树为空，返回深度0。
     * 2. 递归计算左子树的最大深度，记为  leftDepth 。
     * 3. 递归计算右子树的最大深度，记为  rightDepth 。
     * 4. 返回  leftDepth  和  rightDepth  中的较大值加1，即为二叉树的最大深度。
     * 以下是使用Java语言实现的递归算法代码：
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
