package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class Bubble {
    public static void main(String[] args) {
        int [] a = {5,6,4345,3,6,32412,4234,235,562423};
        bubbleSort1(a);
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
    public static void bubbleSort1(int [] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                if (array[j+1] < array[j]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     *双向冒泡
     */
    public static void bubbleSort2(int [] array){

    }
}
