package jzoffer.day02_List;

import java.util.Stack;

public class ReversePrint {
    //输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
    public class ListNode{
        int val ;
        ListNode next;
        ListNode(int x){ val = x; }
    }
    public int[] reversePrint(ListNode head){
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for(int i=0;i<size;i++){
            print[i]=stack.pop().val;
        }
        return print;
    }
}