package jzoffer.day02_List;

public class ReverseList {
    //定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseList1(ListNode head){
//        ListNode list = null;
//        ListNode temp = head;
//        Stack<ListNode> stack = new Stack<ListNode>();
//        while(temp != null){
//            stack.push(head);
//            temp = temp.next;
//        }
//        while(stack.size()!= 0){
//            list.next=stack.pop();
//        }
//        return list;
        ListNode prev =null;
        ListNode curr = head;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return  prev;
    }
    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}