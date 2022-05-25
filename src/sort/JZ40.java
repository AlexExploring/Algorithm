package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  最小的k个数 (k个数的顺序不作要求)
 */
public class JZ40 {

    /**
     * 使用内置函数排序即可
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k>=arr.length) return arr;

        Arrays.sort(arr);

        int [] res = new int[k];

        System.arraycopy(arr,0,res,0,k);

        return res;
    }

    /**
     * 基于快速排序的数组划分
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        if (arr.length <= k) return arr;
        return quickSort(arr,k,0,arr.length-1);
    }

    public int[] quickSort(int[] array,int k,int left,int right) {

        //选用array[left]为基准数,这里就是每个数组的第一个
        int l = left,r = right,key = array[left];

        while(l < r) {
            //右边当发现小于p的值时停止循环
            while(array[r] >= key && l < r) r--;
            //左边当发现大于p的值时停止循环
            while(array[l] <= key && l < r) l++;
            swap(array,l,r);
        }

        //这里的array[l]一定是大于array[left](key)的，经过l、r交换后l处的值一定是小于array[left](key)的(r先走)
        array[left] = array[l];
        //将基准数移动到它应该在的位置
        array[l] = key;
        //到这里，l和r是相等的，且array[l]处的值已经固定，不再参与排序
        // l > k : 代表第k+1 小的数字在 左子数组 中，则递归左子数组；
        if (l > k) quickSort(array,k,left,l-1);
        // l < k : 代表第k+1 小的数字在 右子数组 中，则递归右子数组；
        if (l < k) quickSort(array,k,l+1,right);
        // l == k : 代表此时 arr[k] 即为第 k+1 小的数字，则直接返回数组前 k 个数字即可；
        return Arrays.copyOf(array,k);
    }

    public void swap(int [] array,int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 小根堆
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k >= arr.length) return arr;
        if (k == 0) return new int[0];

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
}
