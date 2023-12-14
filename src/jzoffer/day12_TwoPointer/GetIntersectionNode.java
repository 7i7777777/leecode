package jzoffer.day12_TwoPointer;

public class GetIntersectionNode {

    //输入两个链表，找出它们的第一个公共节点。

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x;}
    }

    public ListNode getIntersectionNode(ListNode headA,ListNode headB){
        if(headA == null && headB == null){
            return null;
        }
        ListNode pA = headA, pB = headB;
        while(pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}