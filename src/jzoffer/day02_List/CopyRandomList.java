package jzoffer.day02_List;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    //请实现copyRandomList函数，复制一个复杂链表。
    // 在复杂链表中，每个节点除了有一个next指针指向下一个节点，还有一个random指针指向链表中的任意节点或者null

    Map<Node, Node> cachedNode = new HashMap<Node, Node>();
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    //哈希表+回溯法
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }
}