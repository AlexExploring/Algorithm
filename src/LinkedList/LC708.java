package LinkedList;

/**
 * JZII 29， 排序的循环链表
 */
public class LC708 {

    /**
     * 思路：1.在中间能够找到一个节点cur，满足cur->val<=val<=cur->next->val，直接插入即可
     * 2. 找不到，则一定是所有的值都比它小或大，其实都会插入到边界跳跃点，即找到cur，满足
     * val<=cur->next->val<cur->val(比最小的还小）或cur->next->val<cur->val<=val
     * 比最大的还大）
     */
    public Node insert(Node head, int insertVal) {
        //处理head为null的情况
        Node node = new Node(insertVal);
        if (head == null) {
            head = node;
            head.next = head;
            return head;
        }

        Node cur = head;
        //遍历整个循环链表
        while (cur.next != head) {
            //insertVal 在别介跳跃点
            if (cur.next.val<cur.val) {
                if (cur.next.val>=insertVal || cur.val<=insertVal) break;
            }

            //insertVal 位于一个递增区间
            if (cur.val<=insertVal&&cur.next.val>=insertVal) break;
            cur = cur.next;
        }
        //画个图即可明白
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
