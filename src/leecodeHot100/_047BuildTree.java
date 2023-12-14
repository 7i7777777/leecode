package leecodeHot100;

import utils.TreeNode;

import java.util.Arrays;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历，
 * inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * 示例 1:
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * 提示:
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 */
public class _047BuildTree {

    /**
     * 这道题是要根据给定的先序遍历和中序遍历序列构造二叉树，并返回根节点。
     * 为了解决这个问题，我们可以使用递归的方法。
     * 具体步骤如下：
     * 1. 如果先序遍历序列或中序遍历序列为空，直接返回null。
     * 2. 取出先序遍历序列的第一个元素作为根节点的值。
     * 3. 在中序遍历序列中找到根节点的值所在的位置，将中序遍历序列分成左子树和右子树。
     * 4. 根据左子树的长度，将先序遍历序列分成左子树和右子树。
     * 5. 递归地构造左子树，并将返回的根节点作为当前根节点的左子节点。
     * 6. 递归地构造右子树，并将返回的根节点作为当前根节点的右子节点。
     * 7. 返回当前根节点。
     * 以下是使用Java语言实现的代码：
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, rootIndex + 1);
        int[] rightPreorder = Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] rightInorder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);
        return root;
    }
}
