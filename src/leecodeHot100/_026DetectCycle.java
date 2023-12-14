package leecodeHot100;

import utils.ListNode;

/**
 * 142. 环形链表 II
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 * 提示：
 * 链表中节点的数目范围在范围 [0, 104] 内
 * -105 <= Node.val <= 105
 * pos 的值为 -1 或者链表中的一个有效索引
 * 进阶：你是否可以使用 O(1) 空间解决此题？
 */
public class _026DetectCycle {

    /**
     * 这道题是要找到链表中环的入口节点。
     * 为了解决这个问题，我们可以使用快慢指针的方法。
     * 具体步骤如下：
     * 1. 定义两个指针，一个快指针和一个慢指针，初始时都指向链表的头节点。
     * 2. 使用快慢指针进行遍历链表，快指针每次移动两步，慢指针每次移动一步。
     * 3. 如果链表中存在环，那么快指针最终会追上慢指针，即两个指针会相遇。
     * 4. 当快慢指针相遇时，将慢指针重新指向链表的头节点，然后快指针和慢指针都以一步的速度移动，直到它们再次相遇。
     * 5. 当快慢指针再次相遇时，它们相遇的节点就是链表中环的入口节点。
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if(!hasCycle){
            return null;
        }
        slow = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        _026DetectCycle o = new _026DetectCycle();
        ListNode head1 = new ListNode(3);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(0);
        ListNode head4 = new ListNode(-4);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head2;
        ListNode listNode = o.detectCycle(head1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
