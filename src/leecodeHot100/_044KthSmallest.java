package leecodeHot100;

import utils.TreeNode;

/**
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * 示例 1：
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 示例 2：
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 * 提示：
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 */
public class _044KthSmallest {

    /**
     * 这道题是要在二叉搜索树中查找第k小的元素。
     * 为了解决这个问题，我们可以使用中序遍历的方法。
     * 具体步骤如下：
     * 1. 定义一个计数器count，用来记录当前遍历的节点的排名。
     * 2. 使用中序遍历的方式遍历二叉搜索树。
     * 3. 在遍历的过程中，当count等于k时，说明找到了第k小的元素，返回当前节点的值。
     * 4. 否则，继续遍历右子树，增加计数器count的值。
     * 5. 如果count大于k，说明第k小的元素在左子树中，继续遍历左子树。
     * 6. 最终返回第k小的元素。
     */
    private int count;
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = 0;
        inorderTraversal(root, k);
        return result;
    }

    public void inorderTraversal(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        inorderTraversal(root.right, k);
    }
}
