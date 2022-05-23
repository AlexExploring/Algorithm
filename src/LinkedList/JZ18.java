package LinkedList;

import java.util.Scanner;

/**
 * ɾ������Ľڵ�
 *
 * ����û��ͷ�ڵ� ����Ԫ�ڵ���Ҫ��������
 */
public class JZ18 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    }

    /**
     * ˫ָ��
     */
    public ListNode deleteNode1(ListNode head, int val) {
        if (head==null) return null;
        if(head.val == val) return head.next;

        ListNode pre = head, cur = head.next;
        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }

        //˵���ҵ��˽ڵ�ֵ��val��ȵĽڵ㣬��Ҫɾ��curָ��Ľڵ�
        if(cur != null) pre.next = cur.next;

        return head;
    }

    /**
     * ��ָ��
     */
    public ListNode deleteNode2(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;

        ListNode cur = head;
        while (cur.next != null && cur.next.val != val){
            cur = cur.next;
        }

        if (cur.next != null) cur.next = cur.next.next;

        return head;
    }
}

