package JZOF.linkList;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 *��β��ͷ��ӡ����
 */

public class JZ6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        ListNode head = null,tail = null;
        for (int i = 0; i < n; i++) {
            ListNode s = new ListNode(scan.nextInt());
            if (i==0){
                head = s;
            }else tail.next = s;
            tail = s;
        }
        tail.next = null;


        int [] ans = reversePrint2(head);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    static int index = 0;
    static int [] data = new int[10005];

    /**
     *�ݹ鵽β�����ſ�ʼ���ز���ֵ���뵽������
     */
    public static int[] reversePrint1(ListNode head) {
        if (head==null) return new int[0];
        recursion(head);
        int [] ans = new int[index];
        System.arraycopy(data,0,ans,0,index);
        return ans;
    }

    public static void recursion(ListNode head){
        if (head!=null){
            recursion(head.next);
            data[index++] = head.val;
        }
    }

    /**
     *��ʹ��ջ��ֱ�ӴӶ�̬�����е���ȡ��
     */
    public static int[] reversePrint2(ListNode head){
        if (head==null) return new int[0];
        Deque<Integer> stack = new ArrayDeque<>();
        while (head!=null){
            stack.push(head.val);
            head = head.next;
        }

        int size = stack.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = stack.pop();
        }
        return ans;
    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}