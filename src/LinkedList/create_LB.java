package LinkedList;

import java.util.Scanner;

public class create_LB {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        ListNide head = null,tail = null;//定义了一个头指针，和一个尾指针
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
    }
}

class ListNide {
    int data;
    ListNide next;
}