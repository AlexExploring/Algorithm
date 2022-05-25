package sort;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 数据流的中位数
 */
public class LC295 {
    public static void main(String[] args) {

    }
}

/**
 * 方法一
 */
class MedianFinder {

    Queue<Integer> A, B;

    /** initialize your data structure here. */
    public MedianFinder() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }

    public void addNum(int num) {
        if(A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}

/**
 * 二分查找
 */
class MedianFinder1 {

    private int [] arr;
    private int total;

    /** initialize your data structure here. */
    public MedianFinder1() {
        this.arr = new int[50010];
        this.total = 0;
    }

    public void addNum(int num) {
        int index = binary(arr,num,total);
        int end = total-1;
        while (end >= index){
            arr[end+1] = arr[end];
            end--;
        }
        arr[index] = num;
        total++;
    }

    //二分查找，查找第一个不小于num的值，则返回的索引的值是一个大于等于num的值，
    public int binary(int [] arr,int num,int total){
        int left = 0,right = total - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (arr[mid] < num){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }

    public double findMedian() {
        if (total%2==0){
            return ((arr[total/2])+(arr[total/2-1]))/2.0;
        }else {
            return arr[total/2]*1.0;
        }
    }
}


/**
 * addNum(num) 函数：
 *
 * 1.当 m = n（即 N为 偶数）：需向 A 添加一个元素。实现方法：将新元素 num插入至 B ，再将 B 堆顶元素插入至 A ；
 * 2.当 m =n（即 N 为 奇数）：需向 B 添加一个元素。实现方法：将新元素 num 插入至 A ，再将 A 堆顶元素插入至 B ；
 *
 * 假设插入数字 num遇到情况 1. 。由于 num 可能属于 “较小的一半” （即属于 B ），因此不能将 nums 直接插入至 A
 * 。而应先将 num 插入至 B ，再将 B 堆顶元素插入至 A 。这样就可以始终保持 A 保存较大一半、 B 保存较小一半。
 *
 * 保证大顶堆中的数永远小于等于小顶堆的堆顶元素，并且大小差不超过1
 */
class MedianFinder2 {
    private Queue<Integer> A, B;
    public MedianFinder2() {
        this.A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        this.B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }
    public void addNum(int num) {
        if(A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }
    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}


