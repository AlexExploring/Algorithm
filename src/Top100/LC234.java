package Top100;

import java.util.ArrayList;
import java.util.List;

/**
 * ��������
 */
public class LC234 {

    /**
     * ��ֵ���Ƶ������к�ʹ��˫ָ���ж��Ƿ����
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }

        int l = 0,r = list.size()-1;
        while (l<=r){
            if (list.get(l)==list.get(r)){
                l++;r--;
            }else return false;
        }

        return true;
    }


    public boolean isPalindrome1(ListNode head) {
        if (head == null) {
            return true;
        }

        // �ҵ�ǰ�벿�������β�ڵ㲢��ת��벿������
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // �ж��Ƿ����
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // ��ԭ�������ؽ��
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    /**
     * �������벿�ַ�ת
     */
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * ��ָ��һ����һ������ָ��һ��������������ָ��ͬʱ����������ָ���ƶ��������ĩβ
     * ʱ����ָ��ǡ�õ�������м䡣ͨ����ָ�뽫�����Ϊ������
     */
    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
