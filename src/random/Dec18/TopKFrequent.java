package random.Dec18;

import java.util.*;

public class TopKFrequent {

    public  class ListNode{
        String val;
        ListNode next;
        ListNode(String x){ val = x;}
    }

    public ListNode sort(String[] words){
        ListNode head = new ListNode(null);
        ListNode cur = head;
        Set<String> set = new HashSet<String>();
        for(int i=0;i<words.length;i++){
            if(set.add(words[i])){
                cur.val=words[i];
                cur=cur.next;
            }
        }
        return head.next;
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        List<String> rec = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            rec.add(entry.getKey());
        }
        Collections.sort(rec, (word1, word2) -> cnt.get(word1) == cnt.get(word2) ? word1.compareTo(word2) : cnt.get(word2) - cnt.get(word1));
        return rec.subList(0, k);
    }
}