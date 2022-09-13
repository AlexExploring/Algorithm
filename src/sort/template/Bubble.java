package sort.template;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class Bubble {
    public static void main(String[] args) {
        int [] a = {12,10,23,5,3,9,16,11,8,6,6,6,6,4,4,4,333,3,3,3};
        new Bubble().bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，
     * 如果它们的顺序错误就把它们交换过来。共需要n-1轮（n是数组的长度），每一轮确
     * 定一个数的正确位置。如果是从小到大排序，则右边部分是有序的反之，则是左边部分
     * 有序。
     *
     * 算法分析：最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
     */
    public void bubbleSort(int [] array){
        int len = array.length;
        //只需要确定len-1个数的位置，剩下一个数的位置自然就被确定了
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (array[j] > array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
