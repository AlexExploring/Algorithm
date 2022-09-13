package LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * ��������
 */
public class LC143 {

    public static void main(String[] args) {
        //��������
        int[] data = new int[]{1,2,3,4,5};
        ListNode head = null,tail = null;
        for (int num : data) {
            if (head != null) {
                tail.next = new ListNode(num);
                tail = tail.next;
            }else {
                head = new ListNode(num);
                tail = head;
            }
        }

        new LC143().reorderList(head);
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val+" ");
            p = p.next;
        }
    }

    /**
     * �������Ա�list�洢����Ľڵ㣬�Ϳ���ͨ���±��������
     */
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }

        int i = 0,j = list.size()-1;
        while (i<j) {
            list.get(i).next = list.get(j);
            i++;
            list.get(j).next = list.get(i);
            j--;
        }

        list.get(i).next = null;
    }

    /**
     * ����2��Ѱ�������е㣨LC876�� + ��������LC206�� + �ϲ�����
     *
     * ˼·���������е��Ҷ˵�����ת�����е���ߵ�����ϲ�
     */
    public void reorderList1(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        //��������е��Ϊ����
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1,l2);
    }

    /**
     * ����������е�
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * ��ת����
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * ����ϲ���������
     */
    public void mergeList(ListNode l1,ListNode l2) {
        ListNode l1_temp,l2_temp;
        while (l1!=null && l2!=null) {
            l1_temp = l1.next;
            l2_temp = l2.next;

            l1.next = l2;
            l1 = l1_temp;

            l2.next = l1;
            l2 = l2_temp;
        }
    }
}
