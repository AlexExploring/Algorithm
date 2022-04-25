package LinkedList;

import java.util.HashMap;

/**
 * ɾ������ĵ�����n���ڵ㣬���ҷ��������ͷ�ڵ�
 */
public class LC19 {

    /**
     *  ��map��¼����ڵ��Ӧ�����ã�
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tail = head;
        HashMap<Integer, ListNode> map = new HashMap<>();
        int index = 1;
        while (tail!=null){
            map.put(index++,tail);
            tail = tail.next;
        }

        int des = index-n;
        if (des==1){
            return head.next;
        }
        ListNode pre = map.get(des-1);
        pre.next = map.get(des).next;
        return head;
    }

    /**
     *  ����ָ�룬��ָ������n����Ȼ�����һ���ߣ�ֱ����ָ���ߵ����Ҫע����ǿ�����
     *  Ҫɾ����һ���ڵ㣬���ʱ�����ֱ�ӷ���head -> next
     *
     *  ע�⣺nӦ���� <= head�ĳ���
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head==null||head.next==null) return null;
        ListNode fast = head,slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast==null) return head.next;
        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}