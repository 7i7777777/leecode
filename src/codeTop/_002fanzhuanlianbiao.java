package codeTop;

import jzoffer.day02_List.ReverseList;
import utils.ListNode;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @ClassName _002fanzhuanlianbiao
 * @Description TODO
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 输入：head = []
 * 输出：[]
 * @Author 2+7
 * @Date 2023/3/23 14:14
 */
public class _002fanzhuanlianbiao {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head; //12345
        while (curr != null) {
            ListNode temp = curr.next; //2345  //345
            curr.next = prev; //1  //1 2
            prev = curr; //1  //2 1
            curr = temp; //2345 //345
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        ListNode listNode = reverseList(head1);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}