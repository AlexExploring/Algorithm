package LinkedList;

/**
 * ��������
 */
public class LC148 {

    /**
     * �Զ����µĹ鲢����
     *
     * ʱ�临�Ӷȣ�O(nlogn)������ n ������ĳ��ȡ�
     * �ռ临�Ӷȣ�O(logn)������ n ������ĳ��ȡ��ռ临�Ӷ���Ҫȡ���ڵݹ���õ�ջ�ռ䡣��
     */
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        //�ڵ�Ϊ��
        if (head == null) {
            return null;
        }
        //ֻ��һ���ڵ�
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        //����������е�
        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;

        //�ݹ���߲��֣�������mid
        ListNode list1 = sortList(head, mid);
        //�ݹ��ұ߲��֣�������tail
        ListNode list2 = sortList(mid, tail);
        //�ϲ��������������Ϊһ����������������
        ListNode sorted = mergeTwoLists(list1, list2);

        return sorted;
    }

    public ListNode sortList1(ListNode head) {
        //����ڵ����С�ڵ���1����ֹ
        if (head == null || head.next == null)
            return head;
        //ʹ�ÿ���ָ�����������е�,����fast����ָ��head.next(
        // ���fast��head��ָ��head�Ļ�����ô���ڳ���Ϊ2��������
        // ����ָ�������ʵ���ϱ�����Ϊ���������ȷֱ�Ϊ(2,0)������
        // ����������ѭ��)
        //���ߣ�����һ��dummyHeadʹ�ã�dummyHead.next = head;
        //Ȼ�� fast��head��ָ��dummyHead;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head1 = slow.next;

        //�Ͽ�head��head1
        slow.next = null;

        //�ݹ�
        ListNode left = sortList(head);
        ListNode right = sortList(head1);

        ListNode merged = mergeTwoLists(left, right);

        return merged;
    }

    /**
     * �Ե����ϵĹ鲢����
     *
     * ���Ӷȷ�����
     * ʱ�临�Ӷȣ�O(nlogn)
     * �ռ临�Ӷȣ�O(1)
     */
    public ListNode sortList2(ListNode head) {
        if (head == null) return null;

        //��ȡ����ĳ���
        int length = 0;
        ListNode node = head;
        while (node!=null) {
            length++;
            node= node.next;
        }

        ListNode dummyHead = new ListNode(0, head);

        // �鲢����,��subLength >= length ʱ��˵�����������������
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

                //�ϲ�������������Ϊһ����������������
                ListNode merged = mergeTwoLists(head1, head2);
                //�����Ѿ��������������
                prev.next = merged;
                //Ϊ��һ��������׼��
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
