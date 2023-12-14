package random.Dec18;


import java.util.HashSet;
import java.util.Set;

public class Sort {

    public  class ListNode{
        String val;
        ListNode next;
        ListNode(String x){ val = x;}
    }

    public  ListNode sort(String[] words){
        ListNode head = new ListNode(null);
        ListNode cur = head;
        Set<String> set = new HashSet<String>();
        int k=0;
        for(int i=0;i<words.length;i++){
            if(!set.add(words[i])){
                k++;
                continue;
            }
            head=cur;
            cur.val=words[i];
            cur=head.next;
            System.out.println(k);
        }
        return head;
    }

}