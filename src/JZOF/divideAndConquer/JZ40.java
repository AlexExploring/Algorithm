package JZOF.divideAndConquer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *��С��k����
 */
public class JZ40 {

    public static void main(String[] args) {
        int [] arr = {0,1,2,1};

        int [] ans = getLeastNumbers3(arr,2);

        System.out.println(Arrays.toString(ans));
    }


    /**
     *����
     */
    public static int[] getLeastNumbers1(int[] arr, int k) {
        if (k>=arr.length) return arr;

        Arrays.sort(arr);

        int [] res = new int[k];

        System.arraycopy(arr,0,res,0,k);

        return res;
    }

    /**
     *Ͱ����
     */
    public static int[] getLeastNumbers2(int[] arr, int k) {
        if (k>=arr.length) return arr;

        int [] hel = new int[arr.length+5];

        for (int i = 0; i < arr.length; i++) {
            hel[arr[i]]++;
        }

        int [] res = new int[k];

        int flag = 0;
        for (int i = 0; i < arr.length&&flag<k; i++) {
            while (hel[i]-->0&&flag<k){
                System.out.println(hel[i]);
                res[flag++]=i;
            }
        }

        return res;
    }

    /**
     * С����
     */
    public static int[] getLeastNumbers3(int[] arr, int k) {
        if (k>=arr.length) return arr;
        if (k==0) return new int[0];

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }

        int [] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }

        return res;
    }

    /**
     *�����
     *
     * �����Լ�����ıȽ������Ӷ��õ�������Ҫ�Ĵ󶥶ѣ���С����
     */
    public static int[] getLeastNumbers4(int[] arr, int k) {
        if (k>=arr.length) return arr;
        if (k==0) return new int[0];

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; ++i) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        int [] res = new int[k];
        for (int i = 0; i < k; ++i) {
            res[i] = queue.poll();
        }
        return res;
    }
}
