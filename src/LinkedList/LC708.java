package LinkedList;

/**
 * JZII 29�� �����ѭ������
 */
public class LC708 {

    /**
     * ˼·��1.���м��ܹ��ҵ�һ���ڵ�cur������cur->val<=val<=cur->next->val��ֱ�Ӳ��뼴��
     * 2. �Ҳ�������һ�������е�ֵ������С�����ʵ������뵽�߽���Ծ�㣬���ҵ�cur������
     * val<=cur->next->val<cur->val(����С�Ļ�С����cur->next->val<cur->val<=val
     * �����Ļ���
     */
    public Node insert(Node head, int insertVal) {
        //����headΪnull�����
        Node node = new Node(insertVal);
        if (head == null) {
            head = node;
            head.next = head;
            return head;
        }

        Node cur = head;
        //��������ѭ������
        while (cur.next != head) {
            //insertVal �ڱ����Ծ��
            if (cur.next.val<cur.val) {
                if (cur.next.val>=insertVal || cur.val<=insertVal) break;
            }

            //insertVal λ��һ����������
            if (cur.val<=insertVal&&cur.next.val>=insertVal) break;
            cur = cur.next;
        }
        //����ͼ��������
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
