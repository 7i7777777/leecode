package leecodeHot100;

import utils.TreeNode;

/**
 * 543. 二叉树的直径
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 * 示例 1：
 * 输入：root = [1,2,3,4,5]
 * 输出：3
 * 解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
 * 示例 2：
 * 输入：root = [1,2]
 * 输出：1
 * 提示：
 * 树中节点数目在范围 [1, 104] 内
 * -100 <= Node.val <= 100
 */
public class _040DiameterOfBinaryTree {

    private int maxDiameter = 0;

    /**
     * 这道题是要求计算二叉树的直径，即任意两个节点之间最长路径的长度。
     * 为了解决这个问题，我们可以使用递归的方法。
     * 具体步骤如下：
     * 1. 如果根节点为空，或者树中只有一个节点，直接返回0。
     * 2. 对于每个节点，计算以该节点为根的子树的最大深度，即左子树的最大深度加上右子树的最大深度。
     * 3. 在递归过程中，记录最大直径的值。
     * 4. 返回当前节点的最大深度。
     * 以下是使用Java语言实现的递归算法代码：
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDepth(root);
        return maxDiameter;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);

        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        _040DiameterOfBinaryTree solution = new _040DiameterOfBinaryTree();
        // 创建二叉树 [1,2,3,4,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int result = solution.diameterOfBinaryTree(root);

        // 打印输出结果
        System.out.println(result);
    }
}
