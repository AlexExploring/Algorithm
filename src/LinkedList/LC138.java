package LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * ���ƴ����ָ�������
 */
public class LC138 {

    /**
     * ������ѵ����ڱ�����cur�ڵ�ʱ��ԭ�����ж�Ӧ�ڵ��randomָ��Ľڵ����� �����п��ܻ�û�д���
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

        // map�������ռ临�Ӷ�O(n)
        Node node = head;
        // ʹ��hash��洢�ɽ����½���ӳ��
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