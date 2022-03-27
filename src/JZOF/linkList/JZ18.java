package JZOF.linkList;

import java.util.Scanner;

/**
 *ɾ������Ľڵ�
 *
 * ����û��ͷ�ڵ� ����Ԫ�ڵ���Ҫ��������
 */
public class JZ18 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    }

    //˫ָ��
    public ListNode deleteNode1(ListNode head, int val) {
        if (head==null) return null;
        if(head.val == val) return head.next;
        ListNode pre = head, cur = head.next;
        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if(cur != null) pre.next = cur.next;  //˵���ҵ��˽ڵ�ֵ��val��ȵĽڵ�
        return head;
    }

    //��ָ��
    public ListNode deleteNode2(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode cur = head;
        while (cur.next != null && cur.next.val != val)
            cur = cur.next;
        if (cur.next != null) cur.next = cur.next.next;
        return head;
    }

    //���һ��ͷ�ڵ� ��ָ��
    public ListNode deleteNode3(ListNode head, int val) {
        ListNode flag = new ListNode(-1);
        flag.next = head;
        ListNode cur = flag;
        while (cur.next!=null&&cur.next.val!=val){
            cur = cur.next;
        }
        if (cur.next!=null) cur.next = cur.next.next;
        return flag.next;
    }

    /**
     *�ݹ�ʵ��
     *
     * һֱ�ݹ鵽�нڵ�ֵ��val��ȵĽڵ�򵽴�����β����
     * �ٵݹ�Ľ���������������
     */
    public ListNode deleteNode4(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next; //�Թ�Ҫɾ���Ľڵ㣬����ǰ��head
        } else {
            head.next = deleteNode3(head.next, val);
        }
        return head;
    }
}

