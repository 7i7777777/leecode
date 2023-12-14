package leecodeHot100;

import utils.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：
 * “对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 */
public class _049LowestCommonAncestor {

    /**
     * 这道题是要找到二叉树中两个指定节点的最近公共祖先。
     * 为了解决这个问题，我们可以使用递归的方法。
     * 具体步骤如下：
     * 1. 如果根节点为空，直接返回null。
     * 2. 如果根节点等于p或q，说明根节点就是最近公共祖先，直接返回根节点。
     * 3. 递归地在左子树中查找p和q的最近公共祖先，将结果保存在变量left中。
     * 4. 递归地在右子树中查找p和q的最近公共祖先，将结果保存在变量right中。
     * 5. 如果left和right都不为空，说明p和q分别位于根节点的左右子树中，根节点就是最近公共祖先，直接返回根节点。
     * 6. 如果left为空，说明p和q都不在左子树中，最近公共祖先在右子树中，返回right。
     * 7. 如果right为空，说明p和q都不在右子树中，最近公共祖先在左子树中，返回left。
     * 以下是使用Java语言实现的代码：
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return null;
    }
}
