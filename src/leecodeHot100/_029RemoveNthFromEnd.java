package leecodeHot100;

import utils.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class _029RemoveNthFromEnd {

    /**
     * 1. 定义两个指针，一个快指针和一个慢指针，初始时都指向链表的头节点。
     * 2. 将快指针向前移动n个位置，使得快指针和慢指针之间相差n个节点。
     * 3. 同时移动快指针和慢指针，直到快指针指向链表的末尾。
     * 4. 此时慢指针指向倒数第n个节点的前一个节点。
     * 5. 将慢指针的next指针指向倒数第n个节点的下一个节点，即删除倒数第n个节点。
     * 6. 返回链表的头节点。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        //将快指针向前移动n个位置
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        //同时移动快慢指针
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //删除倒数第n个节点
        slow.next = slow.next.next;

        return dummy.next;
    }
}
