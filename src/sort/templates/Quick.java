package sort.templates;

import java.util.Arrays;

/**
 * @author zhxspacex
 * @date 2020/12/25 12:28
 */
public class Quick {

    public static void main(String[] args) {
        int [] a = {12,10,23,5,3,9,16,11,8};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 快速排序算法——partition
     * @param array
     * @param l
     * @param r
     * @return
     */

    public static void quickSort(int array[], int l, int r)
    {
        if (l >= r) return;

        int i = l - 1, j = r + 1, x = array[l + r >> 1];//x为基准数
        while (i < j)
        {
            //必须先从左向右扫描
            do i ++ ; while (array[i] < x);
            do j -- ; while (array[j] > x);
            System.out.println(array[i]+"  "+array[j]);
            if (i < j) swap(array,i, j);
        }
        quickSort(array, l, j);
        quickSort(array, j + 1, r);
    }

    public static void swap(int [] array,int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
