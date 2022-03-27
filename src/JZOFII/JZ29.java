package JZOFII;

/**
 * �����ѭ������
 */
public class JZ29 {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            head = node;
            head.next = head;
            return head;
        }

        Node cur = head;
        while (cur.next!=head) {
            //���������е�ֵ����insertValС���
            if (cur.next.val<cur.val) {
                if (cur.next.val>=insertVal || cur.val<=insertVal) break;
            }

            if (cur.val<=insertVal&&cur.next.val>=insertVal) break;
            cur = cur.next;
        }
        cur.next = new Node(insertVal,cur.next);
        return head;
    }

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}

