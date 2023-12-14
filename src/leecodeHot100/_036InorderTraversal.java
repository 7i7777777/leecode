package leecodeHot100;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class _036InorderTraversal {

    /**
     * 递归法
     * 中序遍历是一种深度优先搜索（DFS）的遍历方式，具体步骤如下：
     * 1. 如果根节点为空，直接返回空列表。
     * 2. 创建一个空列表  result ，用于存储遍历结果。
     * 3. 定义一个辅助函数  inorderTraversalHelper ，用于递归地进行中序遍历。
     * 4. 在  inorderTraversalHelper  中，首先递归遍历左子树，将遍历结果添加到  result  中。
     * 5. 然后将根节点的值添加到  result  中。
     * 6. 最后递归遍历右子树，将遍历结果添加到  result  中。
     * 7. 调用  inorderTraversalHelper  函数，将根节点作为参数传入。
     * 8. 返回  result ，即为中序遍历结果。
     * 以下是使用Java语言实现的递归算法代码：
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversalHelper(root, result);
        return result;
    }

    private void inorderTraversalHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorderTraversalHelper(node.left, result);
        result.add(node.val);
        inorderTraversalHelper(node.right, result);
    }

    /**
     * 迭代法
     * 当然，我们也可以使用迭代的方法来实现二叉树的中序遍历。使用迭代方法时，我们需要借助栈来模拟递归的过程。
     * 具体步骤如下：
     * 1. 如果根节点为空，直接返回空列表。
     * 2. 创建一个空列表  result ，用于存储遍历结果。
     * 3. 创建一个空栈  stack ，用于辅助迭代过程。
     * 4. 定义一个指针  curr ，初始时指向根节点。
     * 5. 当  curr  不为空或栈不为空时，执行以下操作：
     * - 将  curr  及其左子节点依次入栈，直到左子节点为空。
     * - 弹出栈顶节点，将其值添加到  result  中。
     * - 将  curr  指向弹出节点的右子节点。
     * 6. 返回  result ，即为中序遍历结果。
     * 以下是使用Java语言实现的迭代算法代码：
     */

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }

    public static void main(String[] args) {
        _036InorderTraversal o = new _036InorderTraversal();
        // 创建二叉树 [1,null,2,3]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = o.inorderTraversal(root);
        // 打印输出结果
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
