package sort.template;

import java.util.Arrays;

/**
 * 插入排序
 *
 * 思路：每次将一个数字插入一个有序的数组里，成为一个长度更长的有序数组，
 * 有限次操作以后，数组整体有序。
 */
public class Insertion {
    public static void main(String[] args) {
        int [] a = {562423,5,6,4345,3,6,32412,4234,235};
        InsertionSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void InsertionSort(int [] array){
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            int curr = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && curr < array[preIndex]) {
                //后移
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            //因为while循环中，执行了preIndex--，不满足循环条件再退出，所以需要加1，将curr放到正确的位置
            array[preIndex + 1] = curr;
        }
    }
}

