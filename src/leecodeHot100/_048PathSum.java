package leecodeHot100;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;


/**
 * 437. 路径总和 III
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 示例 1：
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * 示例 2：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 * 提示:
 * 二叉树的节点个数的范围是 [0,1000]
 * -109 <= Node.val <= 109
 * -1000 <= targetSum <= 1000
 */
public class _048PathSum {

    /**
     * 这道题是要求在给定的二叉树中，找出节点值之和等于目标和的路径数量。
     * 为了解决这个问题，我们可以使用递归的方法。
     * 具体步骤如下：
     * 1. 定义一个全局变量count，用于记录路径数量。
     * 2. 使用递归函数来遍历二叉树的每个节点。
     * 3. 在递归函数中，对于当前节点，先判断是否存在以当前节点为起点的路径，使得节点值之和等于目标和。如果存在，则将count加1。
     * 4. 然后递归地遍历当前节点的左子树和右子树，将目标和减去当前节点的值，继续寻找路径。
     * 5. 最后返回count作为结果。
     * 以下是使用Java语言实现的代码：
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        // 从当前节点出发的路径和等于 targetSum 的数量
        int pathsFromRoot = countPaths(root, targetSum);

        // 递归调用左右子树
        int pathsOnLeft = pathSum(root.left, targetSum);
        int pathsOnRight = pathSum(root.right, targetSum);

        // 返回总的路径数量
        return pathsFromRoot + pathsOnLeft + pathsOnRight;
    }

    private int countPaths(TreeNode node, int targetSum) {
        if (node == null) {
            return 0;
        }

        int pathsFromNode = 0;

        // 从当前节点出发的路径和等于 targetSum 的数量
        if (node.val == targetSum) {
            pathsFromNode++;
        }

        // 递归调用左右子树
        pathsFromNode += countPaths(node.left, targetSum - node.val);
        pathsFromNode += countPaths(node.right, targetSum - node.val);

        return pathsFromNode;
    }

    public static void main(String[] args) {
        _048PathSum solution = new _048PathSum();

        // 输入: root = [1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000], targetSum = 0
        TreeNode root = new TreeNode(1000000000);
        root.left = new TreeNode(1000000000);
        root.left.left = null;
        root.left.right = new TreeNode(294967296);
        root.left.right.left = null;
        root.left.right.right = new TreeNode(1000000000);
        root.left.right.right.left = null;
        root.left.right.right.right = new TreeNode(1000000000);
        root.left.right.right.right.left = null;
        root.left.right.right.right.right = new TreeNode(1000000000);
        int targetSum = 0;

        int result = solution.pathSum(root, targetSum);

        System.out.println(result);
    }
}
