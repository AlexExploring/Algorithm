package LinkedList;

import java.util.Scanner;

/**
 * 反转链表
 */
public class LC206 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        ListNide head = null,tail = null;
        for (int i=0;i < n;i++){
            ListNide s = new ListNide();
            s.data = scan.nextInt();
            if (i==0){
                head = s;
            }
            else tail.next=s;
            tail=s;
        }
        tail.next=null;

        ListNide p = head;
        while (p != null){
            System.out.println(p.data);
            p = p.next;
        }
        System.out.println();
        ListNide newList = reverseList1(head);
        System.out.println("反转后");
        ListNide p1 = newList;
        while (p1 != null){
            System.out.println(p1.data);
            p1 = p1.next;
        }

    }

    public static ListNide reverseList(ListNide head){
        //当单链表为空或者只有一个节点
        if (head == null || head.next == null){
            return head;
        }
        //递归反转 子链表
        ListNide newList = reverseList(head.next);

        //改变1，2节点的指向
        //通过head.next获取节点2
        ListNide t1 = head.next;
        t1.next = head;
        head.next = null;
        return newList;
    }

    //1->2->3->4->5 翻转后 可以看作是1<-2<-3<-4<-5 在这一过程中 pre从1移到5
    public static ListNide reverseList1(ListNide head){
        ListNide next = null;//当前节点的后驱，由于中途链表会被截断，防止信息丢失。
        ListNide pre = null;
        while (head != null){
            next = head.next;
            //当前节点的后驱指向前驱
            head.next = pre;
            //更新pre指向的位置，初始时pre指向null
            pre = head;
            //处理下一个节点
            head = next;
        }
        return pre;
    }
}
