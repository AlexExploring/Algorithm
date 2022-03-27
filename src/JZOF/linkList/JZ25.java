package JZOF.linkList;


import java.util.ArrayList;

/**
 *�ϲ��������������
 *
 */
public class JZ25 {
    public static void main(String[] args) {

    }

    //���һ���ƽ��
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0), cur = dum;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }

    //������
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = null,tail = null;

        while (l1!=null&&l2!=null){
            if (l1.val<= l2.val){
                if (head==null) head = l1;
                else tail.next = l1;
                tail = l1;
                l1 = l1.next;
            }else {
                if (head==null) head = l2;
                else tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }
        }

        if (l1!=null){
            if (head==null) head = l1;
            else tail.next = l1;
            tail = l1;
            l1 = l1.next;
        }

        if (l2!=null){
            if (head==null) head = l2;
            else tail.next = l2;
            tail = l2;
            l2 = l2.next;
        }

        return head;
    }
}
