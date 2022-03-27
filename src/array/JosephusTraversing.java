package array;

public class JosephusTraversing {

    public static void main(String[] args) {
        int [] a = {1,2,3,4,5,6};
        int k = 7;
        String greeting = "asdfa";
        System.out.println(greeting);
        System.out.println(solution1(a,k));
        System.out.print(solution2(6,7));
    }

    public static int solution1(int [] arr,int k){
        int flag = 0,n = arr.length,t = 0,ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) flag++;
            if (flag == k){
                arr[i] = 0;flag = 0;t++;
            }
            if (t == n-1) break;
            if (i == n-1) i = -1; //使数组成为一个循环数组
        }
        for (int i = 0; i < n; i++)
            if (arr[i] != 0){
                ans = arr[i];break;
            }
        return ans;
    }

    public static int solution2(int n,int k){
        if (k == 1 || n < 2) return n;

        Node head = createLinkedList(n);

        int count = 1,flag = 0;
        Node cur = head;
        Node pre = null;
        //head.next != head为什么不行？
        while (cur.next != cur){
            if (count == k){
                System.out.println(cur.data);
                flag++;
                count = 1;
                pre.next = cur.next;
                cur = pre.next;
            }else {
                count++;
                pre = cur;
                cur = cur.next;
            }
        }
        System.out.println(head.data);//head为什么还有数据？

        return cur.data;
    }

    public static int solution3(int n,int k){
        return n == 1 ? n : (solution3(n-1,k)+k-1) % n + 1;
    }


    public static Node createLinkedList(int n){
        Node head = new Node(1);
        Node next = head;
        for (int i = 2; i <= n; i++) {
            Node temp = new Node(i);
            next.next = temp;//将新节点和尾节点连接起来
            next = next.next;//使新节点成为尾节点
        }
        next.next = head;//首尾节点相连
        return head;
    }
}

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }
}