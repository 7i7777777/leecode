package leecodeHot100;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 98. 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1：
 * 输入：root = [2,1,3]
 * 输出：true
 * 示例 2：
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 */
public class _043IsValidBST {

    /**
     * 这道题是要判断给定的二叉树是否是一个有效的二叉搜索树。
     * 为了解决这个问题，我们可以使用递归和中序遍历的方法。
     * 具体步骤如下：
     * 1. 定义一个全局变量prev，用于保存上一个遍历到的节点的值。
     * 2. 使用中序遍历的方式遍历二叉树。
     * 3. 在遍历的过程中，判断当前节点的值是否大于prev，如果不是则返回false。
     * 4. 更新prev为当前节点的值。
     * 5. 递归地遍历当前节点的左子树和右子树。
     * 6. 如果遍历完成后没有返回false，则返回true。
     */

    private Integer prev;

    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorderTraversal(root);
    }

    private boolean inorderTraversal(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!inorderTraversal(root.left)) {
            return false;
        }
        if (prev != null && root.val <= prev) {
            return false;
        }
        prev = root.val;
        return inorderTraversal(root.right);
    }
}
