package recursion;

import java.util.PriorityQueue;
import java.util.Scanner;

public class diKxiao {

    public static void main(String[] args) {
        int [] a = {1,2,3,4};
        int [] b = {3,4,5,6};
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        diKxiao(a,b,k);
    }

    public static void diKxiao(int [] a,int [] b,int k){
        PriorityQueue<Integer> p = new PriorityQueue<>();
        int n = a.length+b.length;
        for (int i=0;i < n;i++){
            if (i <= a.length-1)
                p.add(a[i]);
            else {
                p.add(b[i-a.length]);
            }
        }

        for (int i=0;i<k-1;i++){
            p.poll();
        }
        System.out.println(p.peek());
    }

    public static void diKxiao(){

    }
}


