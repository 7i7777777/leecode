package leecodeHot100;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 * 提示：
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 */
public class _041LevelOrder {

    /**
     * 这道题是要求对二叉树进行层序遍历，即逐层地从左到右访问所有节点，并返回节点值的层序遍历结果。
     * 为了解决这个问题，我们可以使用广度优先搜索（BFS）的方法。
     * 具体步骤如下：
     * 1. 如果根节点为空，直接返回空列表。
     * 2. 创建一个队列，将根节点入队。
     * 3. 创建一个结果列表，用于存储层序遍历的结果。
     * 4. 使用一个循环，当队列不为空时，执行以下操作：
     * - 在每一层开始时，记录当前层的节点数，将当前层的节点值存入一个临时列表。
     * - 对当前层的每个节点进行以下操作：
     * - 将当前节点出队。
     * - 将当前节点的左右子节点（如果存在）入队。
     * - 将临时列表添加到结果列表中。
     * 5. 返回结果列表。
     * 以下是使用Java语言实现的代码：
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}
