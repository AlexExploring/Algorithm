package sort.template;

import java.util.Arrays;

/**
 * @author zhxspacex
 * @date 2020/12/25 12:28
 */
public class Quick {

    public static void main(String[] args) {
        int [] a = {12,10,23,5,3,9,16,11,8,6,6,6,6,4,4,4,333,3,3,3};
        quickSort1(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 快速排序算法
     */
    public static void quickSort(int [] array, int left, int right)
    {
        if (left >= right) return;

        //因为使用的是do while 循环，所以l=left-1,r = right+1, 选用数组区间的中间数key为基准数
        int l = left - 1, r = right + 1, key = array[left + right >> 1];

        while (l < r) {
            //必须先从左向右扫描
            do l++ ; while (array[l] < key);
            do r-- ; while (array[r] > key);
            if (l < r) swap(array,l, r);
        }

        quickSort(array, left, r);
        quickSort(array, r + 1, right);
    }

    public static void quickSort1(int [] array, int left, int right) {
        if (left >= right) return;

        int l = left,r = right,key = array[left + right >> 1];

        while (l < r) {
            while (array[l] < key) l++;
            while (array[r] > key) r--;
            if (l < r) swap(array,l++,r--);
        }

        quickSort(array,left,r);
        quickSort(array,r+1,right);

    }

    public static void swap(int [] array,int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
