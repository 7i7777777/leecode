package leecodeHot100;

import utils.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * 示例 1：
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 * 提示：
 * 树中节点数目范围是 [1, 3 * 104]
 * -1000 <= Node.val <= 1000
 */
public class _050MaxPathSum {

    /**
     * 1. 定义一个变量 maxSum ，用于保存路径和的最大值。初始值设为负无穷大。
     * 2. 定义一个递归函数 maxPathSum ，计算以当前节点为根节点的子树的最大路径和。
     * 3. 在 maxPathSum 函数中，首先处理递归的终止条件，即当节点为空时，返回0。
     * 4. 分别递归计算左子树和右子树的最大路径和，分别保存在变量 leftSum 和 rightSum 中。
     * 5. 计算当前节点的最大路径和，有以下几种情况：
     *    - 如果 leftSum 和 rightSum 都为正数，则当前节点的最大路径和为 node.val + leftSum + rightSum 。
     *    - 如果 leftSum 和 rightSum 有一个为负数，则当前节点的最大路径和为 node.val + max(leftSum, rightSum) 。
     *    - 如果 leftSum 和 rightSum 都为负数，则当前节点的最大路径和为 node.val 。
     * 6. 更新 maxSum 为当前节点的最大路径和和 maxSum 的较大值。
     * 7. 返回当前节点的最大路径和，作为递归的结果。
     * 8. 在主函数中调用 maxPathSum 函数，得到二叉树的最大路径和，即为最终结果。
     */

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxSum;
    }

    private int maxPathSumHelper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = Math.max(maxPathSumHelper(node.left), 0);
        int rightSum = Math.max(maxPathSumHelper(node.right), 0);

        int currSum = node.val + leftSum + rightSum;
        maxSum = Math.max(maxSum, currSum);

        return node.val + Math.max(leftSum, rightSum);
    }
}
