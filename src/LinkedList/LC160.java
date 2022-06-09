package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * �ཻ����
 * ��Ŀ�����������������ͷ�ڵ� headA �� headB �������ҳ������������������ཻ
 * ����ʼ�ڵ㡣����������������ཻ�ڵ㣬���� null ��
 */
public class LC160 {

    /**
     * ��ϣ��
     *
     * ʱ�临�Ӷ�O(m+n)
     * �ռ临�Ӷ�O(m)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            set.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (!set.add(temp)) return temp;
            else temp = temp.next;
        }

        return null;
    }

    /**
     * ˫ָ��
     *
     * ʱ�临�Ӷ�O(m+n)
     * �ռ临�Ӷ�O(1)
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        //��ʹ�������ཻ������Ҳ�����,ͬʱΪnull
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }
}
