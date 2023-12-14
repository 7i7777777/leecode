package leecodeHot100;

import utils.ListNode;

/**
 * 25. K 个一组翻转链表
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 示例 2：
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * 提示：
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 */
public class _031reverseKGroup {

    /**
     * 1. 定义一个虚拟头节点dummy，将其next指针指向链表的头节点。
     * 2. 定义两个指针prev和curr，分别指向虚拟头节点和头节点。
     * 3. 使用一个循环遍历链表，每次迭代翻转一组k个节点。
     * 4. 在每次迭代中，先判断剩余的节点数是否大于等于k，如果小于k，则不进行翻转，直接返回结果。
     * 5. 如果剩余的节点数大于等于k，则进行翻转操作。
     * 6. 使用一个循环将k个节点进行翻转，具体步骤如下：
     * - 定义一个指针nextGroup，指向当前组的第k+1个节点。
     * - 使用一个循环将当前组的k个节点进行翻转，具体步骤如下：
     * - 将curr的next指针指向nextGroup，断开当前组的连接。
     * - 将curr和nextGroup之间的节点依次插入到nextGroup之后，实现翻转。
     * - 更新prev的next指针指向翻转后的头节点，即curr的下一个节点。
     * - 更新curr和nextGroup的指向，使其指向下一组待翻转的节点。
     * - 完成一组k个节点的翻转后，更新prev的指向，使其指向翻转后的尾节点，即nextGroup的前一个节点。
     * 7. 返回虚拟头节点的next指针，即为修改后的链表头节点
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        // 计算链表长度
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        // 进行翻转
        for (int i = 0; i < length / k; i++) {
            for (int j = 0; j < k - 1; j++) {
                ListNode temp = curr.next;
                curr.next = temp.next;
                temp.next = prev.next;
                prev.next = temp;
            }
            prev = curr;
            curr = curr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        _031reverseKGroup o = new _031reverseKGroup();
        // 创建链表 [1,2,3,4,5]
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        int k = 3;

        ListNode result = o.reverseKGroup(head, k);
        while(result!=null){
            System.out.print(result.val+" ");
            result = result.next;
        }
    }
}
