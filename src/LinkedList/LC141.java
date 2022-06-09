package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * ��������
 *
 * ��Ŀ������һ�������ͷ�ڵ� head ���ж��������Ƿ��л�����������д��ڻ� ���򷵻� true �� ���򣬷��� false ��
 *
 * ���ݷ�Χ��
 * �����нڵ����Ŀ��Χ�� [0, 104]
 * -105 <= Node.val <= 105
 */
public class LC141 {

    /**
     * set
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     *  ����ָ��
     */
    public boolean hasCycle1(ListNode head) {
        //ΪheadΪnull��ֻ��һ���ڵ�
        if (head == null || head.next == null) return false;

        ListNode slow = head,fast = head.next;

        //������ڻ�����ô�ڻ���һ������������slow = fast
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
