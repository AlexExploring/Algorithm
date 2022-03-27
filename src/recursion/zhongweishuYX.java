package recursion;

import java.util.PriorityQueue;
import java.util.Scanner;

public class zhongweishuYX {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        int [] a = {1,2};
        int [] b = {3,4};
        diKxiao(a,b);
    }

    public static void diKxiao(int [] a,int [] b){
        PriorityQueue<Integer> p = new PriorityQueue<>();
        int n = a.length+b.length;

        for (int i=0;i < n;i++){
            if (i <= a.length-1)
                p.add(a[i]);
            else {
                p.add(b[i-a.length]);
            }
        }

        int [] c = new int[n];
        for (int i=0;i<n;i++){
            c[i] = p.peek();
            p.poll();
        }

        int j = c.length/2;
        System.out.println(j);
        if (c.length%2==0){
            System.out.println((c[j]+c[j-1])/2);
            System.out.println("d");
        }
        else
            System.out.println(c[j]);

    }
}
