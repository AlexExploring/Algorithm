package LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制带随机指针的链表
 */
public class LC138 {

    /**
     * 本题的难点在于遍历到cur节点时，原链表中对应节点的random指向的节点在新 链表中可能还没有创建
     */
    Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        if (!map.containsKey(head)) {
            Node newHead = new Node(head.val);
            map.put(head, newHead);
            newHead.next = copyRandomList(head.next);
            newHead.random = copyRandomList(head.random);
        }

        return map.get(head);
    }

    public Node copyRandomList1(Node head) {
        if (head == null) return null;

        // map方法，空间复杂度O(n)
        Node node = head;
        // 使用hash表存储旧结点和新结点的映射
        Map<Node, Node> map = new HashMap<>();

        while (node != null) {
            Node clone = new Node(node.val);
            map.put(node, clone);
            node = node.next;
        }
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }

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
}