package leecodeHot100;

import utils.TreeNode;

/**
 * 114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * 示例 1：
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * 输入：root = [0]
 * 输出：[0]
 * 提示：
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 */
public class _046Flatten {

    /**
     * 为了将二叉树展开为链表，我们可以使用递归的方法。具体步骤如下：
     * 1. 首先，我们需要处理特殊情况，即树为空的情况。如果树为空，直接返回即可。
     * 2. 如果树不为空，我们将根节点的左子树展开为链表，然后将根节点的右子树展开为链表。
     * 3. 接下来，我们需要将根节点的右子树作为根节点的右孩子，并将根节点的左子树设为null。
     * 4. 最后，我们需要将原来的右子树连接到当前右子树的末尾。
     * 下面是相应的Java代码实现：
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        curr.right = right;
    }
}
