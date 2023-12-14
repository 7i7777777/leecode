package leecodeHot100;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * 提示：
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 */
public class _039IsSymmetric {

    /**
     * 递归法
     * 这道题是要判断一棵二叉树是否是对称的，即以根节点为中心，左右子树镜像对称。
     * 为了解决这个问题，我们可以使用递归的方法。
     * 具体步骤如下：
     * 1. 如果根节点为空，说明是对称的，直接返回true。
     * 2. 调用递归函数  isSymmetricHelper ，传入根节点的左子树和右子树进行比较。
     * 3. 在递归函数中，如果左右子树都为空，说明是对称的，返回true。
     * 4. 如果左右子树中有一个为空，或者左右子树的值不相等，说明不是对称的，返回false。
     * 5. 递归地比较左子树的左子树和右子树的右子树，以及左子树的右子树和右子树的左子树。
     * 6. 如果上述两个比较都返回true，说明是对称的，返回true。
     * 7. 否则，返回false。
     * 以下是使用Java语言实现的递归算法代码：
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }
        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }

    /**
     * 好的，以下是使用迭代的方法来判断二叉树是否是对称的：
     * 具体步骤如下：
     * 1. 如果根节点为空，说明是对称的，直接返回true。
     * 2. 使用一个队列来存储需要比较的节点，初始时将根节点的左右子节点加入队列。
     * 3. 在循环中，每次从队列中取出两个节点进行比较。
     * 4. 如果两个节点都为空，说明是对称的，继续下一次循环。
     * 5. 如果两个节点中有一个为空，或者两个节点的值不相等，说明不是对称的，返回false。
     * 6. 将左节点的左子节点和右节点的右子节点加入队列。
     * 7. 将左节点的右子节点和右节点的左子节点加入队列。
     * 8. 重复步骤3-7，直到队列为空。
     * 9. 如果所有的节点都比较完毕，说明是对称的，返回true。
     * 以下是使用Java语言实现的迭代算法代码：
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }

            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    public static void main(String[] args) {
        _039IsSymmetric solution = new _039IsSymmetric();
        // 创建二叉树 [1,2,2,3,4,4,3]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean result = solution.isSymmetric1(root);

        // 打印输出结果
        System.out.println(result);
    }
}
