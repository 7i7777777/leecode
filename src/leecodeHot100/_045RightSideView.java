package leecodeHot100;

import utils.TreeNode;

import java.util.*;

/**
 * 199. 二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 示例 1:
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * 示例 2:
 * 输入: [1,null,3]
 * 输出: [1,3]
 * 示例 3:
 * 输入: []
 * 输出: []
 * 提示:
 * 二叉树的节点个数的范围是 [0,100]
 * -100 <= Node.val <= 100
 */
public class _045RightSideView {


    /**
     * 这道题是要求返回二叉树从右侧所能看到的节点值。
     * 为了解决这个问题，我们可以使用广度优先搜索（BFS）的方法。
     * 具体步骤如下：
     * 1. 如果根节点为空，直接返回空列表。
     * 2. 定义一个队列，将根节点入队。
     * 3. 定义一个结果列表。
     * 4. 进行广度优先搜索，每次遍历一层的节点。
     * 5. 在每层遍历中，记录每层最右边的节点的值，并将其加入结果列表。
     * 6. 将当前层的所有节点的子节点（如果存在）入队。
     * 7. 重复步骤4-6，直到队列为空。
     * 8. 返回结果列表。
     * 以下是使用Java语言实现的代码：
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    result.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _045RightSideView o = new _045RightSideView();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        node2.right = node4;
        List<Integer> list = o.rightSideView(root);
        System.out.println(list);
    }
}
