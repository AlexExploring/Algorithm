package LinkedList;

/**
 * ��������
 */

/**
 * ��������
 */
public class LC148 {

    /**
     * �Զ����µĹ鲢����
     *
     * ʱ�临�Ӷȣ�O(n \log n)O(nlogn)������ nn ������ĳ��ȡ�
     * �ռ临�Ӷȣ�O(\log n)O(logn)������ nn ������ĳ��ȡ��ռ临�Ӷ���Ҫȡ���ڵݹ���õ�ջ�ռ䡣��
     */
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        //�ڵ�Ϊ��
        if (head == null) {
            return head;
        }
        //ֻ��һ���ڵ�
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }

        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = mergeTwoLists(list1, list2);
        return sorted;
    }

    /**
     * �Ե����ϵĹ鲢����
     */
    public ListNode sortList1(ListNode head) {
        if (head == null) return null;

        //��ȡ����ĳ���
        int length = 0;
        ListNode node = head;
        while (node!=null) {
            length++;
            node= node.next;
        }

        ListNode dummyHead = new ListNode(0, head);

        // �鲢����
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;//curr ָ��ǰ�鲢���ֵĵ�һ���ڵ�
            while (curr != null) {
                //һ��鲢�����еĵ�һ����
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next!=null; i++) {
                    curr = curr.next;
                }

                //һ��鲢�����ֵĵڶ�����
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr!=null && curr.next!=null; i++) {
                    curr = curr.next;
                }

                //����curr Ϊ��һ��鲢������׼��
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }

                ListNode merged = mergeTwoLists(head1, head2);
                prev.next = merged;
                while (prev.next != null){
                    prev = prev.next;
                }

                //��currָ����һ����Ҫ�鲢�Ĳ���
                curr = next;
            }
        }

        return dummyHead.next;
    }

    /**
     * �ϲ�������������Ϊһ���µ���������
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0),tail = head;
        while (l1!=null&&l2!=null){
            if (l1.val<=l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = l1 != null ? l1 : l2;

        return head.next;
    }
}
