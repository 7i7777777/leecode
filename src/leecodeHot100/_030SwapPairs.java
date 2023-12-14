package leecodeHot100;

import utils.ListNode;

/**
 * 24. 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 * 提示：
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 */
public class _030SwapPairs {

    /**
     * 1. 定义一个虚拟头节点dummy，将其next指针指向链表的头节点。
     * 2. 定义两个指针prev和curr，分别指向虚拟头节点和头节点。
     * 3. 使用一个循环遍历链表，每次迭代交换两个相邻节点。
     * 4. 在每次迭代中，先将prev的next指针指向curr的下一个节点，
     * 将curr的next指针指向curr的下下个节点，
     * 然后将prev的next指针指向curr，
     * 将curr的next指针指向curr的下一个节点。
     * 5. 更新prev和curr的指向，使其指向下一组相邻节点。
     * 6. 重复步骤3-5，直到交换完所有相邻节点。
     * 7. 返回虚拟头节点的next指针，即为交换后的链表头节点。
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = curr;
            prev.next = next;
            prev = curr;
            curr = curr.next;
        }

        return dummy.next;
    }
}
