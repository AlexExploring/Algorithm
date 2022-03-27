package recursion;

import java.util.PriorityQueue;
//题目：
//给定两个有序数组arr1和arr2，已知两个有序数组的长度都为N，求两个数组中所有数的上中位数，要求时间复杂度为O（logN），空间复杂度为O（1）
public class median {

    public static void main(String[] args) {
        int [] a = {1,2,3,4};
        int [] b = {3,4,5,6};
        zhong1(a,b);
        System.out.println("递归方法");
        System.out.println(zhong2(a,b));
    }

    //常规方法
    public static void zhong1(int [] a,int [] b){
        PriorityQueue<Integer> p = new PriorityQueue<>();
        int n = a.length+b.length;
        for (int i=0;i < n;i++){
            if (i <= a.length-1)
                p.add(a[i]);
            else {
                p.add(b[i-a.length]);
            }
        }

        int m = n/2;
        for (int i=0;i<m-1;i++){
            p.poll();
        }
        System.out.println(p.peek());
    }

    //递归
    public static int zhong2(int [] a,int [] b){
        if (a == null || b == null)
            return -1;
        return find(a,0,a.length-1,b,0,b.length-1);
    }

    public static int find(int [] arr1,int l1,int r1,int [] arr2,int l2,int r2){
        int mid1 = l1+(r1-l1)/2;
        int mid2 = l2+(r2-l2)/2;

        //表示数组只剩下一个数，把两个数组中较小的数返回去
        if (l1 >= r1){
            return Math.min(arr1[l1],arr2[l2]);
        }

        int offest = ((r1-l1+1)&1)^1;//元素个数为奇数，则offset为0，为偶数则为1

        ///每一次进行一次选择
        if (arr1[mid1] < arr2[mid2]){
            return find(arr1,mid1+offest,r1,arr2,l2,mid2);
        }
        else if (arr1[mid1] > arr2[mid2]){
            return find(arr1,l1,mid1,arr2,mid2+offest,r2);
        }
        else {
            return arr1[mid1];//返回arr2[mid2]也可以
        }
    }


}
