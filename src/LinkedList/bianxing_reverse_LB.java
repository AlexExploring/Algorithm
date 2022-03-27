package LinkedList;

import java.util.Scanner;
//参考链接 https://mp.weixin.qq.com/s/WNO3KNhS6oU7rUvCNEGw8g
public class bianxing_reverse_LB {
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

        head = reverseKGroup(head,3);

        ListNide p = head;
        while (p != null){
            System.out.println(p.data);
            p = p.next;
        }
    }

    public static ListNide reverseKGroup(ListNide head, int k){
        ListNide temp = head;
        for (int i = 1; i < k&& temp != null; i++) {
            temp = temp.next;
        }

        //判断节点数量是否够一组
        if (temp == null) return head;
        //t2即为下一部分的头节点
        ListNide t2 = temp.next;
        //断开链表，分组
        temp.next = null;

        ListNide newHead = reverseList(head);
        //newTemp即为下一部分 分组，反转后的头节点
        ListNide newTemp = reverseKGroup(t2,k);

        //将两部分连接起来
        head.next = newTemp;

        return newHead;
    }

    //1->2->3->4->5 翻转后 可以看作是1<-2<-3<-4<-5 在这一过程中 pre从1移到5
    public static ListNide reverseList(ListNide head){
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

