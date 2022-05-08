package sort.template;

/**
 * @author zhxspacex
 * @date 2020/12/25 12:29
 */

import java.util.Arrays;

/**
 * 计数排序简介：计数排序的核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。
 * 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
 */
public class Count {

    public static void main(String[] args) {

    }

    private int[] countingSort(int[] array) {
        //需要确定最大值，这里使用流来做计算
        int max = Arrays.stream(array).max().getAsInt();
        int bucketLen = max + 1;
        int[] bucket = new int[bucketLen];

        for (int value : array) {
            bucket[value]++;
        }

        int index = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                array[index++] = j;
                bucket[j]--;
            }
        }

        return array;
    }

}
