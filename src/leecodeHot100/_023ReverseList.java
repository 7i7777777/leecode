package leecodeHot100;

import utils.ListNode;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 * 提示：
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 */
public class _023ReverseList {

    //反转链表可以使用迭代或递归的方式来实现。

    /**
     * **迭代方法**：
     * 使用三个指针prev、curr和next来遍历链表并改变指针的指向。
     * 初始时，prev指向null，curr指向head，next指向curr的下一个节点。
     * 在遍历过程中，将curr的next指针指向prev，然后将prev、curr和next指针都向后移动一个节点。
     * 直到遍历完整个链表，最后返回prev作为反转后的链表的头节点。
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    /**
     * **递归方法**：
     * 递归方法是将链表从头节点开始不断地递归到尾节点，然后在递归的过程中改变指针的指向。
     * 递归的结束条件是当前节点或下一个节点为空。
     * 在递归的过程中，将当前节点的next指针指向前一个节点，然后返回最后一个节点作为反转后的链表的头节点。
     */

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

}
