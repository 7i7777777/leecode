package leecodeHot100;

import utils.ListNode;

/**
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class _028AddTwoNumbers {

    /**
     * 为了解决这个问题，我们可以使用模拟加法的方法。
     * 具体步骤如下：
     * 1. 定义一个新的链表，用来存储相加后的结果。
     * 2. 使用一个变量carry来表示进位，初始值为0。
     * 3. 使用两个指针分别指向两个链表的头节点。
     * 4. 遍历两个链表，将对应位置的节点值相加，并加上进位carry。
     * 5. 将相加的结果对10取余，得到当前位的值，并更新进位carry为相加结果除以10的商。
     * 6. 将当前位的值创建一个新的节点，并将其添加到结果链表中。
     * 7. 将两个指针后移一位，继续遍历下一位。
     * 8. 如果其中一个链表遍历完毕，但另一个链表还有剩余节点，则将剩余节点的值与进位相加，并将结果添加到结果链表中。
     * 9. 如果两个链表都遍历完毕，但进位不为0，则将进位创建一个新的节点，并将其添加到结果链表的末尾。
     * 10. 返回结果链表的头节点。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        if (carry != 0) {
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
