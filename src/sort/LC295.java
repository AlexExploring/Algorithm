package sort;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ����������λ��
 */
public class LC295 {
    public static void main(String[] args) {

    }
}

/**
 * ����һ
 */
class MedianFinder {

    Queue<Integer> A, B;

    /** initialize your data structure here. */
    public MedianFinder() {
        A = new PriorityQueue<>(); // С���ѣ�����ϴ��һ��
        B = new PriorityQueue<>((x, y) -> (y - x)); // �󶥶ѣ������С��һ��
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
 * ���ֲ���
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

    //���ֲ��ң����ҵ�һ����С��num��ֵ���򷵻ص�������ֵ��һ�����ڵ���num��ֵ��
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
 * addNum(num) ������
 *
 * 1.�� m = n���� NΪ ż���������� A ���һ��Ԫ�ء�ʵ�ַ���������Ԫ�� num������ B ���ٽ� B �Ѷ�Ԫ�ز����� A ��
 * 2.�� m =n���� N Ϊ ������������ B ���һ��Ԫ�ء�ʵ�ַ���������Ԫ�� num ������ A ���ٽ� A �Ѷ�Ԫ�ز����� B ��
 *
 * ����������� num������� 1. ������ num �������� ����С��һ�롱 �������� B ������˲��ܽ� nums ֱ�Ӳ����� A
 * ����Ӧ�Ƚ� num ������ B ���ٽ� B �Ѷ�Ԫ�ز����� A �������Ϳ���ʼ�ձ��� A ����ϴ�һ�롢 B �����Сһ�롣
 *
 * ��֤�󶥶��е�����ԶС�ڵ���С���ѵĶѶ�Ԫ�أ����Ҵ�С�����1
 */
class MedianFinder2 {
    private Queue<Integer> A, B;
    public MedianFinder2() {
        this.A = new PriorityQueue<>(); // С���ѣ�����ϴ��һ��
        this.B = new PriorityQueue<>((x, y) -> (y - x)); // �󶥶ѣ������С��һ��
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


