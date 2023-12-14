package jzoffer.day12_TwoPointer;

public class MergeTwoLists {

    //输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

    public  class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x;}
    }

    //利用第三个链表
    public  ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode merge = new ListNode(0) ;
        ListNode cur = merge;
        while(l1 !=null && l2!=null){
            if(l1.val<l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1:l2;
        return merge.next;
    }


}